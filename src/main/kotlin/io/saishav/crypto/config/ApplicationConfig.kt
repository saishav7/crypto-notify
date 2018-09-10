package io.saishav.crypto.config

import net.gpedro.integrations.slack.SlackApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.client.RestTemplate

@Configuration
@EnableScheduling
class ApplicationConfig {

    @Bean
    fun slackApi(@Value("\${slack.channel.webhook.url}") slackWebhookUrl: String): SlackApi {
        return SlackApi(slackWebhookUrl)
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}
