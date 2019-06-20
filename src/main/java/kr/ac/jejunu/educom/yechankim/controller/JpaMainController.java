package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.entity.FamousSayingEntity;
import kr.ac.jejunu.educom.yechankim.service.JpaMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpaMainController {
    @Autowired
    private JpaMainService jpaMainService;

    @RequestMapping(value="/jpa/main", method= RequestMethod.GET)
    public ModelAndView openReadCodes() throws Exception {
        ModelAndView modelAndView = new ModelAndView("main/jpaFamousSaying");

        int maxNo = (int) jpaMainService.getRecordsCount();

        FamousSayingEntity famousSaying = jpaMainService.selectFamousSaying(jpaMainService.getRandomNumber(maxNo));
        modelAndView.addObject("famousSaying", famousSaying);

        return modelAndView;
    }


}