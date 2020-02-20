package com.bjsxt.service;

public interface CacheDemo {

    String save(String data);

    String getById(String id);

    void del();

    String update(String data);
}
