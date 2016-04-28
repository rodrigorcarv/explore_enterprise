package br.com.rrc.explore.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="br.com.rrc.explore")
public class ExploreEnterpriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExploreEnterpriseApplication.class, args);
	}
}
