package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;
import kr.ac.jejunu.educom.yechankim.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    private static String boardListURI = "redirect:/board/boardList";

    @RequestMapping("/board/boardList")
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/board/boardWrite")
    public void openBoardWrite() throws Exception { }

    @RequestMapping("/board/insertBoard") // 실제 DB 삽입 후 boardList로 리다이렉트.
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);
        return boardListURI;
    }

    @RequestMapping("/board/boardDetail")
    public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board", board);

        return mv;
    }

    @RequestMapping("/board/updateBoard")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return boardListURI;
    }

    @RequestMapping("/board/deleteBoard")
    public String deleteBoard(int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return boardListURI;
    }
}
