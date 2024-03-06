package com.shophandmade.repository;

import com.shophandmade.entity.danhMucSanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface danhMucSanPhamRepository extends JpaRepository<danhMucSanPhamEntity, Integer> {

//    ResponseEntity<String> updateDMSP(Map<String, String> requestMap);
}
