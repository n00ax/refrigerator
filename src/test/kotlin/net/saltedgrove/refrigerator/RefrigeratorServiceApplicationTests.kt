package net.saltedgrove.refrigerator

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.metrics.export.datadog.EnableDatadogMetrics

@SpringBootTest
@EnableDatadogMetrics
class RefrigeratorServiceApplicationTests {

	@Test
	fun contextLoads() {
	}

}
