package com.example.pubsub;

import com.example.dto.Person;
import io.micronaut.gcp.pubsub.annotation.PubSubClient;
import io.micronaut.gcp.pubsub.annotation.Topic;

@PubSubClient
public interface MyPublisher {

    @Topic("myTopic")
    void sendMessage(Person person);
}
