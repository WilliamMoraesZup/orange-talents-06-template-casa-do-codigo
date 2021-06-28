package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import br.com.zupacademy.william.casadocodigo.cadastroAutor.Autor;
import br.com.zupacademy.william.casadocodigo.cadastroCategoria.Categoria;
import br.com.zupacademy.william.casadocodigo.shared.DeveSerUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class LivroForm {


    @NotNull
    @NotBlank
    @DeveSerUnico(campo = "titulo", entidade = Livro.class)
    private String título;
    @NotNull
    @NotBlank
    @Length(max = 500)
    private String resumo;
    @NotNull
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Positive
    @Min(100)
    private int numeroPaginas;

    @NotNull
    @NotBlank  @DeveSerUnico(campo = "isbn", entidade = Livro.class) String isbn;

    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataPublicacao;


    @NotNull
    private Long idCategoria;
    @NotNull
    private Long idAutor;

    public Livro converter(EntityManager manager) {
        System.out.println("CONVERTER");

        Categoria categoria = manager.find(Categoria.class, idCategoria);
        Autor autor = manager.find(Autor.class, idAutor);

        Assert.state(categoria!=null, "Categoria não encontrada");
        Assert.state(autor!=null, "Autor não encontrado");

        return new Livro(título, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao,
                categoria, autor);
    }


    public LivroForm(String título, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, Date dataPublicacao, Long idCategoria, Long idAutor) {
        this.título = título;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }
}


