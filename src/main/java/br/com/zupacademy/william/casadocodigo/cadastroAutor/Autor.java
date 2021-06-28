package br.com.zupacademy.william.casadocodigo.cadastroAutor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank

    private String nome;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;
    private Instant instanteDeCriacao = Instant.now();

    @Deprecated
    public Autor() {
    }


    public Autor(@NotNull @NotBlank String nome,
                 @NotNull @NotBlank String email,
                 @NotNull @NotBlank String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}
