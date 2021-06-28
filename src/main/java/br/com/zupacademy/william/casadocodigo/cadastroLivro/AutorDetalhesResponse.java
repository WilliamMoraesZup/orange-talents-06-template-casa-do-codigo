package br.com.zupacademy.william.casadocodigo.cadastroLivro;

import br.com.zupacademy.william.casadocodigo.cadastroAutor.Autor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AutorDetalhesResponse {

    @NotNull
    @NotBlank
    private String nome; @NotNull @NotBlank
    private String descricao;

    public AutorDetalhesResponse(@Valid  Autor autor  ) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }


    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
}
