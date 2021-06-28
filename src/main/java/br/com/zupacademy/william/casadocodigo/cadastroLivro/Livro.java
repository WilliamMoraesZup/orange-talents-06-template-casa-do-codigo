package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import br.com.zupacademy.william.casadocodigo.cadastroCategoria.Categoria;
import br.com.zupacademy.william.casadocodigo.cadastroAutor.Autor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull  @NotBlank private String titulo;
    @NotNull  @NotBlank @Length(max = 500) private String resumo;
    @NotNull  @NotBlank private String sumario;
    @NotNull  @Min (20) private BigDecimal preco;
    @NotNull  @Positive @Min( 100) private int numeroPaginas;
    @NotNull  @NotBlank  String isbn;
    private @NotNull @Future Date dataDuplicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, @NotNull @Future Date dataDuplicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataDuplicacao = dataDuplicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
