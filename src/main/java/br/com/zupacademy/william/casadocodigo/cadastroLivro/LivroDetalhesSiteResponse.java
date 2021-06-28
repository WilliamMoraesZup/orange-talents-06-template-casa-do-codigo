package br.com.zupacademy.william.casadocodigo.cadastroLivro;

import javax.validation.Valid;
import java.math.BigDecimal;

public class LivroDetalhesSiteResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;

    private AutorDetalhesResponse autor;
    private CategoriaDetalhesResponse categoria;

    public LivroDetalhesSiteResponse(@Valid Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();

        this.autor = new AutorDetalhesResponse(livro.getAutor());
        this.categoria = new CategoriaDetalhesResponse(livro.getCategoria());

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

    public AutorDetalhesResponse getAutor() {
        return autor;
    }

    public CategoriaDetalhesResponse getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "LivroSiteResponse{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}
