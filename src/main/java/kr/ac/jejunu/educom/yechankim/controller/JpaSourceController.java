package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.entity.SourceEntity;
import kr.ac.jejunu.educom.yechankim.service.JpaSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JpaSourceController {

    @Autowired
    private JpaSourceService jpaSourceService;

    @RequestMapping(value="/jpa/source", method= RequestMethod.GET)
    public ModelAndView openSourceList(ModelMap model) throws Exception{
        ModelAndView mv = new ModelAndView("/source/jpaSourceList");

        List<SourceEntity> list = jpaSourceService.selectSourceList();
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping(value="/jpa/source/write", method=RequestMethod.GET)
    public String openSourceWrite() throws Exception {
        return "/source/jpaSourceWrite";
    }

    @RequestMapping(value="/jpa/source/write", method=RequestMethod.POST)
    public String writeSource(SourceEntity source, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        jpaSourceService.saveSource(source, multipartHttpServletRequest);
        return "redirect:/jpa/source";
    }

    @RequestMapping(value="/jpa/source/{idx}", method=RequestMethod.GET)
    public ModelAndView openSourceDetail(@PathVariable("idx") int idx) throws Exception{
        ModelAndView mv = new ModelAndView("/source/jpaSourceDetail");

        SourceEntity source = jpaSourceService.selectSourceDetail(idx);
        mv.addObject("source", source);

        return mv;
    }

    @RequestMapping(value="/jpa/source/{idx}", method=RequestMethod.PUT)
    public String updateSource(SourceEntity source) throws Exception{
        jpaSourceService.saveSource(source, null);
        return "redirect:/jpa/source";
    }

    @RequestMapping(value="/jpa/source/{idx}", method=RequestMethod.DELETE)
    public String deleteSource(@PathVariable("idx") int idx) throws Exception{
        jpaSourceService.deleteSource(idx);
        return "redirect:/jpa/source";
    }
}