package br.com.zupacademy.william.casadocodigo.novoAutor;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class AutorForm {

    @Autowired
    private AutorRepository repository;
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

    public AutorForm() {
    }

    @Override
    public String toString() {
        return "AutorForm{" +

                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Autor converter(AutorRepository repository) {
        List<Autor> byEmail = repository.findByEmail(email);
        Assert.isTrue(byEmail.size()==0, "Email já se encontra cadastrado");
        return new Autor(nome, email, descricao);
    }


    public String getEmail() {
        return email;
    }

}
