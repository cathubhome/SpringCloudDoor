package com.forezp.eurekaclient;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 *<pre>
 *  Created with IntelliJ IDEA
 *  Author: cathome
 *  Email: 1015726552@qq.com
 *  Time: 2018-09-07 23:44:35
 *  Class: EurekaClientApplication
 *  Package: com.forezp.eurekaclient
 *  Description: 服务提供者
 *  Version: 1.0
 *</pre>
 */
@SpringBootApplication
@EnableEurekaClient //开启eurekaclient注解，表名是eurekaclient
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
