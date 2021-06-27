package br.com.zupacademy.william.casadocodigo.novaCategoria;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaForm {

    @NotNull
    @NotBlank
    private String nome;

    @Override
    public String toString() {
        return "NovaCategoriaForm{" +
                "nome='" + nome + '\'' +
                '}';
    }
    public Categoria converter() {
        return new Categoria(nome);
    }

    public String getNome() {
        return
                 nome;
    }
}
