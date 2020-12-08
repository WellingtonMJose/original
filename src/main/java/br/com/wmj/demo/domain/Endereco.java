/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wmj.demo.domain;

/**
 *
 * @author desenv-01
 */
public class Endereco {

    private String bairro;
    private String cep;
    private String localidade;
    private String uf;
    private String logradouro;

    public Endereco() {
    }

    public Endereco(String bairro, String cep, String localidade, String uf, String logradouro) {
        this.bairro = bairro;
        this.cep = cep;
        this.localidade = localidade;
        this.uf = uf;
        this.logradouro = logradouro;

    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
