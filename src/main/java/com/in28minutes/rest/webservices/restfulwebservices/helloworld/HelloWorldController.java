package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
		
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path="/hello-world")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean sendMessage() {
		return new HelloWorldBean("Hello world Bean-v1");
	}
	
	@GetMapping(path="/hello-world-path-variable/{name}")
	public HelloWorldBean HelloUsingPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello world "+name);
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String sayHelloInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
	}
}
