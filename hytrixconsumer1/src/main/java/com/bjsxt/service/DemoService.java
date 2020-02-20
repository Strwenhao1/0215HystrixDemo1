package com.bjsxt.service;

import java.util.List;
import java.util.concurrent.Future;

public interface DemoService {
    String getInfo();
    List<String> getInfo2();

    Future<String> getInfo3(String id);
}
