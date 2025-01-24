package com.myNotion.fpsgo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.myNotion.fpsgo.**.mapper")
public class FpsgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FpsgoApplication.class, args);
	}

}
