package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.UserEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface JpaUserService {
    void saveUser(UserEntity user, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    boolean isAbleToSignUp(String email) throws Exception;
}
