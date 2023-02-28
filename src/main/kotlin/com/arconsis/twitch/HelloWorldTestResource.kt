package com.arconsis.twitch

import com.arconsis.twitch.mqtt.sending.SimpleMqttSender
import org.jboss.resteasy.reactive.RestPath
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
class HelloWorldTestResource(
    private val simpleMqttSender: SimpleMqttSender
) {
    @GET
    @Path("/world/{message}")
    fun helloWorld(@RestPath message: String) {
        simpleMqttSender.sendSomeMessage("Hello World: $message")
    }
}