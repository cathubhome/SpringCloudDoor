package com.forezp.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *<pre>
 *  Created with IntelliJ IDEA
 *  Author: cathome
 *  Email: 1015726552@qq.com
 *  Time: 2018-09-08 10:46:38
 *  Class: ServiceFeignApplication
 *  Package: com.forezp.servicefeign
 *  Description: Feign是一个声明式的伪Http客户端
 *  Version: 1.0
 *</pre>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients //开启Feign的功能
@EnableHystrix
public class ServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
	}
}
