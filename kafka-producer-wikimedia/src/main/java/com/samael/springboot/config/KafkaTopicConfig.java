package com.samael.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.beans.factory.annotation.Value;
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createTopic(){
        return TopicBuilder.name("wikimedia_recentchange")
                .build();
    }
}
