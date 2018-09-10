package com.forezp.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IDEA
 * Author:catHome
 * Description:定义一个feign接口，通过@FeignClient（“服务名”）来指定调用哪个服务,fallback指定熔断
 * Time:Create on 2018/9/8 10:39
 */
@FeignClient(value = "service-client",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    /**
     * 代码中调用了service-client服务的“/hi”接口
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
