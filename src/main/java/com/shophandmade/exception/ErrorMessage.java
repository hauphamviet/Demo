package com.shophandmade.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
//https://developer.mozilla.org/en-US/docs/Web/HTTP/Status cac status code
public class ErrorMessage {

    private int statusCode;
    private Date timestamp;
    private List<String> message;
    private String description;

}
