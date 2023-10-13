package br.net.galdino.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Foo Bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);
	
	@GetMapping("/foo-bar")
	@Operation(summary = "Foo Bar")
	//@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")//vide application.yml
	//@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
	//@RateLimiter(name = "default")//vide application.yml - deixar só  o retorno comentado e o logger
	@Bulkhead(name = "default")//vide application.yml
	public String fooBar() {
		logger.info("Request to Foo Bar Received");//comente LoggingFilter do proj api-gateway
		var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		//return "Foo Bar";
		return response.getBody();
	}
	
	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar!!!";
	}

}
