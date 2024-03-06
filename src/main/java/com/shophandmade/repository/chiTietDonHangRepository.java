package com.shophandmade.repository;

import com.shophandmade.entity.chiTietDonHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chiTietDonHangRepository extends JpaRepository<chiTietDonHangEntity, Integer> {
}
