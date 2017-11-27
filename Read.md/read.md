2017.11.27
spring-boot 文档阅读14.1

   Spring Boot不需要任何特定的代码布局来工作，但是，有一些包对
这有帮助。

   14.1使用“默认”包
	当类不包含包声明时，它被认为是在“默认包”中。
使用“默认程序包”通常是不鼓励的，应该避免使用。它可能导致
使用@ componentscan、@ entityscan或
@ springbootapplication注释，因为每个jar中的每个类都将被读取。
   
   14.2定位主应用程序类
	我们通常建议您将主要应用程序类放在根包之类。@enableautoconfiguration注释通常放在您的主类上
隐式定义了对某些项目的基本“搜索包”。例如，如果您正在编写一个JPA
应用程序，@ enableautoconfiguration注释类的包将用于搜索@ entity物品。
       
       使用根包也允许在不需要的情况下使用@ componentscan注释
指定一个basePackage属性。您还可以使用@ springbootapplication注释
主类在根包中。
这里有一个典型的布局:
com
	+- example
	+- myproject
	+- Application.java
|
+- domain
|	    +- Customer.java
| 		+- CustomerRepository.java
|
+- service
| 		+- CustomerService.java
|
+- web
		+- CustomerController.java

     我们通常建议您的主源是一个@ configuration类。

  15.1导入额外的配置类
  
        您不需要将所有的@ configuration放到一个类中。@ import
 注释可以用于导入额外的配置类。或者，可以使用@ componentscan
自动获取所有Spring组件，包括@ configuration类。

	15.2导入XML配置
     如果您绝对必须使用基于XML的配置，我们建议您仍然从a开始@ configuration类。
然后，您可以使用一个附加的@ importresource注释来加载XML配置文件。
  
   16. Auto-configuration auto自动配置
   Spring启动自动配置尝试基于此自动配置您的Spring应用程序jar依赖项，您已经添加了。例如，如果HSQLDB在您的类路径上，并且您有不手动配置任何数据库连接bean，然后我们将自动配置内存数据库。
  
    您需要通过添加@ enableautoconfiguration来选择加入自动配置

@ springbootapplication注释到一个@ configuration类。
		提示
			您应该只添加一个@ enableautoconfiguration注释。我们一般
			建议将其添加到主@ configuration类中。
			
16.2禁用特定的自动配置
       如果您发现特定的自动配置类正在应用于您不想要的，您可以使用
排除@ enableautoconfiguration的属性来禁用它们。	
		
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;
	@Configuration
	@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
		public class MyConfiguration {
		}
			
   
   17Spring bean和依赖项注入
       
       您可以自由使用任何标准Spring框架技术来定义您的bean和它们
依赖项注入。为了简单起见，我们经常发现使用@ componentscan来找到您的bean
结合@ autowired构造函数注入工作良好。
 package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	@Service
		public class DatabaseAccountService implements AccountService {
		private final RiskAssessor riskAssessor;
		@Autowired
		public DatabaseAccountService(RiskAssessor riskAssessor) {
				this.riskAssessor = riskAssessor;
		}
	}
			
	18。使用@SpringBootApplication注释		
	许多Spring引导开发人员总是使用@ configuration注释他们的主类，
Spring Boot提供了一个方便的方法
@SpringBootApplication选择。
@ springbootapplication注释相当于使用@ configuration，
@ enableautoconfiguration和@ componentscan的默认属性:			
		
package com.example.myproject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication //等同于@Configuration@EnableAutoConfiguration @ComponentScan
	public class Application {
		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
	}

19。运行您的应用程序
        将应用程序打包为jar并使用嵌入式HTTP的最大优点之一
服务器是你可以像你一样运行你的应用程序。调试启动应用程序
也容易;您不需要任何特殊的IDE插件或扩展。

     提示
         如果您两次意外地运行web应用程序，您将看到一个“已经使用的端口”错误。STS用户
可以使用重新启动按钮，而不是运行，以确保关闭任何现有实例。

  19.2作为一个打包应用程序运行
       如果您使用Spring引导Maven或Gradle插件来创建可执行的jar，您可以运行您的
应用程序使用java jar。例如:
    $ java -jar target/myproject-0.0.1-SNAPSHOT.jar

      还可以在启用远程调试支持的情况下运行打包应用程序。这允许
    $ java -Xdebug 
    
    -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
    -jar target/myproject-0.0.1-SNAPSHOT.jar


  19.3使用Maven插件
Spring引导Maven插件包括一个可以用来快速编译和运行您的运行目标
应用程序。在您的IDE中，应用程序以一个exploded的形式运行。
         $ mvn spring-boot:run

您可能还希望使用有用的操作系统环境变量:
        $ export MAVEN_OPTS=-Xmx1024m -XX:MaxPermSize=128M

    19.4使用Gradle插件
Spring Boot Gradle插件还包括一个bootRun任务，可以用来运行应用程序
在一个exploded的形式。当您导入spring -boot- gradleplugin时，将添加bootRun任务:
    
       $ gradle bootRun

您可能还想使用这个有用的操作系统环境变量:
        $ export JAVA_OPTS=-Xmx1024m -XX:MaxPermSize=128M

 20。开发人员工具
  Spring Boot包括一组额外的工具，这些工具可以使spring-boot- devtools模块可以包含在任何项目中
额外的开发时间特性。要包括devtools支持，只需添加模块依赖项您的构建:
   Maven.
   
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>
</dependencies>



23.8
         如果您需要在SpringApplication启动后运行一些特定的代码，您可以实现
ApplicationRunner或CommandLineRunner接口。两个接口都是相同的
方式,提供一个单一的运行方法将调用之前SpringApplication.run(…)完成。
     
     CommandLineRunner接口提供对应用程序参数的访问作为一个简单的字符串
数组，而ApplicationRunner使用ApplicationArguments接口



其他课堂内容笔记
    1配置lombok.jar包到STS.exe下.安装环境选择在STS安装时的位置.
    2打包 mvn -Pnexus package DskipTests

