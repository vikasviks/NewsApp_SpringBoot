//package com.newsapp.user.config;
//
//import domain.UserDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
////import org.springframework.beans.factory.annotation.Autowired;
//
////@Component
//@Service
//public class KafkaProducerService {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
//    @Autowired
//    KafkaTemplate<String, UserDTO> kafkaTemplate;
//
//    public void send(String topicName, String name, UserDTO user) {
//
//        var future = kafkaTemplate.send(topicName, user.getEmail(), user);
//
////        future.whenComplete((sendResult, exception) -> {
////            if (exception != null) {
////                future.completeExceptionally(exception);
////            } else {
////                future.complete(sendResult);
////            }
//        LOGGER.info("User details send to Kafka topic : " + user);
////        });
//    }
//
//    @Service
//    public static class Producer {
//        private final Logger logger = LoggerFactory.getLogger(Producer.class);
//        @Autowired
//        KafkaProducerService kafkaProducerService;
//
//        public void produce(UserDTO user) {
//
//            kafkaProducerService.send("user-topic-kafka", user.getEmail(), user);
//            logger.info(String.format("inside producer"));
//        }
//    }
//
//}
////    private RabbitTemplate rabbitTemplate;
////    private TopicExchange exchange;
////
////    @Autowired
////    public Producer(RabbitTemplate rabbitTemplate, TopicExchange exchange) {
////        super();
////        this.rabbitTemplate = rabbitTemplate;
////        this.exchange = exchange;
////    }
////
////    public void sendMessageToRabbitMq(UserDTO userDTO)
////    {
////        rabbitTemplate.convertAndSend(exchange.getName(),"user_routing",userDTO);
////    }
////
////
////    public void sendingMessageToRabbitMq(UserDTO userDTO)
////    {
////        rabbitTemplate.convertAndSend(exchange.getName(),"seller_routing",userDTO);
////    }
//
//
