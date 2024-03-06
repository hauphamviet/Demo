package com.shophandmade.service.dashBoard;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface dashBoardService {

    ResponseEntity<Map<String, Object>> getCount();

}
