package br.com.zupacademy.william.casadocodigo.cadastroLivro;


import br.com.zupacademy.william.casadocodigo.cadastroAutor.Autor;
import br.com.zupacademy.william.casadocodigo.cadastroCategoria.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
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
    @NotNull  @NotBlank private String isbn;
    @NotNull @Future private Date dataDuplicacao;

    @ManyToOne @NotNull @Valid
    private Categoria categoria;

    @ManyToOne  @NotNull @Valid
    private Autor autor;
    @Deprecated
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

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getDataDuplicacao() {
        return dataDuplicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
