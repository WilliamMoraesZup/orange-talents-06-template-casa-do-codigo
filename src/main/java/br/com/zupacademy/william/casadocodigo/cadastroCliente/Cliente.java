package br.com.zupacademy.william.casadocodigo.cadastroCliente;

import br.com.zupacademy.william.casadocodigo.cadastroPaisEstado.Estado;
import br.com.zupacademy.william.casadocodigo.cadastroPaisEstado.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String sobrenome;

    @NotNull
    @NotBlank
    private String email;


    @NotNull
    @NotBlank
    private String documento;

    @NotNull
    @NotBlank
    private String endereco;

    @NotNull
    @NotBlank
    private String complemento;

    @NotNull
    @NotBlank
    private String cidade;

    @NotNull
    @NotBlank
    private String telefone;

    @NotNull
    @NotBlank
    private String cep;

    @NotNull
    @ManyToOne
    private Pais pais;

    @NotNull
    @ManyToOne
    private Estado estado;

    public Cliente(String nome,  String email, String sobrenome, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Pais pais, Estado estado) {
        this.nome = nome;
        this.email = email;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Cliente() {
    }
}
