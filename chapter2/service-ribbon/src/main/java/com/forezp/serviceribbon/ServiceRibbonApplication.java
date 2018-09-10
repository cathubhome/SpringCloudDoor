package com.forezp.serviceribbon;

import brave.sampler.Sampler;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 *  Created with IntelliJ IDEA
 *  Author: cathome
 *  Email: 1015726552@qq.com
 *  Time: 2018-09-08 09:38:15
 *  Class: ServiceRibbonApplication
 *  Package: com.forezp.serviceribbon
 *  Description: 微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restful的。
 *  Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign
 *  ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon
 *
 *  Version: 1.0
 * </pre>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //通过@EnableDiscoveryClient向服务中心注册
@EnableHystrix //@EnableHystrix注解开启Hystrix断路器
@EnableHystrixDashboard //@EnableHystrixDashboard注解开启HystrixDashboard
@EnableCircuitBreaker
@EnableTurbine //@EnableTurbine注解开启断路器聚合
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    /**
     * 向程序的IOC容器中注入一个bean: restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    /**
     * 断路器监控
     * http://localhost:8763/actuator/hystrix.stream
     * http://localhost:8763/hystrix输入http://localhost:8763/hystrix.stream，delay:2000,title:hi
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
