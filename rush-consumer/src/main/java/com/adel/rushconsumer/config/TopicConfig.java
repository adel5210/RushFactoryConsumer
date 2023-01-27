package com.adel.rushconsumer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class TopicConfig {

    private final ParamsConfig paramsConfig;

    @Bean
    public NewTopic topic1(){
        return TopicBuilder
                .name(paramsConfig.getTopic())
                .partitions(1)
                .replicas(1)
                .build();
    }

}
