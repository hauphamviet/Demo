package com.shophandmade.JWT;

import com.shophandmade.entity.khachHangEntity;
import com.shophandmade.repository.khachHangRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final khachHangRepository khachHangRepository;
    private khachHangEntity userDetail;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Dang load nguoi dung ben trong {}", username);

        //Tim nguoi dung theo email
        userDetail = khachHangRepository.findByEmail(username);

        if (!Objects.isNull(userDetail))
            return new User(userDetail.getEmail(), userDetail.getMatKhau(), new ArrayList<>());
        else
            throw new UsernameNotFoundException("Khong tim thay user");
    }

    public khachHangEntity getUserDetail() {
        return userDetail;
    }

}
