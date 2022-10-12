

package com.example.controller;

import com.example.dto.Person;
import com.example.pubsub.MyPublisher;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/pubsub")
public class PubSubController {

    private final MyPublisher publisher;

    public PubSubController(MyPublisher publisher) {
        this.publisher = publisher;
    }

    @Get("/publish")
    String publishMsg() {
        Person person = new Person("nirav", 44);
        publisher.sendMessage(person);
        return "done";
    }
}
