package kr.ac.jejunu.educom.yechankim.repository;

import kr.ac.jejunu.educom.yechankim.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer> {
    List<BoardEntity> findAllByOrderByBoardIdxDesc();
}