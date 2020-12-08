/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wmj.demo.services;

import br.com.wmj.demo.domain.Endereco;
import br.com.wmj.demo.domain.MeuEndereco;
import br.com.wmj.demo.repositorio.MeuEnderecoRepositorio;
import br.com.wmj.demo.services.exceptions.DataIntegrityException;
import br.com.wmj.demo.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author desenv-01
 */
@Service
public class MeuEnderecoService {
    
    @Autowired
    private EnderecoService service;
    
    @Autowired
    private MeuEnderecoRepositorio repo;
    
    WebClient client = WebClient.create("https://viacep.com.br/ws");
   
    
    public Mono<MeuEndereco> findCEP(String endereco ) {
         return this.client
                .method(HttpMethod.GET)
                .uri("/{endereco}/json", endereco)
                .retrieve()
                .bodyToMono(MeuEndereco.class);
        
    }
    
    public MeuEndereco save(MeuEndereco meuEndereco) {
        meuEndereco.setId(null);
        return repo.save(meuEndereco);       
        
    }    
    
     public MeuEndereco find(Integer id) {
        Optional<MeuEndereco> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + MeuEndereco.class.getName()));
    }
     
      public MeuEndereco update(MeuEndereco obj) {
        MeuEndereco newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas.");
        }
    }
    
     private void updateData(MeuEndereco newObj, MeuEndereco obj) {
        newObj.setCep(obj.getCep());
        newObj.setBairro(obj.getBairro());
        newObj.setComplemento(obj.getComplemento());
        newObj.setLocalidade(obj.getLocalidade());
        newObj.setLogradouro(obj.getLogradouro());
        newObj.setUf(obj.getUf());
        newObj.setNumero(obj.getNumero());
    }
}
