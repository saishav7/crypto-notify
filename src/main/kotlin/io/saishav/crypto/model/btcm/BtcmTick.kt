package io.saishav.crypto.model.btcm

import com.fasterxml.jackson.annotation.JsonProperty

data class BtcmTick(@JsonProperty("bestBid") val bestBid: String,
                    @JsonProperty("bestAsk") val bestAsk: String,
                    @JsonProperty("lastPrice") val lastPrice: String,
                    @JsonProperty("currency") val currency: String,
                    @JsonProperty("instrument") val instrument: String)
