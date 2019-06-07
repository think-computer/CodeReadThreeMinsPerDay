package kr.ac.jejunu.educom.yechankim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@RestController
@SpringBootApplication
public class YechankimApplication {

    public static void main(String[] args) {
        SpringApplication.run(YechankimApplication.class, args);
    }

    @RequestMapping("/helloChan")
    public String HelloWorld() {
        return "<b>H</b>ello 찬";
    }

}