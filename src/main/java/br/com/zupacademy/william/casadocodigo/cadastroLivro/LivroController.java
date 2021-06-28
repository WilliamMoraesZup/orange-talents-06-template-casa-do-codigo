package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    public ResponseEntity<?> novoLivro(@RequestBody @Valid LivroForm form) {
      Livro livro = form.converter(manager);
        repository.save(livro);
        return ResponseEntity.ok(livro) ;
    }

    @GetMapping
    public ResponseEntity<?> buscaLivro(){

        List<LivroResponse> livroResponses = repository.findAll()
                .stream().map(LivroResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(livroResponses);
    }

}
