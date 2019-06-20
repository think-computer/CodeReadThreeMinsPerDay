package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import kr.ac.jejunu.educom.yechankim.repository.JpaSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Optional;

@Service
public class JpaSourceServiceImpl implements JpaSourceService {
    @Autowired
    JpaSourceRepository jpaSourceRepository;

    @Override
    public List<SourceEntity> selectSourceList() throws Exception {
        return jpaSourceRepository.findAllByOrderByIdxDesc();
    }

    @Override
    public void saveSource(SourceEntity source, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        jpaSourceRepository.save(source);
    }

    @Override
    public SourceEntity selectSourceDetail(int idx) throws Exception {
        Optional<SourceEntity> optional = jpaSourceRepository.findById(idx);

        if (optional.isPresent()) {
            SourceEntity source = optional.get();
            return source;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteSource(int idx) {
        jpaSourceRepository.deleteById(idx);
    }
}