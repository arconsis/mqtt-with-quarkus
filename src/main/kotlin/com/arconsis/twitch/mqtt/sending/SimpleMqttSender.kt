package com.arconsis.twitch.mqtt.sending

import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import org.jboss.logmanager.Logger
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SimpleMqttSender(
    @Channel("hello-world") private val emitter: Emitter<String>
) {

    private val logger = Logger.getLogger(SimpleMqttSender::class.java.name)

    fun sendSomeMessage(message: String) {
        logger.info { "Sending message: $message" }
        emitter.send(message)
    }
}