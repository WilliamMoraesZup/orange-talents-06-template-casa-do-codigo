package br.com.zupacademy.william.casadocodigo.novoAutor;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull    @NotBlank
    private String nome;
    @NotNull    @NotBlank   @Email  @Column(unique = true)
    private String email;
    @NotNull    @NotBlank @Size(max = 400)
    private String descricao;
    private Instant instanteDeCriacao = Instant.now();

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}
