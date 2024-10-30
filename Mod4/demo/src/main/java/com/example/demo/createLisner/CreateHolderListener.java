package com.example.demo.createLisner;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateHolderListener {

    @EventListener
    public void listen(CreateHolder createHolder){
        System.out.println(createHolder.getStudent().fullName());
    }

}
