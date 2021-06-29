package br.com.zupacademy.william.casadocodigo.cadastroCliente;


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
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> novoCliente(@RequestBody @Valid ClienteForm form) {

        Cliente entidade = form.converter(manager);
        manager.persist(entidade);

        return ResponseEntity.ok(new ClienteResponseID(entidade));
    }


}
