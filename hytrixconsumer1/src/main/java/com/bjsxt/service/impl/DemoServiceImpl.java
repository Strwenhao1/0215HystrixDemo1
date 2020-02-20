package com.bjsxt.service.impl;

import com.bjsxt.service.DemoService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@CacheConfig(cacheNames = "com.bjsxt")
@Service
//默认托底数据
//@DefaultProperties(defaultFallback = "defaultFallback")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true")
    })
    @Override
    public String getInfo() {
        List<String> list = this.restTemplate.getForObject("http://hystrixprivider/getInfo", List.class);
        list.forEach(System.out::println);
        return list.toString();
    }

    public String defaultFallback(){
        return "默认托底数据";
    }

    @Cacheable(key = "'info'")
    @Override
    public List<String> getInfo2() {
        List<String> list = this.restTemplate.getForObject("http://hystrixprivider/getInfo", List.class);
        list.forEach(System.out::println);
        return list;
    }

    @HystrixCollapser(batchMethod = "batch")
    @Override
    public Future<String> getInfo3(String id) {
        return null;
    }



    public String fallback() {
        return "请求超时，请重试";
    }
}
