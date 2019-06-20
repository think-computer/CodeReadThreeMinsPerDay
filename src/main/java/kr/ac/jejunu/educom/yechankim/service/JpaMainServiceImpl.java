package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import kr.ac.jejunu.educom.yechankim.repository.JpaFamousSayingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.security.SecureRandom;

@Service
public class JpaMainServiceImpl implements JpaMainService {
    @Autowired
    JpaFamousSayingRepository jpaFamousSayingRepository;

    @Override
    public FamousSayingEntity selectFamousSaying(int idx) throws Exception {
        Optional<FamousSayingEntity> optional = jpaFamousSayingRepository. findByIdx(idx);

        if (optional.isPresent()) {
            FamousSayingEntity famousSaying = optional.get();

            return famousSaying;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public long getRecordsCount() throws Exception {
        return jpaFamousSayingRepository.count();
    }

    @Override
    public int getRandomNumber(int n) throws Exception {
        SecureRandom secureRandom = new SecureRandom();

        return secureRandom.nextInt(n) + 1;
    }
}
