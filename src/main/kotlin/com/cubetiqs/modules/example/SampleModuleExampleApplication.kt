package com.cubetiqs.modules.example

import com.cubetiqs.enterprise.comutils.json.toJson
import com.cubetiqs.enterprise.comutils.json.toModel
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
        val json = """
			{
				"name": "Sambo",
				"age": 24
			}
		""".trimIndent()
        val node = json.toModel<Person>()
        print(node)
    }
}

fun main(args: Array<String>) {
    runApplication<SampleModuleExampleApplication>(*args)
}
