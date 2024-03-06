package com.shophandmade.controller.dashBoard;

import com.shophandmade.service.dashBoard.dashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashBoard")
@RequiredArgsConstructor
public class dashBoardController {

    private final dashBoardService dashBoardService;

    @GetMapping("/details")
    public ResponseEntity<Map<String, Object>> laySoLuong() {
        return dashBoardService.getCount();
    }

}
