package com.shophandmade.repository;

import com.shophandmade.entity.sanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sanPhamRepository extends JpaRepository<sanPhamEntity, Integer> {

//    List<SanphamEntity> getSanPhamByDanhMucSanPham(long id);

    @Modifying
    @Query(value = "Select sp from sanPhamEntity sp where sp.sanPhamEntity.dmsp = :id", nativeQuery = true)
    List<sanPhamEntity> getProductsByCategory(Integer id);

}
