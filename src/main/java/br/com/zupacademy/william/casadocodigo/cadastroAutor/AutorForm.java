package br.com.zupacademy.william.casadocodigo.cadastroAutor;

import br.com.zupacademy.william.casadocodigo.shared.DeveSerUnico;
import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Email
    @DeveSerUnico(campo = "email", entidade = Autor.class)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorForm(@NotNull
                     @NotBlank String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "AutorForm{" +

                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    /**
     * @param nome Não pode ser nulo
     */
    public Autor converter() {
        return new Autor(nome, email, descricao);
    }

    public String getEmail() {
        return email;
    }

}
