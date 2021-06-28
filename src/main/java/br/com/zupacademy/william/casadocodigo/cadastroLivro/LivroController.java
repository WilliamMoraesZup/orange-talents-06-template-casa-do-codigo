package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @Autowired
    @PersistenceContext
    private EntityManager manager;
    @PostMapping
    public ResponseEntity<?> novoLivro(@RequestBody @Valid LivroForm form) {
      Livro livro = form.converter(manager);
        repository.save(livro);

        return ResponseEntity.ok(livro) ;

    }

}
