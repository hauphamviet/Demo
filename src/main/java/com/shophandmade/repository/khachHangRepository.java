package com.shophandmade.repository;

import com.shophandmade.entity.khachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface khachHangRepository extends JpaRepository<khachHangEntity, Integer> {

    khachHangEntity findByEmail(String email);

    Optional<khachHangEntity> findByHoTen(String hoTen);

//    khachHangEntity createUser(khachHangEntity khachHang, Set<khacHangRole> rolses);

    Optional<khachHangEntity> findBySDT(String sdt);
}
