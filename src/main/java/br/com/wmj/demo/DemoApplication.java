package br.com.wmj.demo;

import br.com.wmj.demo.domain.Endereco;
import org.hibernate.query.QueryParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://viacep.com.br/ws/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        
        
 
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
