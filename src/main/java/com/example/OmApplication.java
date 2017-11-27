package com.example;
import static java.lang.System.out;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.example.pojo.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class OmApplication {

	
private static ObjectMapper mapper;
	//pojo转json
	@Autowired
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	//private static final Logger log = LoggerFactory.getLogger(OmApplication.class);	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run( OmApplication.class, args);
		int count = context.getBeanDefinitionCount();
		System.out.println("Beans的个数：" + count);
		Person me = new Person();
		me.setAge(22);
		me.setName("lyt");
		try {
			out.println(mapper.writeValueAsString(me));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
		
		//json转pojo
		String json = "{\"name\":\"ZhangQiuHua\",\"age\":52}";
		try {
			Person p2 = mapper.readValue(json, Person.class);
			out.println(p2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper;
	}

	 //bean 的名称生成器.
   // private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();	
    
}
