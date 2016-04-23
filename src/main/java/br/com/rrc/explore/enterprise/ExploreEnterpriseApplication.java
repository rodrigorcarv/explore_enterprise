package br.com.rrc.explore.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ExploreEnterpriseApplication {
	
	@RequestMapping("/")
    @ResponseBody
    public String index(){
        return "funciona?";
    }

	public static void main(String[] args) {
		SpringApplication.run(ExploreEnterpriseApplication.class, args);
	}
}
