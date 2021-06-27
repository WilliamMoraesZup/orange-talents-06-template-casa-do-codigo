package br.com.zupacademy.william.casadocodigo.novoAutor;



import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Email  //@DeveSerUnico
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
