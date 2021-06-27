package br.com.zupacademy.william.casadocodigo.novoAutor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AutorController {

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(proibeEmailDuplicadoAutorValidator);

    }


    @Autowired
    private AutorRepository repository;


    @PostMapping
    public ResponseEntity<?> novoAutor(@RequestBody @Valid AutorForm form) {


        Autor autor = form.converter(repository);
        repository.save(autor);

        return ResponseEntity.ok(autor);

    }

}
