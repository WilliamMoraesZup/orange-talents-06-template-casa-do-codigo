package br.com.zupacademy.william.casadocodigo.cadastroAutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorForm request = (AutorForm) target;
        List<Autor> categoriaList = autorRepository.findByEmail(request.getEmail());

        if(categoriaList.size()>0){
            errors.rejectValue("Email", null, "Já existe essa email cadastrado "+request.getEmail());
        }
    }
}
