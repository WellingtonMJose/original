package br.com.wmj.demo;

import br.com.wmj.demo.domain.Endereco;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class DemoApplicationTests {

	@Test
	public void consumerAPI() {
            RestTemplate template = new RestTemplate();
            UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("viacep.com.br")
                    .path("/ws/07260470/json/")
                    .build();
            
            ResponseEntity<Endereco> entity = template.getForEntity(uri.toUriString(), Endereco.class);
            
            System.out.println(entity.getBody().getBairro());
	}

}
