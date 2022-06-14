package br.com.juba.pos.service;

import br.com.juba.pos.model.Endereco;

public class EnderecoService {

    public Endereco criarEndereco(){

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Xuxu");
        endereco.setBairro("Sobradinho");
        endereco.setCep("17458526");
        endereco.setCidade("Brasilia");
        return endereco;

    }
}
