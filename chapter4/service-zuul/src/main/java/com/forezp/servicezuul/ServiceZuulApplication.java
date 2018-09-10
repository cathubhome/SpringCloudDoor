package com.forezp.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *<pre>
 *  Created with IntelliJ IDEA
 *  Author: cathome
 *  Email: 1015726552@qq.com
 *  Time: 2018-09-08 14:55:56
 *  Class: ServiceZuulApplication
 *  Package: com.forezp.servicezuul
 *  Description: Zuul的主要功能是路由转发和过滤器,zuul默认和Ribbon结合实现了负载均衡的功能
 *  Version: 1.0
 *</pre>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy //开启zuul的功能
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}
}
