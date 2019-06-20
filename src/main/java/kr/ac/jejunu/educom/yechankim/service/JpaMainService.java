package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import org.springframework.data.jpa.repository.Query;

public interface JpaMainService {
    FamousSayingEntity selectFamousSaying(int idx) throws Exception;

    long getRecordsCount() throws Exception;

    int getRandomNumber(int n) throws Exception;
}
