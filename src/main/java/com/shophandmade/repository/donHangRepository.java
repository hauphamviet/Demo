package com.shophandmade.repository;

import com.shophandmade.entity.donHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface donHangRepository extends JpaRepository<donHangEntity, Integer> {

    @Query(value = "SELECT d FROM donHangEntity d WHERE d.khachhang =: id")
    List<donHangEntity> getDonHangByKhachHang(Integer id);

    Optional<donHangEntity> findByHoTen(String hoTen);

}
