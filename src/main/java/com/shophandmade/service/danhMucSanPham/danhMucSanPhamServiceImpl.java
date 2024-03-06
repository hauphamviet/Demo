package com.shophandmade.service.danhMucSanPham;

import com.shophandmade.JWT.JwtFilter;
import com.shophandmade.common.Constants;
import com.shophandmade.controller.danhMucSanPham.danhMucSanPhamRequest;
import com.shophandmade.entity.danhMucSanPhamEntity;
import com.shophandmade.exception.NotFoundException;
import com.shophandmade.repository.danhMucSanPhamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class danhMucSanPhamServiceImpl implements danhMucSanPhamService {

    private final danhMucSanPhamRepository danhMucSanPhamRepository;
    private final JwtFilter jwtFilter;

    @Override
    public List<danhMucSanPhamEntity> getAllDMSP() {
        return danhMucSanPhamRepository.findAll();
    }

    @Override
    public danhMucSanPhamEntity getDMSPById(Integer id) {
        return danhMucSanPhamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_DMSP_KHONG_TON_TAI, id)));
    }

    @Override
    public danhMucSanPhamEntity saveDMSP(danhMucSanPhamRequest danhMucSanPhamRequest) {
        if (jwtFilter.isAdmin()) {
            var dmspEntity = new danhMucSanPhamEntity();
            dmspEntity.setTen(danhMucSanPhamRequest.getTen());
            danhMucSanPhamRepository.save(dmspEntity);
            return dmspEntity;
        }
        return null;
    }

    @Override
    public danhMucSanPhamEntity updateDMSP(Integer id, danhMucSanPhamRequest danhMucSanPhamRequest) {
        if (jwtFilter.isAdmin()) {
            var dmspTemp = danhMucSanPhamRepository.findById(id);
            if (dmspTemp.isPresent()) {
                var dmspEntity = dmspTemp.get();
                dmspEntity.setTen(danhMucSanPhamRequest.getTen());
                return danhMucSanPhamRepository.save(dmspEntity);
            }
        }
        return null;
    }

    @Override
    public void deleteDMSP(Integer id) {
        var danhMucSanPhamEntity = danhMucSanPhamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Constants.MA_DMSP_KHONG_TON_TAI, id)));
        danhMucSanPhamRepository.deleteById(id);
    }

//    @Override
//    public ResponseEntity<List<danhMucSanPhamEntity>> getAllDMSP(String filterValue) {
//        try {
//            if (!Strings.isNullOrEmpty(filterValue) && filterValue.equalsIgnoreCase("true")) {
//                log.info("Inside if");
//                return  new ResponseEntity<>(danhMucSanPhamRepository.findAll(), HttpStatus.OK);
//            }
//            return new ResponseEntity<>(danhMucSanPhamRepository.findAll(), HttpStatus.OK);
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
