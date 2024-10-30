package com.example.demo.removeLisner;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RemoveHolderListener {

    @EventListener
    public void listen(RemoveHolder removeHolder){
        System.out.println(removeHolder.getId());
    }

}
