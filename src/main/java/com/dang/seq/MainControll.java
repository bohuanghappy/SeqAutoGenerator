package com.dang.seq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dang.seq.service.SeqService;

/**
 * @Author huangbojs
 */
@Controller
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan
//@SpringBootConfiguration
@RequestMapping("/service")
public class MainControll {
    
    @Autowired
    private SeqService seqService;
    
    @RequestMapping("/seq")
    @ResponseBody
    public String seq() throws Exception {
        String token = "id";
        return seqService.generator(token).toString();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(MainControll.class);
    }
}
