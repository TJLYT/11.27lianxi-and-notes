package com.example.autoconfig.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner{

	
	@Autowired
	public  MyBean(Person p) {
      p.setName("666");
      
      int files = p.getNonOptionArgs();
      System.out.println(files);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
