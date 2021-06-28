package br.com.zupacademy.william.casadocodigo.cadastroCategoria;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    public Categoria(@NotNull @NotBlank String nome) {
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
