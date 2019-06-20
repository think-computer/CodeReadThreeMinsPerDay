package kr.ac.jejunu.educom.yechankim.repository;

import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaSourceRepository extends CrudRepository<SourceEntity, Integer> {
    List<SourceEntity> findAllByOrderByIdxDesc();
}