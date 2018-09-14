package io.saishav.crypto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class CryptoApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<CryptoApplication>(*args)
}

