package com.example.demo.notify;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class NotificationSender {
    private final NotificationService emailService;
    private final NotificationService smsService;
    private NotificationService currentService;


   // @Autowired
    public NotificationSender(
            @Qualifier("email") NotificationService emailService,
            @Qualifier("sms") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.currentService = emailService;
    }

    public void setNotificationService(String name) {
        if ("email".equalsIgnoreCase(name)) {
            this.currentService = emailService;
        } else if ("sms".equalsIgnoreCase(name)) {
            this.currentService = smsService;
        } else {
            throw new IllegalArgumentException("Неизвестный тип: " + name);
        }
    }

    public void send(String message) {
        currentService.send(message);
    }

}