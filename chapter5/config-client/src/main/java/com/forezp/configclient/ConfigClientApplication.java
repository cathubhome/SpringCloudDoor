package com.forezp.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigClientApplication {

	/**
	 * http://localhost:8881/actuator/bus-refresh消息总线，post请求重新读取git配置
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	/**
	 * 从config-server中获取属性
	 */
	@Value("${foo}")
	private String foo;

	@GetMapping("/hi")
	public String hi(){
		return foo;
	}

}
