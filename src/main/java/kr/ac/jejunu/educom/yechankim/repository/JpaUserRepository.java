package kr.ac.jejunu.educom.yechankim.repository;

import kr.ac.jejunu.educom.yechankim.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JpaUserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}