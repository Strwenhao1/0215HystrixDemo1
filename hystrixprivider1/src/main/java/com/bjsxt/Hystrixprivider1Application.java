package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//对所有已支持的注册中心 进行注册与发现
@EnableDiscoveryClient
public class Hystrixprivider1Application {

	public static void main(String[] args) {
		SpringApplication.run(Hystrixprivider1Application.class, args);
	}

}
