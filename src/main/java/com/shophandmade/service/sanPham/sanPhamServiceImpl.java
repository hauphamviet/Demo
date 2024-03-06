package com.shophandmade.service.sanPham;

import com.shophandmade.JWT.JwtFilter;
import com.shophandmade.common.Constants;
import com.shophandmade.controller.sanPham.sanPhamRequest;
import com.shophandmade.entity.danhMucSanPhamEntity;
import com.shophandmade.entity.sanPhamEntity;
import com.shophandmade.exception.NotFoundException;
import com.shophandmade.repository.danhMucSanPhamRepository;
import com.shophandmade.repository.sanPhamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Log4j2
@Service
@RequiredArgsConstructor
public class sanPhamServiceImpl implements sanPhamService {

    private final sanPhamRepository sanPhamRepository;
    private final JwtFilter jwtFilter;
    private final danhMucSanPhamRepository danhMucSanPhamRepository;

    @Override
    public List<sanPhamEntity> getAllSP() {
        return sanPhamRepository.findAll();
    }

    @Override
    public sanPhamEntity getSPById(Integer id) {
        return sanPhamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_SAN_PHAM_KHONG_TON_TAI, id)));
    }

    @Override
    public sanPhamEntity updateSanPham(Integer id, sanPhamRequest sanPhamRequest) {
        if (jwtFilter.isAdmin()) {
            var sanPhamTemp = sanPhamRepository.findById(id)
                    .map(sanphamEntity -> buildSPEntity(sanphamEntity, sanPhamRequest))
                    .orElse(null);
            if (Objects.isNull(sanPhamTemp)) {
                log.info("Loi cap nhat san pham = {}", id);
                return null;
            }
            return sanPhamRepository.save(sanPhamTemp);
        }
        return null;
    }

    @Override
    public void deleteSanPham(Integer id) {
        var sanPhamEntity = sanPhamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_SAN_PHAM_KHONG_TON_TAI, id)));
        sanPhamRepository.deleteById(id);
    }

    @Override
    public sanPhamEntity updateTrangThai(Integer id, sanPhamRequest sanPhamRequest) {
        if (jwtFilter.isAdmin()) {
            var sanPhamOpt = sanPhamRepository.findById(id);
            if (sanPhamOpt.isPresent()) {
                var sanPhamEntity = sanPhamOpt.get();
                sanPhamEntity.setTrangThai(sanPhamRequest.getTrangThai());
                return sanPhamRepository.save(sanPhamEntity);
            }
            throw new NotFoundException(String.format(Constants.MA_SAN_PHAM_KHONG_TON_TAI, id));
        }
        return null;
    }

    @Override
    public List<sanPhamEntity> getProductsByCategory(Integer id) {
        List<sanPhamEntity> list = sanPhamRepository.getProductsByCategory(id);
        return list;
    }

    @Override
    public sanPhamEntity getSanPhamById(Integer id) {
        return sanPhamRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format(Constants.MA_SAN_PHAM_KHONG_TON_TAI, id)));
    }

    private sanPhamEntity buildSPEntity(sanPhamEntity sanphamEntity, sanPhamRequest sanPhamRequest) {
        danhMucSanPhamEntity danhMucSanPhamEntity = new danhMucSanPhamEntity();
        sanphamEntity.setTen(sanPhamRequest.getTen());
        sanphamEntity.setMoTa(sanPhamRequest.getMoTa());
        sanphamEntity.setGia(sanPhamRequest.getGia());
        var category = danhMucSanPhamRepository.findById(sanPhamRequest.getDmspId())
                .orElseThrow(()-> new NotFoundException("Khong tim thay DMSP voi id: " + sanPhamRequest.getDmspId()));
        sanphamEntity.setDanhmucsanphamEntity(category);
        return sanphamEntity;
    }

    @Override
    public sanPhamEntity saveSanPham(sanPhamRequest sanPhamRequest) {
        if (jwtFilter.isAdmin()) {
            var sanPhamEnity = new sanPhamEntity();
//            var categoryEntity = new danhMucSanPhamEntity();
            sanPhamEnity.setTen(sanPhamRequest.getTen());
            sanPhamEnity.setMoTa(sanPhamRequest.getMoTa());
            sanPhamEnity.setTrangThai("true");
            sanPhamEnity.setGia(sanPhamRequest.getGia());

            var dmspId = danhMucSanPhamRepository.findById(sanPhamRequest.getDmspId())
                    .orElseThrow(() -> new NotFoundException("Khong tim thay ma danh muc san pham"));
            sanPhamEnity.setDanhmucsanphamEntity(dmspId);
//            sanPhamEnity.setDanhmucsanphamEntity(categoryEntity);
            sanPhamRepository.save(sanPhamEnity);
            return sanPhamEnity;
        }
        return null;
    }

}
