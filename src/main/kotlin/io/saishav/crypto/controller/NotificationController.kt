package io.saishav.crypto.controller

import io.saishav.crypto.model.btcm.BtcmTick
import io.saishav.crypto.model.btcm.Instrument
import io.saishav.crypto.service.btcm.BtcmPriceService
import io.saishav.crypto.service.notify.NotificationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notify")
class NotificationController(private val notificationService: NotificationService,
                                      private val btcmPriceService: BtcmPriceService) {

    @GetMapping("/tick")
    fun notifyTick() {
        val prices: List<BtcmTick?> = Instrument.values().map { btcmPriceService.getTick(it) }
        notificationService.notify(prices.joinToString { "${it?.instrument}: ${it?.lastPrice}" })
    }

}
