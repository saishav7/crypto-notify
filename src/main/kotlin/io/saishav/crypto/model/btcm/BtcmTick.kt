package io.saishav.crypto.model.btcm

data class BtcmTick(
        val bestBid: String,
        val bestAsk: String,
        val lastPrice: String,
        val currency: String,
        val instrument: String
)
