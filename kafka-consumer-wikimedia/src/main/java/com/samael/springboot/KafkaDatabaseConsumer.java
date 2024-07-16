package com.samael.springboot;

import com.samael.springboot.entity.WikimediaData;
import com.samael.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;
    @KafkaListener(topics="wikimedia_recentchange" ,groupId = "myGroup1")
    public void consume(String eventMessage){
     LOGGER.info(String.format("Event Message Received -> %s",eventMessage));

     WikimediaData wikimediaData = new WikimediaData();
     wikimediaData.setWikiEvents(eventMessage);
     wikimediaDataRepository.save(wikimediaData);

    }
}
