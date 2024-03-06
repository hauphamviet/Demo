package com.shophandmade.service.dashBoard;

import com.shophandmade.repository.danhMucSanPhamRepository;
import com.shophandmade.repository.donHangRepository;
import com.shophandmade.repository.sanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class dashBoardServiceImpl implements dashBoardService{

    private final sanPhamRepository sanPhamRepository;
    private final donHangRepository donHangRepository;
    private final danhMucSanPhamRepository danhMucSanPhamRepository;

    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("danhMucSanPham", danhMucSanPhamRepository.count());
        map.put("sanPham", sanPhamRepository.count());
        map.put("donHang", donHangRepository.count());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
