package br.com.zupacademy.william.casadocodigo.cadastroCategoria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    public ResponseEntity<?> novaCategoria(@RequestBody @Valid NovaCategoriaForm form) {

        Categoria categoria = form.converter();
        repository.save(categoria);

        return ResponseEntity.ok(categoria);
    }
}
