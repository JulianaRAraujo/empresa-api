package br.com.juba.pos.service;

import java.util.UUID;

import br.com.juba.pos.model.Empresa;
import br.com.juba.pos.model.Endereco;

public class EmpresaService {
    public Empresa criarEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setId(UUID.randomUUID());
        empresa.setNome("Minha Empresa");
        Endereco endereco = new Endereco();
        endereco.setBairro("Limoeiro");
        endereco.setCidade("Bauru");
        endereco.setEstado("São Paulo");
        endereco.setLogradouro("Rua do Jaú");
        endereco.setNumero(10);
        empresa.setEndereco(endereco);
        return empresa;
    }
}
