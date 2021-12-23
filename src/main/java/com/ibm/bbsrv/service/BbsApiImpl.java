package com.ibm.bbsrv.service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.bbsrv.constants.Constants;
import com.ibm.bbsrv.controller.BbsApi;
import com.ibm.bbsrv.dao.BedbookingDao;
import com.ibm.bbsrv.entities.BedBooking;
import com.ibm.bbsrv.exception.BedBookingPatientException;
import com.ibm.bbsrv.exception.CustomException;
import com.ibm.bbsrv.exception.InvalidRequestException;
import com.ibm.bbsrv.exception.PatientPendingException;
import com.ibm.bbsrv.mapper.BookingMapper;
import com.ibm.bbsrv.model.AutoConfirmRequest;
import com.ibm.bbsrv.model.BasConfirmRequest;
import com.ibm.bbsrv.model.BasStatusResponse;
import com.ibm.bbsrv.model.BedAvailableInPinCode;
import com.ibm.bbsrv.model.BedBookingStatusResponse;
import com.ibm.bbsrv.model.BookingConfirmRequest;
import com.ibm.bbsrv.model.BookingConfirmResponse;
import com.ibm.bbsrv.model.BookingResponse;
import com.ibm.bbsrv.model.BookingUserData;
import com.ibm.bbsrv.model.HospitalConfirm;
import com.ibm.bbsrv.model.PatientUpdate;
import com.ibm.bbsrv.repository.BedBookingRepo;
import com.ibm.bbsrv.utils.jwtutils.jwtUtil;

@Service
public class BbsApiImpl implements BbsApi {

	private static final Logger logger = LoggerFactory.getLogger(BbsApiImpl.class);

	@Value("${services.host.bas}")
	private String basHost;

	@Value("${services.host.patientSrvc}")
	private String patientSrvcHost;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BedBookingRepo booking;

	@Autowired
	BookingMapper bookingMapper;
	
	@Autowired
	BedbookingDao bedbookingDao;

	/**
	 * Bed Booking Confirm API - Start This API is called by Front End to confirm
	 * Bed Booking
	 * @throws CustomException 
	 * 
	 * @throws UpdateConfirmStatusInBasServiceException
	 * @throws BookingBedtoPatientServiceException
	 * 
	 */

	public BookingConfirmResponse confirmBooking(String xTokenID, String bookingId,
			BookingConfirmRequest bookingUserData) throws CustomException {

		logger.info("Confirm API - Booking ID :" + bookingId);
		BedBooking bb = booking.findByBookingID(bookingId);
		logger.info("Confirm API - :" + bb);
		bb.setStatus(Constants.CONFIRMED);
		logger.info("Confirm API - After setting Status:" + bb);
		sendBookingIDtoPatientSrvc(xTokenID, bookingUserData, bookingId, bb);
		updateConfirmStatusInBas(xTokenID, bookingUserData, bb);

		BookingConfirmResponse response = new BookingConfirmResponse();
		response.setBookingId(bookingId);
		response.setBookingStatus(Constants.CONFIRMED);

		HospitalConfirm hc = new HospitalConfirm();
		hc.setHospitalName(bookingUserData.getHospitalName());
		hc.setHospitalId(bookingUserData.getHospitalId());
		hc.setHospitalBranchId(bookingUserData.getHospitalBranchId());
		hc.setLocationDetail(bookingUserData.getLocationDetail());
		hc.setBed(bookingUserData.getBed());

		response.setHospital(hc);

		booking.save(bb);
		return response;
	}

	private Boolean updateConfirmStatusInBas(String xTokenID, BookingConfirmRequest bookingUserData, BedBooking bb) throws CustomException {
		try {
			logger.info("Confirm API - Updating Confirm Status in bas");
			BasConfirmRequest bcr = new BasConfirmRequest();
			bcr.setBedId(bookingUserData.getBed().getBedId());
			bcr.setBookingId(bb.getBookingID());
			bcr.setStatus(Constants.CONFIRMED);

			String basSrv = basHost + "/bas/_updateStatus";
			logger.debug("Confirm API - BAS Url : " + basSrv);
			HttpHeaders httpheaders = new HttpHeaders();
			httpheaders.add(Constants.TOKEN, xTokenID);
			HttpEntity<BasConfirmRequest> dre = new HttpEntity<BasConfirmRequest>(bcr, httpheaders);

			ResponseEntity<Boolean> dResponseEntity = restTemplate.exchange(basSrv, HttpMethod.PUT, dre, Boolean.class);
			logger.info("Confirm API - updateConfirmStatusInBas Response from BAS:" + dResponseEntity.getBody());
			return dResponseEntity.getBody();
		} catch (Exception ex) {
			logger.error("BOOK API - updateConfirmStatusInBas()  :" + ex.getMessage());
			throw new CustomException("BOOK API - BAS update status service not available");
		}
	}

	private Boolean sendBookingIDtoPatientSrvc(String xTokenID, BookingConfirmRequest bookingUserData, String bookingId,
			BedBooking bb) throws CustomException {
		try {
			logger.info("Confirm API - Updating Booking ID in Patient Service");

			String patientSrv = patientSrvcHost + "/patient/" + bb.getPatientId() + "/_update";
			logger.info("Confirm API - Patient Service URL:" + patientSrv);
			HttpHeaders httpheaders = new HttpHeaders();
			httpheaders.add(Constants.TOKEN, xTokenID);
			PatientUpdate pu = new PatientUpdate(bookingId, bookingUserData.getHospitalName());
			logger.debug("Confirm API - PatientUpdate: " + pu);
			HttpEntity<PatientUpdate> dre = new HttpEntity<PatientUpdate>(pu, httpheaders);
			logger.debug("Confirm API - Rest Template");
			ResponseEntity<Boolean> dResponseEntity = restTemplate.exchange(patientSrv, HttpMethod.PUT, dre,
					Boolean.class);
			logger.info("Confirm API - sendBookingIDtoPatientSrvc Response:" + dResponseEntity.getBody());
			return dResponseEntity.getBody();
		} catch (Exception ex) {
			logger.error("BOOK API - sendBookingIDtoPatientSrvc()  :" + ex.getMessage());
			throw new CustomException("BOOK API - Update Patient api service not available");
		}
	}

	/**
	 * Bed Booking Confirm API - End
	 */

	/**
	 * Bed Booking Delete API - Start This API is called by discharge API of Bed
	 * Availability Service
	 */

	public Boolean deleteBooking(String xTokenID, String bookingId) {
		booking.deleteById(bookingId);
		return true;
	}

	/**
	 * Bed Booking Delete API - End
	 */

	/**
	 * Bed Booking Status API - Start This API is called by Front End to get Bed
	 * Booking Status
	 * @throws CustomException 
	 * 
	 * @throws BedAvailaibilityServiceException
	 * 
	 */

	public BedBookingStatusResponse getBookingStatus(String xTokenID, String bookingId) throws CustomException {

		logger.info("Status API - Called for Booking ID : " + bookingId);
		BedBooking bedbooking = booking.findByBookingID(bookingId);

		BedBookingStatusResponse bc = new BedBookingStatusResponse();
		bc.setBookingId(bedbooking.getBookingID());
		bc.setBookingStatus(bedbooking.getStatus());
		ResponseEntity<BasStatusResponse> basResponse = null;
		if (bedbooking.getStatus().equals(Constants.CONFIRMED)) {
			basResponse = getBedStatusFromBas(xTokenID, bookingId, bedbooking);
		}
		logger.info("Status API - Creating Booking Status Response ");

		if (basResponse != null) {
			bc.setHospital(basResponse.getBody().getHospital());
		}
		logger.info("Status API - Final Response : " + bc);
		return bc;

	}

	private ResponseEntity<BasStatusResponse> getBedStatusFromBas(String xTokenID, String bookingId,
			BedBooking bedbooking) throws CustomException {
		try {
			String url = basHost + "/bas/" + bookingId + "/_getBedDetailsFromBookingId";
			logger.info("Status API - bas Url :" + url);

			HttpHeaders httpheaders = new HttpHeaders();
			httpheaders.add(Constants.TOKEN, xTokenID);
			HttpEntity<String> dre = new HttpEntity<String>(bookingId, httpheaders);

			ResponseEntity<BasStatusResponse> dResponseEntity = restTemplate.exchange(url, HttpMethod.GET, dre,
					BasStatusResponse.class);

			logger.info("Status API - BasStatusResponse: " + dResponseEntity);

			return dResponseEntity;
		} catch (Exception ex) {
			logger.error("BOOK API - getBedStatusFromBas(){}  :" + ex.getMessage());
			throw new CustomException("BOOK API - BAS - getBedDetailsFromBookingId api service not available");
		}
	}

	/**
	 * Bed Booking Status API - End
	 */

	/**
	 * Bed Booking Book API - Start This API is called by Front End to Book a Bed
	 * @throws BedBookingPatientException 
	 * @throws CustomException
	 * @throws PatientPendingException 
	 */

	public BookingResponse reserveBed(String xTokenID, BookingUserData bookingUserData) throws BedBookingPatientException {
		
		try {
			BookingResponse br = new BookingResponse();
			BedBooking bedBookingId = bedbookingDao.findBookingStatus(bookingUserData.getPatientId());
				
			if (Objects.isNull(bedBookingId)) {
				createBedBookingData(xTokenID, bookingUserData);
				ResponseEntity<BedAvailableInPinCode> reponseEntityHosp = getBedAvailaibilityDetails(xTokenID,
						bookingUserData);
				logger.info("Fetching the hospital details from BAS service using pincode ");
				BedBooking pendingBedBookingId = bedbookingDao.findBookingPendingStatus(bookingUserData.getPatientId());
				br.setBookingId(pendingBedBookingId.getBookingID().toString());
				br.setBookingStatus(Constants.PENDING);
				br.setWaitingNumber(booking.getWaitingNumber() + "");
				br.setHospitals(reponseEntityHosp.getBody().getHospitals());
				logger.info("Book API - Response : " + br);
			}else {
				throw new BedBookingPatientException("Confirmed Bed to Patient");
			}
			return br;
		} catch (Exception ex) {
			logger.error("BOOK API - Booking Bed to Patient Error");
			throw new BedBookingPatientException("BOOK API - Confirmed Bed to Patient");
		}
		
	}

	@Override
	public void autoConfirm(String xTokenID, AutoConfirmRequest autoConfirmRequest) throws CustomException {
		List<BookingConfirmRequest> listBookingConfirmRequest=bookingMapper.mapAutoConfirmReq(autoConfirmRequest);

		listBookingConfirmRequest.forEach(bookingConfirmReq -> {
			List<BedBooking> bedBookings;
			if (Objects.nonNull(bookingConfirmReq) && Objects.nonNull(bookingConfirmReq.getLocationDetail())
					&& Objects.nonNull(bookingConfirmReq.getLocationDetail().getPinNumber())) {
				bedBookings = booking.findAll().stream().filter(
						bedBooking -> Constants.PENDING.equalsIgnoreCase(bedBooking.getStatus()) && bookingConfirmReq
								.getLocationDetail().getPinNumber().equalsIgnoreCase(bedBooking.getPatientPinCode()))
						.sorted(Comparator.comparing(BedBooking::getBookingDateTime)).collect(Collectors.toList());
			} else {
				throw new InvalidRequestException("Location details are invalid or not present");
			}

			if (!bedBookings.isEmpty()) {
				try {
					confirmBooking(xTokenID, bedBookings.get(0).getBookingID(), bookingConfirmReq);
				} catch (CustomException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ResponseEntity<BedAvailableInPinCode> getBedAvailaibilityDetails(String xTokenID,
			BookingUserData bookingUserData) throws CustomException {
		try {
			String url = basHost + "/bas/" + bookingUserData.getPatientLocationDetails().getPinNumber()
					+ "/_getBedAvailableByPinCode";
			System.out.println(url);
			HttpHeaders httpheaders = new HttpHeaders();
			httpheaders.add(Constants.TOKEN, xTokenID);
			HttpEntity<String> dre = new HttpEntity<String>("Parameters", httpheaders);

			ResponseEntity<BedAvailableInPinCode> dResponseEntity = restTemplate.exchange(url, HttpMethod.GET, dre,
					BedAvailableInPinCode.class);

			return dResponseEntity;
		} catch (Exception ex) {
			logger.error(
					"BOOK API -getBedAvailaibilityDetails(){}:: Bed Availaibility Service error  :" + ex.getMessage());
			throw new CustomException("BOOK API - Bed Availaibility API By pincode not avalable");
		}

	}

	private void createBedBookingData(String xTokenID,BookingUserData bookingUserData) throws PatientPendingException{
		try {
			BedBooking patientPendingStatus = bedbookingDao.findBookingPendingStatus(bookingUserData.getPatientId());
			if (Objects.isNull(patientPendingStatus)) {
				BedBooking bb = new BedBooking();
				bb.setGuardianID((String) jwtUtil.getGuardianIDFromToken(xTokenID));
				bb.setStatus(Constants.PENDING);
				bb.setPatientId(bookingUserData.getPatientId());
				bb.setPatientPinCode(bookingUserData.getPatientLocationDetails().getPinNumber());
				bb.setBookingDateTime(new Timestamp(System.currentTimeMillis()));
				booking.save(bb);
			}
		} catch (Exception ex) {
			logger.error("BOOK API -Fetching the patient pending data error");
			throw new PatientPendingException("BOOK API - Fetching the patient pending data ");
		}
	}
	/**
	 * Bed Booking Book API - End
	 */
}
