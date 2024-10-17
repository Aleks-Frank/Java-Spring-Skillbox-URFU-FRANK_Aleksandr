package com.example.demo;

import com.example.demo.configur.DefaultConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ModOmeApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DefaultConfig.class);
		BookPhoneComponent bookPhone = context.getBean(BookPhoneComponent.class);
		bookPhone.work();
	}

}
