package kr.ac.jejunu.educom.yechankim.controller;

import kr.ac.jejunu.educom.yechankim.entity.UserEntity;
import kr.ac.jejunu.educom.yechankim.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class JpaUserController {
    @Autowired
    private JpaUserService jpaUserService;

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String openSignUp() throws Exception {
        return "/signup";
    }

    @RequestMapping(value="/error/signup", method=RequestMethod.GET)
    public ModelAndView openError() throws Exception {
        ModelAndView modelAndView = new ModelAndView("/error");
        modelAndView.addObject("msg", "회원가입 이메일 주소가 이미 존재합니다. 다른 이메일 주소로 다시 가입 바랍니다.");
        modelAndView.addObject("return", "/signup");

        return modelAndView;
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signUpUser(UserEntity user, MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if ( jpaUserService.isAbleToSignUp(user.getEmail()) ) {
            jpaUserService.saveUser(user, multipartHttpServletRequest);
            return "redirect:/jpa/board";
        } else {
            return "redirect:/error/signup";
        }
    }




    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String openLogin() throws Exception {
        return "/login";
    }
}