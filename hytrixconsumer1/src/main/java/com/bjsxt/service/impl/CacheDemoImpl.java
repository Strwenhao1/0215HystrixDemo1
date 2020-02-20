package com.bjsxt.service.impl;

import com.bjsxt.service.CacheDemo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "com.bjsxt")
public class CacheDemoImpl implements CacheDemo {

    @Cacheable(key = "'demo'")
    @Override
    public String save(String data) {
        return data;
    }

    //当满足condition的条件时不进行缓存
//    @Cacheable(key = "'getById:'+#id",condition = "#id != null")
//    @Override
//    public String getById(String id) {
//        return "data:"+id;
//    }

    //当满足unless后面的条件时，就不进行缓存
    @Cacheable(key = "'getById:'+#id", unless = "#result == null")
    @Override
    public String getById(String id) {
        System.out.println(id);
        return id;
    }

    @CacheEvict(key = "'demo'")
    @Override
    public void del() {
    }

    @CachePut(key = "'demo'")
    public String update(String data){
        return data;
    }

}
