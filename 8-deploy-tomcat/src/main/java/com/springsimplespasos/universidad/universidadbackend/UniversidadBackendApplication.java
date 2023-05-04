package com.springsimplespasos.universidad.universidadbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UniversidadBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args)
				.getBeanDefinitionNames();

		for (String str : beanDefinitionNames) {
			System.out.println(str);
		}

	}

}
