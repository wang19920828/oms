package com.omsconfig;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient // 服务注册与发现
@EnableConfigServer
@SpringBootApplication
public class OmsConfigApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(OmsConfigApplication.class).web(true).run(args);
		//SpringApplication.run(OmsConfigApplication.class, args);
	}



}