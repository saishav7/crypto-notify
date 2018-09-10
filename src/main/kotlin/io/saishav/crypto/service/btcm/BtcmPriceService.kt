package io.saishav.crypto.service.btcm

import io.saishav.crypto.model.btcm.BtcmTick
import io.saishav.crypto.model.btcm.Instrument
import io.saishav.crypto.util.Constants.MARKET_TICK_PATH
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.RestTemplate

@Service
class BtcmPriceService(private val restTemplate: RestTemplate,
                        @param:Value("\${btcmarkets.baseUrl}") private val baseUrl: String) {

    fun getTick(instrument: Instrument): BtcmTick? {
        val headers = HttpHeaders()
        headers.set("Accept", "application/json")
        val request = HttpEntity<Any>(headers)
        return try {
            val response = restTemplate.exchange(
                    baseUrl + MARKET_TICK_PATH,
                    HttpMethod.GET,
                    request,
                    BtcmTick::class.java,
                    instrument.name
            )
            response.body
        } catch (e: HttpStatusCodeException) {
            logger.error(e) { "Error while retrieving results" }
            null
        }
    }

    companion object : KLogging()

}
