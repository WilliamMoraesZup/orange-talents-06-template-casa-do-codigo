package br.com.zupacademy.william.casadocodigo.cadastroPaisEstado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @Deprecated
    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }


}
