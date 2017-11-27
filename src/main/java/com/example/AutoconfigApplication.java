package com.example;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class AutoconfigApplication {
		/** 四个不同形式的getBean方法，获取实例
	     */
	  /*  Object getBean(String name) throws BeansException;
	    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
	    <T> T getBean(Class<T> requiredType) throws BeansException;
	    Object getBean(String name, Object... args) throws BeansException;
	    boolean containsBean(String name); // 是否存在
	    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;// 是否为单实例
	    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;// 是否为原型（多实例）
	    boolean isTypeMatch(String name, Class<?> targetType)
	     throws NoSuchBeanDefinitionException;// 名称、类型是否匹配
	    Class<?> getType(String name) throws NoSuchBeanDefinitionException; // 获取类型
	    String[] getAliases(String name);// 根据实例的名字获取实例的别名
	}
	 具体：
	　　1、4个获取实例的方法。getBean的重载方法。
	　　2、4个判断的方法。判断是否存在，是否为单例、原型，名称类型是否匹配。
	　　3、1个获取类型的方法、一个获取别名的方法。根据名称获取类型、根据名称获取别名。一目了然！
	总结：
	　　这10个方法，很明显，这是一个典型的工厂模式的工厂接口。
	三、可将Bean逐一列出的工厂——ListableBeanFactory
	源码：
	public interface ListableBeanFactory extends BeanFactory {
	    boolean containsBeanDefinition(String beanName);   //  对于给定的名字有多少份BeanDefinition
	    int getBeanDefinitionCount();  //  返回工厂的BeanDefinition总数
	    String[] getBeanDefinitionNames(); //  返回工厂中所有Bean的名字
	    String[] getBeanNamesForType(Class<?> type);   //  返回对于指定类型Bean（包括子类）的所有名字*/
	    /*
	     * 返回指定类型的名字
	     * includeNonSingletons为false表示只取单例Bean，true则不是
	     * allowEagerInit为true表示立刻加载，false表示延迟加载。
	     * 注意：FactoryBeans都是立刻加载的。
	     */
/*
	    String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);
	    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException; //根据类型（包括子类）返回指定Bean名和Bean的Map   
	    <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit)
	            throws BeansException;
	    Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType)
            throws BeansException;   //  根据注解类型，查找所有有这个注解的Bean名和Bean的Map
	    <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType);//根据指定Bean名和注解类型查找指定的Bean
	}*/
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
    	ObjectMapper mapper = context.getBean(ObjectMapper.class);
    	      System.out.println(mapper);

	}
}

