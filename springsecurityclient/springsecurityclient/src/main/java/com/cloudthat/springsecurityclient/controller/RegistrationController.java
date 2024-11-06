package com.cloudthat.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudthat.springsecurityclient.entity.User;
import com.cloudthat.springsecurityclient.entity.VerificationToken;
import com.cloudthat.springsecurityclient.event.RegistrationCompleteEvent;
import com.cloudthat.springsecurityclient.model.UserModel;
import com.cloudthat.springsecurityclient.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registeruser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Success";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if(result.equalsIgnoreCase("valid")) {
            return "User verified Succesfully";
        }
        return "Bad user";

    }

    @GetMapping("/resendVerifiytoken")
    public String resendVerificaionToken(@RequestParam("token") String oldToken, HttpServletRequest httpServletRequest) {
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
        User user = verificationToken.getUser();
        resendVerificationTokenMail(user,applicationUrl(httpServletRequest), verificationToken);
        return "Verification link Sent";
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {
        // TODO Auto-generated method stub
        String url = applicationUrl+ "/verifyRegistration?token="+verificationToken.getToken();
        // just mimicking email sending here
        System.out.println("URL link to verify: {}"+url);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+ request.getServerName()+":"+request.getServerPort()+ request.getContextPath();
    }

}