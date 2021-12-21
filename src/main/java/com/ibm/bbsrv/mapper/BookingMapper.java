package com.ibm.bbsrv.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.bbsrv.model.AutoConfirmRequest;
import com.ibm.bbsrv.model.Bed;
import com.ibm.bbsrv.model.BookingConfirmRequest;

@Component
public class BookingMapper {

    public List<BookingConfirmRequest> mapAutoConfirmReq(AutoConfirmRequest autoConfirmRequest){
    	
    	List<BookingConfirmRequest> listBookingConfirmRequest = new ArrayList<>();
        if (null == autoConfirmRequest){
            return null;
        }
      for(Bed bed:autoConfirmRequest.getBed()) {
        BookingConfirmRequest  bookingConfirmRequest = new BookingConfirmRequest();

        bookingConfirmRequest.setHospitalBranchId(autoConfirmRequest.getHospitalBranchId());
        bookingConfirmRequest.setHospitalId(autoConfirmRequest.getHospitalId());
        bookingConfirmRequest.setBed(bed);
        bookingConfirmRequest.setLocationDetail(autoConfirmRequest.getLocationDetail());
        listBookingConfirmRequest.add(bookingConfirmRequest);
      }
        return listBookingConfirmRequest;
    }
}
