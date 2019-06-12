package kr.ac.jejunu.educom.yechankim.mapper;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
}
