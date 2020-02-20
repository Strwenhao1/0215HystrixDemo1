package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/*@SpringBootApplication
@EnableDiscoveryClient
//开启熔断器
@EnableCircuitBreaker*/
@SpringCloudApplication //复合注解 SpringBootApplication+EnableDiscoveryClient+EnableCircuitBreaker
@EnableCaching

public class HytrixconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HytrixconsumerApplication.class, args);
	}

}
