package com.arconsis.twitch.mqtt.receiving

import org.eclipse.microprofile.reactive.messaging.Incoming
import org.jboss.logmanager.Logger
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SimpleMqttReceiver {

    private val logger = Logger.getLogger(SimpleMqttReceiver::class.java.name)

    @Incoming("arconsis-twitch")
    fun receiveMeasurement(byteArray: ByteArray) {
        val messageString = String(byteArray)
        logger.info { "Received raw message: $messageString" }
    }
}

