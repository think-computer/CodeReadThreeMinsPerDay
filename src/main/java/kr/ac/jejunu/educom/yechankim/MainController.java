package kr.ac.jejunu.educom.yechankim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/index")
    public void openIndex() throws Exception {}

    @RequestMapping("/signup")
    public void openSignup() throws Exception {}

    @RequestMapping("/login")
    public void openLogin() throws Exception {}

    @RequestMapping("/board")
    public void openBoard() throws Exception {}

    @RequestMapping("/main")
    public void openMain() throws Exception {}
}
