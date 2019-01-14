package com.cpscs.omsadmin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.cpscs.omsadmin.rpc.TestRpc;

@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {
    /*@Autowired
    TestRpc testRpc;

    @GetMapping("test")
    String test() {
        return testRpc.test();
    }
    @GetMapping("test1")
    String test1() {
        return "1111";
    }*/
// ${env.name} + world
    //相当于引用了yml文件中的  env.name配置
    //如果没有获取到env.name 的值，就会默认读取 :后面的值，相当于一个默认值了
    @Value("${port:config server not found}")
    private String bar;

    @RequestMapping("/Tese")
    String hello() {
        return "Hello " + bar + "!";
    }

}
