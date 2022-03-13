package ie.zalando.kotlincompilerbug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinCompilerBugApplication

fun main(args: Array<String>) {
	runApplication<KotlinCompilerBugApplication>(*args)
}
