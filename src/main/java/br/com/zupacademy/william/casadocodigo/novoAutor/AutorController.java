package br.com.zupacademy.william.casadocodigo.novoAutor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AutorController {

@Autowired
private AutorRepository repository;


    @PostMapping
    public ResponseEntity<?> novoAutor(@RequestBody @Valid AutorForm form)  {


        Autor autor = form.converter(repository);
        repository.save(autor);

        return ResponseEntity.ok(autor);

    }

}
