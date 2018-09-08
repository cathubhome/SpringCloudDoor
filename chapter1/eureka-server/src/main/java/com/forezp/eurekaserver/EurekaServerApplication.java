package com.forezp.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 *<pre>
 *  Created with IntelliJ IDEA
 *  Author: cathome
 *  Email: 1015726552@qq.com
 *  Time: 2018-09-07 23:44:46
 *  Class: EurekaServerApplication
 *  Package: com.forezp.eurekaserver
 *  Description: eureka服务注册中心
 *  Version: 1.0
 *</pre>
 */
@SpringBootApplication
@EnableEurekaServer //启动服务注册中心
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
