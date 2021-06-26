package br.com.zupacademy.william.casadocodigo.novoAutor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AutorController {

@Autowired
private AutorRepository repository;


    @PostMapping
    public ResponseEntity<?> novoAutor(@RequestBody @Valid AutorForm form) {


        Autor autor = form.converter();
        repository.save(autor);

        return ResponseEntity.ok(autor);

    }

}
