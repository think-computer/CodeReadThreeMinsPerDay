package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import org.springframework.data.jpa.repository.Query;

public interface JpaMainService {
    FamousSayingEntity selectFamousSaying(int idx) throws Exception;

    long getFamousSayingRecordsCount() throws Exception;

    SourceEntity selectSource(int idx) throws Exception;

    long getSourceRecordsCount() throws Exception;

    int getRandomNumber(int n) throws Exception;
}
