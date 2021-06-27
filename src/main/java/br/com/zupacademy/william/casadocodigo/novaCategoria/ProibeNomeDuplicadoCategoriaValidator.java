package br.com.zupacademy.william.casadocodigo.novaCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCategoriaForm request = (NovaCategoriaForm) target;
        List<Categoria> categoriaList = categoriaRepository.findByNome(request.getNome());

        if(categoriaList.size()>0){
            errors.rejectValue("Nome", null, "Já existe essa categoria cadastrada "+request.getNome());
        }
    }
}
