package com.example;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class AutoconfigApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(AutoconfigApplication.class, args);
			int count = context.getBeanDefinitionCount();
        System.out.println("Beans的个数：" + count);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
               System.out.print(name);
               System.out.print("->");
               Object bean = context.getBean(name);
               System.out.println(bean.getClass().getName());
        }
	  DataSource da = (DataSource) context.getBean("dataSource");
		System.out.println(da);
		
		
	/*	ObjectMapper mapper = context.getBean(ObjectMapper.class);
	      System.out.println(mapper);
	      */
	     
	      
	      
	      
	}
}

