package com.cpscs.omsbase.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/BaseTese")
public class BaseTeseController {
    // ${env.name} + world
    //相当于引用了yml文件中的  env.name配置
    //如果没有获取到env.name 的值，就会默认读取 :后面的值，相当于一个默认值了
    @Value("${port:config server not found}")
    private String bar;

    @RequestMapping("/baseTese")
    String hello() {
        return "Hello " + bar + "!";
    }

}
