package com.cubetiqs.modules.example

import com.cubetiqs.enterprise.comutils.json.toJsonNode
import com.cubetiqs.enterprise.comutils.json.toModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JsonTests {

    @Test
    fun jsonToModel() {
        val json = """
			{
				"name": "Sambo",
				"age": 24
			}
		""".trimIndent()
        val node = json.toModel<SampleModuleExampleApplication.Person>()

        Assertions.assertEquals(SampleModuleExampleApplication.Person("Sambo", 24), node)
    }

    @Test
    fun jsonToJsonNode() {
        val json = """
			{
				"name": "Sambo",
				"age": 24
			}
		""".trimIndent()
        val node = json.toJsonNode()

        Assertions.assertEquals("Sambo", node?.get("name")?.asText())
        Assertions.assertEquals(24, node?.get("age")?.asInt())
    }

}