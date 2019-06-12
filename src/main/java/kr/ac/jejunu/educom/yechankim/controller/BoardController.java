package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.dto.BoardDto;
import kr.ac.jejunu.educom.yechankim.service.BoardService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    private static String boardListURI = "redirect:/board";

    @RequestMapping(value="/board", method=RequestMethod.GET)
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping(value="/board/write", method=RequestMethod.GET)
    public String openBoardWrite() throws Exception {
        return "/board/boardWrite";
    }

    @RequestMapping(value="/board/write", method=RequestMethod.POST)
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);
        return "redirect:/board";
    }

    /*
    (참고) 원래 book은...
    @RequestMapping(value="/board/write", method=RequestMethod.PUT)
    public String insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardService.insertBoard(board, multipartHttpServletRequest);
        return "redirect:/board";
    }
    */

    @RequestMapping(value="/board/{boardIdx}", method=RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        modelAndView.addObject("board", board);

        return modelAndView;
    }

    @RequestMapping(value="/board/{boardIdx}", method=RequestMethod.PUT)
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value="/board/{boardIdx}", method=RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }

    /*
    @RequestMapping(value="/board/file", method=RequestMethod.GET)
    public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response) throws Exception {
        BoardFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);

        if (ObjectUtils.isEmpty(boardFile) == false) {
            String fileName = boardFile.getOriginalFileName();

            byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));

            response.setContentType("application/octet-stream");
            response.setContentLength(files.length);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");

            response.getOutputStream().write(files);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }*/

}

/*
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
 */