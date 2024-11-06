package com.cloudthat.springsecurityclient.service;

import com.cloudthat.springsecurityclient.entity.User;
import com.cloudthat.springsecurityclient.entity.VerificationToken;
import com.cloudthat.springsecurityclient.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);


}