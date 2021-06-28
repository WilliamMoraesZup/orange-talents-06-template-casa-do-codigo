package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import br.com.zupacademy.william.casadocodigo.cadastroAutor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
