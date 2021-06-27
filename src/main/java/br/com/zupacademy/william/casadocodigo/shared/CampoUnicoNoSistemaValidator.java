package br.com.zupacademy.william.casadocodigo.shared;

import br.com.zupacademy.william.casadocodigo.shared.DeveSerUnico;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoUnicoNoSistemaValidator implements ConstraintValidator<DeveSerUnico, String> {

    private String campo;
    private Class entidade;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(DeveSerUnico constraintAnnotation) {
        campo = constraintAnnotation.campo();
        entidade = constraintAnnotation.entidade();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("From " +entidade.getName()+ " where "+campo+" = :pValue");
        query.setParameter("pValue", value);
        List resultList = query.getResultList();
        if (resultList.size()!=0){
               return false;
        }

        return true;
    }
}
