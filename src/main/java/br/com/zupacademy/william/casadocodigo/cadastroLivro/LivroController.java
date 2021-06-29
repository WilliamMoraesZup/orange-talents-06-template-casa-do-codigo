package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @PersistenceContext
    private EntityManager manager;

    @PostMapping  @Transactional
    public ResponseEntity<?> novoLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.converter(manager);
        manager.persist(livro);
        return ResponseEntity.ok( ).build();
    }

    @GetMapping
    public ResponseEntity<?> buscaLivro() {
        Query query = manager.createQuery("from Livro");
        List<Livro> resultList = query.getResultList();
        List<LivroListaResponse> listaResponses = resultList.stream().map(LivroListaResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(listaResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaDetalhesLivro(@PathVariable Long id) {
        Livro livro  = manager.find(Livro.class, id);


        if (livro!=null) {
            LivroDetalhesSiteResponse livroProSite = new LivroDetalhesSiteResponse(livro);
            return ResponseEntity.ok(livroProSite);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
