
package com.cloudthat.springsecurityclient.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloudthat.springsecurityclient.entity.User;
import com.cloudthat.springsecurityclient.entity.VerificationToken;
import com.cloudthat.springsecurityclient.model.UserModel;
import com.cloudthat.springsecurityclient.repository.UserRepository;
import com.cloudthat.springsecurityclient.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        // TODO Auto-generated method stub\
        VerificationToken verificationToken = new VerificationToken(token,user);
        verificationTokenRepository.save(verificationToken);

    }

    @Override
    public String validateVerificationToken(String token) {
        // TODO Auto-generated method stub
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if(verificationToken == null) {
            return "invalid";
        }

        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if(verificationToken.getExpirationTime().getTime() - calendar.getTime().getTime() <=0) {
            return "expired";
        }

        user.setEnabled(true);
        userRepository.save(user);

        return "valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        // TODO Auto-generated method stub
        VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

}
