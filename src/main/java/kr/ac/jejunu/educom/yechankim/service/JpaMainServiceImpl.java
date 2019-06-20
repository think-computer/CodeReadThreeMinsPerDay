package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import kr.ac.jejunu.educom.yechankim.repository.JpaFamousSayingRepository;
import kr.ac.jejunu.educom.yechankim.repository.JpaSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.security.SecureRandom;

@Service
public class JpaMainServiceImpl implements JpaMainService {
    @Autowired
    JpaFamousSayingRepository jpaFamousSayingRepository;

    @Autowired
    JpaSourceRepository jpaSourceRepository;

    @Override
    public FamousSayingEntity selectFamousSaying(int idx) throws Exception {
        Optional<FamousSayingEntity> optional = jpaFamousSayingRepository.findByIdx(idx);

        if (optional.isPresent()) {
            FamousSayingEntity famousSaying = optional.get();

            return famousSaying;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public long getFamousSayingRecordsCount() throws Exception {
        return jpaFamousSayingRepository.count();
    }

    @Override
    public SourceEntity selectSource(int idx) throws Exception {
        Optional<SourceEntity> optional = jpaSourceRepository.findByIdx(idx);

        if (optional.isPresent()) {
            SourceEntity source = optional.get();

            return source;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public long getSourceRecordsCount() throws Exception {
        return jpaSourceRepository.count();
    }

    @Override
    public int getRandomNumber(int n) throws Exception {
        SecureRandom secureRandom = new SecureRandom();

        return secureRandom.nextInt(n) + 1;
    }
}
