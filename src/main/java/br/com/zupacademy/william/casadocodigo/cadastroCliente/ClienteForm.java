package br.com.zupacademy.william.casadocodigo.cadastroCliente;

import br.com.zupacademy.william.casadocodigo.cadastroPaisEstado.Estado;
import br.com.zupacademy.william.casadocodigo.cadastroPaisEstado.Pais;
import br.com.zupacademy.william.casadocodigo.shared.DeveSerUnico;
import br.com.zupacademy.william.casadocodigo.shared.Documento;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteForm {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String sobrenome;

    @Email
    @NotNull
    @NotBlank
    @DeveSerUnico(campo = "email", entidade = Cliente.class)
    private String email;

    @NotNull
    @NotBlank
    @DeveSerUnico(campo = "documento", entidade = Cliente.class)
    @Documento
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
    private Long idEstado;

    @NotNull
    private Long idPais;

    public ClienteForm(String nome, String sobrenome, String email, String documento, String endereco, String complemento, String cidade, String telefone, String cep, Long idEstado, Long idPais) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idEstado = idEstado;
        this.idPais = idPais;
    }

    public Cliente converter(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(pais != null, "O pais não foi encontrado");

        Estado estado = manager.find(Estado.class, idEstado);
        Assert.state(estado != null, "O estado não foi encontrado");

        Query query = manager.createQuery("from Estado where id=:pIdEstado and pais_id=:pIdPais");
        query.setParameter("pIdEstado", idEstado);
        query.setParameter("pIdPais", idPais);

        List resultList = query.getResultList();
        Assert.state(resultList.size() == 1, "O pais selecionado não possui esse estado cadastrado");


        return new Cliente(nome, email, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais, estado);

    }
}
