package io.saishav.crypto.service.notify

import mu.KLogging
import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackMessage
import org.springframework.stereotype.Service


@Service
class SlackNotificationService(private val slackApi: SlackApi) : NotificationService {

    override fun notify(message: String) {
        slackApi.call(SlackMessage("Crypto", message))
        logger.info { "Sent slack notification" }
    }

    companion object : KLogging()
}
