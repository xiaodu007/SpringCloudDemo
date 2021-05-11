package com.aistone.springloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer    // 用来标注启动该组件的相关注解@Enablexxx,接收其他微服务注册
public class EurekaServer7001_App {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7001_App.class, args);
	}

}
