package com.dang.seq;

import com.dang.seq.dao.ApiAuthorizeMapDao;
import com.dang.seq.dto.ApiAuthorizeMapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author huangbojs
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
@RequestMapping("/service")
public class MainControll {
    
    @Autowired
    private ApiAuthorizeMapDao apiAuthorizeMapDao;
    
    @RequestMapping("/seq")
    @ResponseBody
    public String seq() {
        ApiAuthorizeMapDto apiAuthorizeMapDto = apiAuthorizeMapDao.selectById(10008001L);
        return String.valueOf(apiAuthorizeMapDto.getApi_id());
    }
    
    public static void main(String[] args) {
        SpringApplication.run(MainControll.class);
    }
}
