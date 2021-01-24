package com.yasinshaw

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableEncryptableProperties
class YasinshawBackendApplication

fun main(args: Array<String>) {
	runApplication<YasinshawBackendApplication>(*args)
}
