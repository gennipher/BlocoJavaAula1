package br.infnet.apiservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.infnet.apiservice.model.Usuario;

// http://localhost:8080/usuarios
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    //GET
    @GetMapping
    public ResponseEntity listar() {
        if(usuarios.isEmpty())
            return ResponseEntity.status(204).body("Usuario não encontrado.")
        return ResponseEntity.ok().body(usuarios);
    }


    // http://localhost:8080/usuarios/{id}
    //GET
    @GetMapping("/{id}")
    public ResponseEntity exibir(@PathVariable Long id) {
        for(Usuario u : usuarios) {
            if(u.getId() == id)
            return ResponseEntity.ok().body(u);
        }
        return ResponseEntity.status(404).body("Usuario não encontrado.");
    }

    //POST
    @PostMapping
    public ResponseEntity inserir(@RequestMapping Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null)
            return ResponseEntity.status(400).body("Dados incorretos.");
        
        var lastIndex = 0L;
        if(!usuarios.isEmpty())
            lastIndex = usuarios.get(usuarios.size() -1).getId();
        usuario.setId(lastIndex + 1);

        if(usuarios.add(usuario))
            return ResponseEntity.status(201).body(usuario);
    
        return ResponseEntity.status(500).body("Erro interno.");
    }

    //PUT
    //PATCH
    //DELETE


}
