/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wmj.demo.resources;

import br.com.wmj.demo.domain.Endereco;
import br.com.wmj.demo.domain.MeuEndereco;
import br.com.wmj.demo.services.MeuEnderecoService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

/**
 *
 * @author desenv-01
 */
@RestController
@RequestMapping(value = "wmj/v1/endereco")
public class MeuEnderecoResource {

    @Autowired
    private MeuEnderecoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json", consumes="application/json")
    public ResponseEntity<MeuEndereco> find(@PathVariable Integer id) {
        MeuEndereco obj = service.find(id);
        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody MeuEndereco obj) {
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody MeuEndereco obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

}
