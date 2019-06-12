package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;
import kr.ac.jejunu.educom.yechankim.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;


    @RequestMapping("/board/boardList")
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);
        return mv;
    }

    /*
    @RequestMapping("/board/boardList")
    public void openBoardList() throws Exception {

    }*/
}
