package com.adel.rushconsumer.service;

import com.adel.rushconsumer.config.ParamsConfig;
import com.adel.rushfactorycommon.model.Box;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FactoryConsumer {

    private final ParamsConfig paramsConfig;
    private final KafkaTemplate<Long, Box> kafkaTemplate;

    @KafkaListener(
            id = "RUSH_FACTORY_TOPIC1",
            topics = "RUSH_FACTORY_TOPIC1",
            groupId = "a",
            concurrency = "3")
    @Transactional
    public void listenOtherFactory(final Box box){
        log.info("Receive "+ box.toString());
    }
}
