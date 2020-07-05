package com.heatingpay.posp.web;

import com.heatingpay.posp.service.PospService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/")
public class PospController {

    @Autowired
    private PospService pospService;

    @RequestMapping("/index")
    public String index(){
        return "helloworld!";
    }

    @RequestMapping("/tmk")
    String downloadTmk(){
        return pospService.downloadTmk();
    }
}
