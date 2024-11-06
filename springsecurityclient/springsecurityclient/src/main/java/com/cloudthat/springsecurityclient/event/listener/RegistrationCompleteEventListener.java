package com.cloudthat.springsecurityclient.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.cloudthat.springsecurityclient.entity.User;
import com.cloudthat.springsecurityclient.event.RegistrationCompleteEvent;
import com.cloudthat.springsecurityclient.service.UserService;


@Component
public class RegistrationCompleteEventListener  implements ApplicationListener<RegistrationCompleteEvent>{

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // TODO Auto-generated method stub
        // Create verification token for user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //Send email
        String url = event.getApplicationUrl()+ "/verifyRegistration?token="+token;
        // just mimicking email sending here
        System.out.println("URL link to verify: {}"+url);
    }
}