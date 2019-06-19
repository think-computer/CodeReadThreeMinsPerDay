package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.entity.BoardEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface JpaBoardService {
    List<BoardEntity> selectBoardList() throws Exception;
    void saveBoard(BoardEntity board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    BoardEntity selectBoardDetail(int boardIdx) throws Exception;
    void deleteBoard(int boardIdx);
}