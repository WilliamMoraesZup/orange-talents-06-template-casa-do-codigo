package br.com.zupacademy.william.casadocodigo.cadastroPaisEstado;

import br.com.zupacademy.william.casadocodigo.shared.DeveSerUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaisForm {

    @NotNull
    @NotBlank
    @DeveSerUnico(campo = "nome", entidade = Pais.class)
    private String nome;

    public Pais converter() {
        return new Pais(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PaisForm{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
