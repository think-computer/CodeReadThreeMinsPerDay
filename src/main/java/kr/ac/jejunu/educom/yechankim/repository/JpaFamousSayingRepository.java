package kr.ac.jejunu.educom.yechankim.repository;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JpaFamousSayingRepository extends CrudRepository<FamousSayingEntity, Integer> {
    Optional<FamousSayingEntity> findByIdx(int idx);

    long count();
}
