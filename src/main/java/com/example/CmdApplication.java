package com.example;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
public class CmdApplication {

	private static final Logger log = LoggerFactory.getLogger(CmdApplication.class);
	
	public static void main(String[] args) {
	SpringApplication.run(CmdApplication.class, args);
	//SpringApplication.run(MyHealthIndicator.class,args);
	}
	@Bean
	public CommandLineRunner runner() {
		//args -> 是由String... args决定的
		return args -> {
			log.debug("Using log4j2 ...... ?");
			System.out.println();
			System.out.println("CommandLine Runner:");
			for (String arg : args) {
				System.out.println(arg);
			}
		};
	}

	@Bean
	public ApplicationRunner appRunner() {
		return new ApplicationRunner() {

			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println();
				System.out.println("Application Runner:");
				for (String opt : args.getOptionNames()) {
					System.out.print(opt);
					System.out.print("->");
					System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(",", "[", "]")));
					// String.join(",", args.getOptionValues(opt));
				}
			}

		};
		
		
}
	@Bean
	public ApplicationRunner appRunner1() {
		//args是由ApplicationArguments args决定的
		return args ->{
				System.out.println();
				System.out.println("lamda:");
				for (String opt : args.getOptionNames()) {
					System.out.print(opt);
					System.out.print("->");
					System.out.println(args.getOptionValues(opt).stream().collect(Collectors.joining(",", "[", "]")));
					// String.join(",", args.getOptionValues(opt));
				}
			

		};
	
		}
	
	@Autowired
	private CounterService counterService;
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL = "/hello";

		return (ApplicationEvent event) -> {
			if (event instanceof ServletRequestHandledEvent) {
				ServletRequestHandledEvent e = (ServletRequestHandledEvent) event;
				if (e.getRequestUrl().equals(HELLO_URL))
					counterService.increment("hello.hits");
			}
		};
	
	}
	/* @Bean
     public Health health() {
   	  //该表达式的目标类型必须是函数接口
   	  return () ->{
   		  
			return Health.up().build();
		};*/
   	  	  
    	  
    	  
      
	
	}
