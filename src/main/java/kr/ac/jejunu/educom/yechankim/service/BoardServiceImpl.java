package kr.ac.jejunu.educom.yechankim.service;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;
import kr.ac.jejunu.educom.yechankim.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }
}
