# TroubleTicket Demo

Sample application to demonstrate how to send and receive messages from Kafka using Spring KafkaTemplate

## Pre-requisites

* JDK 17
* AsyncAPI RI for TMF621 TroubleTicket

## Run the application

* Start the TMF621 TroubleTicket Async RI application Docker container as per instructions for the RI
* Run the Asycnapi demo application
* This does the following
  * Sends a messages on `troubleTicket.v5.createTroubleTicket.commandRequest`
  * Receives messages on `troubleTicket.v5.createTroubleTicket.commandResponse`
  * Awaits notification on `troubleTicket.v5.createTroubleTicket.notification`

## Extending the application

The code here is generic demonstration code. You can extend this to send and receive messages on any topic.
