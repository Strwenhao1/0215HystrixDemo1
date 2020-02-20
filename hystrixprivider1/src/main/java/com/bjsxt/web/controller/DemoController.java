package com.bjsxt.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    @RequestMapping("/getInfo")
    public Object getInfo(){
        List<String> list  = new ArrayList<>();
        list.add("a");
        list.add("b");
        return list;

    }
}
