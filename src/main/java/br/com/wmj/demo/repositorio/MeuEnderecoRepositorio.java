/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wmj.demo.repositorio;

import br.com.wmj.demo.domain.MeuEndereco;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author desenv-01
 */
@Repository
public interface MeuEnderecoRepositorio extends JpaRepository<MeuEndereco, Integer>{
    
}
