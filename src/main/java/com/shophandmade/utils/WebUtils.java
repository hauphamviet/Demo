package com.shophandmade.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WebUtils {

    private WebUtils() {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>("message : "+ responseMessage, httpStatus);
    }

}
