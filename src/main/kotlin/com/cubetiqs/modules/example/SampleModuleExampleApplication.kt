package com.cubetiqs.modules.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

@SpringBootApplication
class SampleModuleExampleApplication {
    data class Person (
            val name: String,
            val age: Int,
    )

    @EventListener(ApplicationReadyEvent::class)
    fun onApplicationReady() {
        println("Application running....")
    }
}

fun main(args: Array<String>) {
    runApplication<SampleModuleExampleApplication>(*args)
}
