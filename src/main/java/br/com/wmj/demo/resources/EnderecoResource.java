/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wmj.demo.resources;

import br.com.wmj.demo.domain.Endereco;
import br.com.wmj.demo.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

/**
 *
 * @author desenv-01
 */
@RestController
@RequestMapping(value="wmj/v2/endereco")
public class EnderecoResource {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Endereco>> find(@PathVariable String cep) throws Exception{
        Mono<Endereco> endereco = enderecoService.find(cep);
        return ResponseEntity.ok().body(endereco);
    }
    
}
