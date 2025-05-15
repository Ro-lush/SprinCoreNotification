package com.example.demo.notify;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Setter
@Service
public class NotificationSender {
    private NotificationService service;


   // @Autowired
    public NotificationSender(NotificationService service) {
        this.service = service;
    }

    //  @Autowired
 /*   public void setNotificationService(NotificationService service) {
        this.service = service;
    }*/

    public void send(String message) {
        service.send(message);
    }

}