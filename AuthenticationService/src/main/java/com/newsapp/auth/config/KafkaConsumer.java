//package com.newsapp.auth.config;
//
//
//import com.newsapp.auth.exception.UserAlreadyExistException;
//import com.newsapp.auth.model.User;
//import com.newsapp.auth.service.AuthServiceImpl;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//
////@Component
//public class KafkaConsumer {
//    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
//    @Autowired
//    private AuthServiceImpl userService;
//
//    @KafkaListener(topics = { "user-topic-kafka"}, groupId = "user-group")
//    public void consume(String userDto) throws UserAlreadyExistException, JSONException {
//
////
////    @RabbitListener(queues="user_queue1")
////    public void getUserDtoFromRabbitMq(UserDTO userDto) throws UserAlreadyExistsException
////    {
//        System.out.println(userDto);
//
//        JSONObject json = new JSONObject(userDto);
//        System.out.println(json.toString());
//        String email = json.getString("email");
//        System.out.println(email);
//        String password = json.getString("password");
//        System.out.println(password);
//
//        User user=new User();
//        user.setEmail(email);
//        user.setPassword(password);
//        //userService.saveCredentials(user); //saving the data in mysql
//        logger.info("Credentials has been been consumed Successfully");
//    }
//}
