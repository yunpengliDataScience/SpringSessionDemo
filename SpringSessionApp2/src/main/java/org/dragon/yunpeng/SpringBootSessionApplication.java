package org.dragon.yunpeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootSessionApplication extends SpringBootServletInitializer{ //Need to extends SpringBootServletInitializer to be able to deployed in Tomcat

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSessionApplication.class, args);
	}
}