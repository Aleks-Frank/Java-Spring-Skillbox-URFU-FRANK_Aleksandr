package com.example.demo.configur;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.demo")
@PropertySource("classpath:default-application.properties")
public class DefaultConfig {
}
