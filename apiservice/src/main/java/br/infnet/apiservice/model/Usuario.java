package br.infnet.apiservice.model;

public class Usuario {
    private long id;
    private String nome;
    private String sobrenome;
    private String email;

    public Usuario() {
        
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario(Long id, String nome, String sobrenome, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setEmail(email);
    }
}
