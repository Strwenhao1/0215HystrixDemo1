package com.bjsxt.web.controller;

import com.bjsxt.service.CacheDemo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheDemoController {

    @Autowired
    private CacheDemo cacheDemo;

    @RequestMapping("/save")
    public String save(){
        cacheDemo.save("data redis");
        return "ok";
    }
    @RequestMapping("/get")
    public String getById(String data){
        cacheDemo.getById(data);
        return "ok";
    }

    @RequestMapping("/del")
    public String del(){
        cacheDemo.del();
        return "ok";
    }

    @RequestMapping("/update")
    public String update(String data){
        cacheDemo.update(data);
        return "ok";
    }
}
