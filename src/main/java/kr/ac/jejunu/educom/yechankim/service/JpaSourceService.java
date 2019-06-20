package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface JpaSourceService {
    List<SourceEntity> selectSourceList() throws Exception;
    void saveSource(SourceEntity source, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    SourceEntity selectSourceDetail(int idx) throws Exception;
    void deleteSource(int idx);
}