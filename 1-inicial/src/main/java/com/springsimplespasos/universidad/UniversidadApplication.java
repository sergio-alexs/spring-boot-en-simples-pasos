package com.springsimplespasos.universidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversidadApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversidadApplication.class, args)
				.getBeanDefinitionNames();

		for (String str : beanDefinitionNames) {
			System.out.println(str);
		}

	}

}
