package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;
}
