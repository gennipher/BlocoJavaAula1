package br.infnet.apiservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.infnet.apiservice.model.Produto;

// http://localhost:8080/produtos
@RestController
@RequestMapping("/produtos") // indica qual recurso esse controller irá responder
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    
    //GET
    @GetMapping
    public String listar() {

        var produtos_response = "Nenhum produto encontrado!";

        if(!produtos.isEmpty()){
            produtos_response = "";
            for(Produto p: produtos) {
                produtos_response += p.getNome() + ", ";
            }
        }

        return produtos_response;
    }

    // http://localhost:8080/produtos/{id}
    // GET
    @GetMapping("/{id}")
    public String exibir(@PathVariable long id){
        
        var produtos_response = "Nenhum produto encontrado!";

        if(!produtos.isEmpty()) {
            produtos_response = "";

            for(Produto p: produtos) {
                if(p.getId()== id){
                    produtos_response = p.getNome();
                }
            }
        }

        return "LISTA DE PRODUTOS\n-----------\n" + produtos_response;
    }

    // POST
    @PostMapping
    public String inserir(@RequestBody Produto produto){

        long newId = produtos.size() + 1;
        produto.setId(newId);

        produtos.add(produto);

        return "PRODUTO ADICIONADO\n-----------\nNOME: " + produto.getNome() + "\nID: " + produto.getId();
    }

    // PUT
    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody Produto produto){

        var produtos_response = "Nenhum produto encontrado!";

        if(!produtos.isEmpty()) {

            produtos_response = "";

            for(Produto p: produtos) {
                if(p.getId()== id){
                    p.setNome(produto.getNome());
                    p.setMarca(produto.getMarca());
                    produtos_response = "NOME: " + p.getNome() + "\nMARCA: " + p.getMarca();
                }
            }
        }

        return "PRODUTO ATUALIZADO\n-----------\n" + produtos_response;
    }

    // PATCH
    /*
    @PatchMapping("/{id}")
    public String alterar(@PathVariable Long id, @RequestBody Produto produto){
        return "Produto " + id + " alterado";
    }
    */

    // DELETE
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id){

        if(!produtos.isEmpty()) {

            for(Produto p: produtos) {
                if(p.getId()== id){
                    produtos.remove(p);
                    return "PRODUTO APAGADO!";
                }
            }
        }

        
        
        return "LISTA DE PRODUTOS VAZIA!";
    }

}
