package br.com.zupacademy.william.casadocodigo.cadastroAutor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {


    @Autowired
    private AutorRepository repository;

    @PostMapping  @Transactional
    public ResponseEntity<?> novoAutor(@RequestBody @Valid AutorForm form) {
        Autor autor = form.converter( );
        repository.save(autor);

        return ResponseEntity.ok().build();

    }

}
