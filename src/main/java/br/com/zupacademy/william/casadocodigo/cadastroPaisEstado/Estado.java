package br.com.zupacademy.william.casadocodigo.cadastroPaisEstado;


import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;
    @Deprecated
    public Estado() {
    }


    public Estado(String nome, Pais pais) {
        Assert.state(pais!=null, "ocorreu um bug no sistema, o pais não existe");
        this.nome = nome;
        this.pais = pais;
    }
}
