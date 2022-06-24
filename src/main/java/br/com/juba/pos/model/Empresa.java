package br.com.juba.pos.model;

//Classe empresa
public class Empresa {
    private long id;
    private String nome;
    private String endereco;
    
    public long getId() {
        return id;
    }
    public void setId(long l) {
        this.id = l;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
