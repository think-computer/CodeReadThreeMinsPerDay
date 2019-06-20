package kr.ac.jejunu.educom.yechankim.repository;

import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaSourceRepository extends CrudRepository<SourceEntity, Integer> {
    List<SourceEntity> findAllByOrderByIdxDesc();

    long count();

    Optional<SourceEntity> findByIdx(int idx);
}