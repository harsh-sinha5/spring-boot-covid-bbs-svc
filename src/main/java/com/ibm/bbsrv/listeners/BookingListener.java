package com.ibm.bbsrv.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.bbsrv.exception.CustomException;
import com.ibm.bbsrv.model.AutoConfirmRequest;
import com.ibm.bbsrv.service.BbsApiImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * Declarative Kafka Consumer for Auto Booking
 * for configuration refer application.yaml
 * @author harsh.sinha1
 */

@Configuration
public class BookingListener {

    private static final Logger logger = LoggerFactory.getLogger(BookingListener.class);

    @Autowired
    BbsApiImpl bbsApi;

    @Bean
    public Consumer<String> autoConfirm(){
        return autoConfirmRequest -> {
            ObjectMapper mapper = new ObjectMapper();
            AutoConfirmRequest request = null;
            try {
                request = mapper.readValue(autoConfirmRequest, AutoConfirmRequest.class);
                logger.info("Message consumed");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            try {
                bbsApi.autoConfirmBooking(request);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        };
    }
}