## Micronaut Integration with Google Pub/Sub

### Summary 

This sample application demos how to configure micronaut to use a google Pub/Sub emulator. This application is very simple 
and just contains a controller to accept a GET request, a micronaut annotated class for publisher, and a micronaut annotated
class for a subscriber.

A docker image is used to create a google pub/sub emulator. When hitting the controller, the app will post a message to the topic 
the subscriber within the application will pull the message and print it out. 

### Instructions

1. You must have JDK 17, and Docker installed on your machine. 
2. Download the emulator and start with docker 
   1. docker run -d --rm -it -p 8681:8681 -e PUBSUB_PROJECT1=myProject,myTopic:myListener thekevjames/gcloud-pubsub-emulator:latest
3. run `export PUBSUB_EMULATOR_HOST=http://localhost:8681`
4. Run http commands to verify the pubsub emulator is up and running
   1. curl -GET $PUBSUB_EMULATOR_HOST/v1/projects/myProject/topics
   2. curl -GET $PUBSUB_EMULATOR_HOST/v1/projects/myProject/subscriptions
5. Set environment variables for your micronaut environment (or your full machine)
   1. GOOGLE_CLOUD_PROJECT=myProject;PUBSUB_EMULATOR_HOST=localhost:8681
6. Hit an application endpoint to trigger a push to a topic
   1. curl http://localhost:8080/pubsub/publish
7. See the console output from `MyListener`
   1. `received message: Person[name=nirav, age=44]`





