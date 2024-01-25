//package com.newsapp.user.config;
//
//import domain.UserDTO;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//public class KafkaMessageConfiguration {
//
//    @Bean
//    public ProducerFactory<String, UserDTO> producerFactory()
//    {
//        Map<String,Object> config=new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka:9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(config);
//    }
//
//    @Bean
//    public KafkaTemplate<String,UserDTO> kafkaTemplate()
//    {
//        return new KafkaTemplate<>(producerFactory());
//    }
//    @Bean
//    public NewTopic taskTopic() {
//        return TopicBuilder.name("user-topic-kafka")
//                .partitions(1)
//                .replicas(1)
//                .build();
//    }
//
//    //    private String exchangeName="user_exchange1";
////    private String registerQueue="user_queue1";
////    private String sellerQueue="seller_queue1";
////    @Bean
////    public TopicExchange topicExchange()
////    {
////        return new TopicExchange(exchangeName);
////    }
////
////
////    @Bean
////    public Queue registerQueue()
////    {
////        return new Queue(registerQueue,true);
////    }
////
////
////    @Bean
////    public Queue sellerQueue()
////    {
////        return new Queue(sellerQueue,true);
////    }
////
////    @Bean
////    public Jackson2JsonMessageConverter producerJackson2MessageConverter()
////    {
////        return new  Jackson2JsonMessageConverter();
////    }
////
////    @Bean
////    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
////    {
////        RabbitTemplate rabbitTemp=new RabbitTemplate(connectionFactory);
////        rabbitTemp.setMessageConverter(producerJackson2MessageConverter());
////        return rabbitTemp;
////    }
////
////    @Bean
////    Binding bindingUser(Queue registerQueue, TopicExchange exchange)
////    {
////        return BindingBuilder.bind(registerQueue()).to(exchange).with("user_routing");
////    }
////
////    @Bean
////    Binding bindingSeller(Queue registerQueue, TopicExchange exchange)
////    {
////        return BindingBuilder.bind(sellerQueue()).to(exchange).with("seller_routing");
////    }
//}
