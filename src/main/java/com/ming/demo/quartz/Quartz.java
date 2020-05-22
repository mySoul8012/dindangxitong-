package com.ming.demo.quartz;

import com.ming.demo.service.userOrders.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Quartz {
    private int count = 0;

    @Autowired
    private UserOrdersService userOrdersService;

    @Scheduled(cron = "0 0/15 * * * ?")
    private void process(){
        System.out.println("this is scheduler running" + count++);
        try {
            userOrdersService.OverdueOrder();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
