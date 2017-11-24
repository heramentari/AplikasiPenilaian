package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PenilaianApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run (PenilaianApplication.class, args);
    }
    

	// create new bean for restTemplate
	// https://stackoverflow.com/questions/28024942/how-to-autowire-resttemplate-using-annotations
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
