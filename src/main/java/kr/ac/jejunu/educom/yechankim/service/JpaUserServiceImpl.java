package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.UserEntity;
import kr.ac.jejunu.educom.yechankim.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.PrintWriter;
import java.util.Optional;

@Service
public class JpaUserServiceImpl implements JpaUserService {
    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public void saveUser(UserEntity user, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        jpaUserRepository.save(user);
    }

    @Override
    public boolean isAbleToSignUp(String email) throws Exception {
        Optional<UserEntity> optional = jpaUserRepository.findByEmail(email);

        if (optional.isPresent()) {
            return false;
        } else {
            return true;
        }
    }
}
