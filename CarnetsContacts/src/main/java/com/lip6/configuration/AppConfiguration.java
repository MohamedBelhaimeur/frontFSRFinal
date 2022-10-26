package com.lip6.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//si je veux int�grer une config XML venant de mon legacy, j'utilise l'@ImportResource 
//@ImportResource(locations = {"classpath:spring/app-context-xml.xml"})

@ImportResource(locations = {"classpath:applicationContext.xml"})
@ComponentScan(basePackages = {"com.lip6.*"})
@Configuration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppConfiguration  {
	 public static void main(String[] args) {
	        SpringApplication.run(AppConfiguration.class, args);
	    }
	//plus rien dans la classe Java, juste une indication ou scanner les beans
}
