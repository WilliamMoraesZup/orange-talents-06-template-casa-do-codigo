package br.com.zupacademy.william.casadocodigo.novoAutor;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class AutorForm {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull    @NotBlank    @Email
    private String email;
    @NotNull    @NotBlank @Size(max = 400)
    private String descricao;
    private Instant instanteDeCriacao = Instant.now();

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}
