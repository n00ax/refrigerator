package net.saltedgrove.refrigerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.metrics.export.datadog.EnableDatadogMetrics

@EnableDatadogMetrics
@SpringBootApplication
class RefrigeratorServiceApplication

fun main(args: Array<String>) {
	runApplication<RefrigeratorServiceApplication>(*args)
}
