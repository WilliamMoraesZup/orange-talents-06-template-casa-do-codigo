package br.com.zupacademy.william.casadocodigo.novaCategoria;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank @Column(unique = true)
    private String nome;

    public Categoria(@javax.validation.constraints.NotNull @NotBlank String nome  ) {
        this.nome = nome;
    }
@Deprecated
    public Categoria() {
    }

    @Override
    public String toString() {
        return "Categoria{" +

                ", nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
