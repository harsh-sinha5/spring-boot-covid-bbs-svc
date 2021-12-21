package com.ibm.bbsrv.TestResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bbsrv.TestResponse.model.Bed;
import com.ibm.bbsrv.TestResponse.model.Branch;
import com.ibm.bbsrv.TestResponse.model.Hospital;
import com.ibm.bbsrv.TestResponse.model.Location;
import com.ibm.bbsrv.controller.BbsApiController;
import com.ibm.bbsrv.model.BasConfirmRequest;
import com.ibm.bbsrv.model.PatientUpdate;
import com.ibm.bbsrv.model.patientSrvc.PatientRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class getBedDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(getBedDetailsController.class);

	@RequestMapping(value = "/bas/{pinCode}/_getBedAvailableByPinCode",
	        method = RequestMethod.GET)
	Hospital getBedDetailsBycityName(@ApiParam(value = "A JWT token which will be returned as part of login and will have user role details." ,required=true) @RequestHeader(value="X-Token-ID", required=true) String xTokenID,@ApiParam(value = "Pin code",required=true) @PathVariable("pinCode") String pinCode) {
		logger.info("Internal Test _getBedAvailableByPinCode Called" );
		Hospital h1=new Hospital();
		Branch b1=new Branch();
		
		Bed bd1=new Bed();
		bd1.setBedId("1");
		bd1.setBedType("Single");
		bd1.setBedFacility("Ventilator");
		
		Bed bd2=new Bed();
		bd2.setBedId("2");
		bd2.setBedType("Double");
		bd2.setBedFacility("Oxygen");
		
		List<Bed> lbed=new ArrayList();
		lbed.add(bd1);
		lbed.add(bd2);
		
		b1.setBranchId("Brch-1");
		b1.setBeds(lbed);
		b1.setLocation(new Location("Pune","410506"));
		List<Branch> lbranch=new ArrayList();
		lbranch.add(b1);
		
		h1.setBranches(lbranch);
		h1.setName("Max");
		
		return h1;
	}

	@RequestMapping(value = "/patient/_register",
	        method = RequestMethod.POST)
	    String createUser(@RequestHeader(value="X-Token-ID", required=true) String xTokenID,@RequestBody PatientRequest patientData) {
		logger.info("Internal Test /patient/_register Called" );
		UUID uuid=UUID.randomUUID();
		return uuid.toString();

	}

	@ApiOperation(value = "Update patient", nickname = "updatePatient", notes = "Update petient", response = Boolean.class, tags={  })
    @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
    @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
    @ApiResponse(code = 404, message = "School Not Found", response = Error.class),
    @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
    @RequestMapping(value = "/patient/{patientId}/_update",
        method = RequestMethod.PUT)
    Boolean updatePatient(@ApiParam(value = "A JWT token which will be returned as part of login and it will contain loginId and role.",required=true) @PathVariable("patientId") String patientId,@ApiParam(value = "Patient information to book the bed." ,required=true )  @RequestBody PatientUpdate patientData){
		logger.info("Internal Test /patient/{patientId}/_update Called" );
		return true;
	}
	
	 @ApiOperation(value = "", nickname = "updateBedStatus", notes = "Update the bed status using the bed id", response = Boolean.class, tags={  })
	 @ApiResponses(value = { 
	 @ApiResponse(code = 200, message = "Returns true or false based on the successfull and unsuccessfull posting", response = Boolean.class),
	 @ApiResponse(code = 400, message = "Invalid input", response = Error.class),
	 @ApiResponse(code = 404, message = "School Not Found", response = Error.class),
	 @ApiResponse(code = 405, message = "Validation Exception", response = Error.class) })
	 @RequestMapping(value = "/bas/_updateStatus",
	        method = RequestMethod.PUT)
	 Boolean updateBedStatus(@RequestBody BasConfirmRequest basConfirmRequest) {
		 logger.info("Internal Test /bas/_updateStatus Called" );
		 return true;
	 }


}