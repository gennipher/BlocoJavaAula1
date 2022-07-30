package br.infnet.apiservice.model;

public class Produto {
    private long id;
    private String nome;
    private String marca;

    public Produto(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto(long id, String nome, String marca){
        this.setId(id);
        this.setNome(nome);
        this.setMarca(marca);
    }
}