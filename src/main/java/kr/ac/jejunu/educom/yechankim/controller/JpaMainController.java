package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import kr.ac.jejunu.educom.yechankim.service.JpaMainService;
import kr.ac.jejunu.educom.yechankim.service.MakeBlankProblemForPythonService;
import kr.ac.jejunu.educom.yechankim.service.MakeBlankProblemForPythonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpaMainController {
    @Autowired
    private JpaMainService jpaMainService;

    @Autowired
    private MakeBlankProblemForPythonService makeBlankProblemForPythonService;

    @RequestMapping(value="/jpa/main", method= RequestMethod.GET)
    public ModelAndView openFamousSaying() throws Exception {
        ModelAndView modelAndView = new ModelAndView("main/jpaFamousSaying");

        long maxNo = jpaMainService.getFamousSayingRecordsCount();

        FamousSayingEntity famousSaying = jpaMainService.selectFamousSaying(jpaMainService.getRandomNumber((int) maxNo));
        modelAndView.addObject("famousSaying", famousSaying);

        return modelAndView;
    }

    @RequestMapping(value="/jpa/main/video", method = RequestMethod.GET)
    public String openVideoClip1() throws Exception {
        long maxNo = jpaMainService.getSourceRecordsCount();
        long idx = jpaMainService.getRandomNumber((int) maxNo);
        return String.format("redirect:/jpa/main/%d/video", idx);
    }

    @RequestMapping(value="/jpa/main/{idx}/video", method = RequestMethod.GET)
    public ModelAndView openVideoClip2(@PathVariable("idx") int idx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main/jpaWatchVideo");

        SourceEntity source = jpaMainService.selectSource(idx);

        source.setVideoUrl("https://www.youtube.com/embed/" + source.getVideoUrl().split("https://www.youtube.com/watch")[1].substring(3));
        modelAndView.addObject("source", source);

        return modelAndView;
    }

    @RequestMapping(value="/jpa/main/{idx}/solve", method = RequestMethod.GET)
    public ModelAndView openSolveProblem(@PathVariable("idx") int idx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main/jpaSolveProblem");

        SourceEntity source = jpaMainService.selectSource(idx);

        makeBlankProblemForPythonService.setForThisService(source.getSource());
        source.setSource(makeBlankProblemForPythonService.getProblem());

        modelAndView.addObject("source", source);
        modelAndView.addObject("answersList", makeBlankProblemForPythonService.getAnswersList());

        return modelAndView;
    }

    @RequestMapping(value="/jpa/main/{idx}/done", method = RequestMethod.POST)
    public ModelAndView openDoneScreen (@PathVariable("idx") int idx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main/jpaDone");

        SourceEntity source = jpaMainService.selectSource(idx);

        modelAndView.addObject("source", source);

        return modelAndView;
    }

    @RequestMapping(value = "/jpa/mypage")
    public String openMyPage1() throws Exception {
        return "redirect:/jpa/mypage/1";
    }

    @RequestMapping(value="/jpa/mypage/{userIdx}", method = RequestMethod.GET)
    public ModelAndView openMyPage2 (@PathVariable("userIdx") int userIdx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("main/jpaMyPage");

        return modelAndView;
    }
}