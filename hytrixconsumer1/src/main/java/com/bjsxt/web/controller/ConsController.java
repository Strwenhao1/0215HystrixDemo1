package com.bjsxt.web.controller;

import com.bjsxt.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public Object getShow(){
        return this.demoService.getInfo();
    }
    @RequestMapping("/show2")
    public Object getShow2(){
        return this.demoService.getInfo2();
    }
}
