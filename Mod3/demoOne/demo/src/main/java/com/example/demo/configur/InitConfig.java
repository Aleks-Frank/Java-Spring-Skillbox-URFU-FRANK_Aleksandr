package com.example.demo.configur;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.demo")
@PropertySource("classpath:application.properties")
@Profile("init")
public class InitConfig {
}
