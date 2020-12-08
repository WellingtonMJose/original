/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wmj.demo.services;

import br.com.wmj.demo.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author desenv-01
 */
@Service
public class EnderecoService {
    
   @Autowired
   private WebClient webClient;
   
   WebClient client = WebClient.create("https://viacep.com.br/ws");
   
    
    public Mono<Endereco> find(String endereco ) {
         return this.client
                .method(HttpMethod.GET)
                .uri("/{endereco}/json", endereco)
                .retrieve()
                .bodyToMono(Endereco.class);
        
    }
    
    
}
