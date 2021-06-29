package br.com.zupacademy.william.casadocodigo.cadastroPaisEstado;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class EstadoForm {

    @NotNull
    @NotBlank
    private String nome;

    private Object getIdPais() {
        return idPais;
    }

    @NotNull
    private Long idPais;

    public Estado converter(EntityManager manager) {

        Query query = manager.createQuery("from Estado where nome='" + nome + "' and pais_id=" + idPais);
        List resultList = query.getResultList();
        Assert.state(resultList.size() == 0, "O estado " + nome + " já se encontra nesse Pais");

        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(pais != null, "Pais não encontrado: " + idPais);

        return new Estado(nome, pais);
    }

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }
}
