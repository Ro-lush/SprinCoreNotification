package com.example.demo;

import com.example.demo.notify.EmailService;
import com.example.demo.notify.NotificationSender;
import com.example.demo.notify.SmsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringCore {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoSpringCore.class, args);

    /*NotificationSender sender = new NotificationSender(new EmailService());
    sender.send("Проверка Email");
    sender.setService(new SmsService());
    sender.send("Проверка SMS");
*/
        NotificationSender sender = ctx.getBean(NotificationSender.class);
        sender.send("По умолчанию");
        sender.setNotificationService("sms");
        sender.send("Проверка смс");
        sender.setNotificationService("EMAIL");
        sender.send("Проверка email");
        sender.setNotificationService("sadsad");
        sender.send("Проверка на эксепшен");


    }

}
