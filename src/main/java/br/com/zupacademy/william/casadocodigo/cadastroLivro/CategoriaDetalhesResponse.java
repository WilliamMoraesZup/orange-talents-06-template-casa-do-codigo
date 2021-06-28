package br.com.zupacademy.william.casadocodigo.cadastroLivro;

import br.com.zupacademy.william.casadocodigo.cadastroCategoria.Categoria;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDetalhesResponse {

    @NotNull @NotBlank
    private String nome;

    public CategoriaDetalhesResponse(@Valid Categoria categoria) {
        this.nome = categoria.getNome();
    }



    public String getNome() {
        return nome;
    }
}
