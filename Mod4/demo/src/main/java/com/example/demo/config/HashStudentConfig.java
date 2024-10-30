package com.example.demo.config;

import com.example.demo.HashStudentList;
import com.example.demo.HashStudentListWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(HashStudentList.class)
public class HashStudentConfig {

    @Bean
    public HashStudentListWorker hashStudentListWorker(HashStudentList hashStudentList, ApplicationEventPublisher publisher){
        return new HashStudentListWorker(hashStudentList, publisher);
    }

}
