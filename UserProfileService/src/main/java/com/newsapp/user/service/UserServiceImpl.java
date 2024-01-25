package com.newsapp.user.service;

import com.newsapp.user.config.Producer;
import com.newsapp.user.exception.SecurityMismatchException;
import com.newsapp.user.exception.UserAlreadyExistException;
import com.newsapp.user.exception.UserNotFoundException;
import com.newsapp.user.model.ForgotPassword;
import com.newsapp.user.model.User;
import com.newsapp.user.repository.UserRepository;
import domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    Producer producer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${app.service.message1}")
    private String message1;

    @Value("${app.service.message2}")
    private String message2;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, Producer producer, PasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.producer = producer;
        this.passwordEncoder = passwordEncoder;
    }




    @Override
    public User registerUser(User user) throws UserAlreadyExistException {

        UserDTO userdto=new UserDTO();
        userdto.setUserName(user.getUserName());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        userdto.setRole(user.getRole().toString());
        User byEmail = userRepository.findByEmail(user.getEmail());

        if (byEmail!=null) {
            throw new UserAlreadyExistException("Email Id " + user.getEmail() +". Already Exists on server!! Please Try again with new one or Log In!!");
        }else if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new UserAlreadyExistException("Email Id cannot be empty!!");
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new UserAlreadyExistException("Password cannot be empty!!");
        }
//        else if (user.getRole() == null) {
//            throw new UserAlreadyExistException("Role cannot be empty");
//        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);   //storing in mongo database
            producer.sendMessageToRabbitMq(userdto);
            return savedUser;

    }

    @Override
    public boolean updatePassword(String email, ForgotPassword forgotPassword) throws SecurityMismatchException, UserNotFoundException {
        User byEmail = userRepository.findByEmail(email);

        if (byEmail != null) {
            UserDTO userdto = new UserDTO();
            userdto.setUserName(byEmail.getUserName());
            userdto.setEmail(byEmail.getEmail());
            userdto.setPassword(forgotPassword.getNewPassword());
            userdto.setRole(byEmail.getRole().toString());

            if (byEmail.getSecurityQuestion().equals(forgotPassword.getSecurityQuestion()) && byEmail.getSecurityAnswer().equals(forgotPassword.getSecurityQuestionAnswer())) {

                byEmail.setPassword(passwordEncoder.encode(forgotPassword.getNewPassword()));
                userRepository.save(byEmail);
                producer.sendUpdateMessageToRabbitMq(userdto);
                return true;
            } else {
                throw new SecurityMismatchException("Security Question and Answer do not match! Please check and try again!!");
            }
        } else {
            throw new UserNotFoundException("User with email " + email + " Not Found on the server!!");
        }
    }


}
