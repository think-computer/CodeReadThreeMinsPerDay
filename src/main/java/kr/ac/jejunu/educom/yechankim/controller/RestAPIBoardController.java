package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;
import kr.ac.jejunu.educom.yechankim.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAPIBoardController {
    @Autowired
    private BoardService boardService;

    private static String boardListURI = "redirect:/board/boardList";

    @RequestMapping(value="/api/board/boardList", method= RequestMethod.GET)
    public List<BoardDto> openBoardList() throws Exception {
        return boardService.selectBoardList();
    }

    @RequestMapping(value="/api/board/write", method= RequestMethod.GET)
    public void insertBoard(@RequestBody BoardDto board) throws Exception {
        boardService.insertBoard(board);
    }

    @RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.GET)
    public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        return boardService.selectBoardDetail(boardIdx);
    }

    @RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.PUT)
    public String updateBoard(@RequestBody BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }
}