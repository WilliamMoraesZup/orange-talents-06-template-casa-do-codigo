package br.com.zupacademy.william.casadocodigo.cadastroPaisEstado;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/localidade")
public class PaisEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/pais")
    @Transactional
    public ResponseEntity<?> novoPais(@RequestBody @Valid PaisForm form) {
        Pais pais = form.converter();
        manager.persist(pais);


        return ResponseEntity.ok(pais);
    }

    @PostMapping("/estado")
    @Transactional
    public ResponseEntity<?> novoEstado(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.converter(manager);
        manager.persist(estado);

        return ResponseEntity.ok(estado);
    }
}
