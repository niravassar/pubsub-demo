package com.example.pubsub;

import com.example.dto.Person;
import io.micronaut.gcp.pubsub.annotation.PubSubListener;
import io.micronaut.gcp.pubsub.annotation.Subscription;

@PubSubListener
public class MyListener  {

    @Subscription("myListener") //
    public void onMessage(Person person)  {
        System.out.println("received message: " + person);
    }
}
