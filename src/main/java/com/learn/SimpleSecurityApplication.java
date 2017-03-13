package com.learn;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class SimpleSecurityApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SimpleSecurityApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

	@Override
	protected WebApplicationContext run(SpringApplication application) {
		application.getSources().remove(ErrorPageFilter.class);
		return super.run(application);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(SimpleSecurityApplication.class);
	}
}
