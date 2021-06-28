package br.com.zupacademy.william.casadocodigo.cadastroLivro;


public class LivroResponse {

    private Long id;

    private String titulo;

    public LivroResponse(Livro livro) {
        this.id =  livro.getId();
        this.titulo = livro.getTitulo();
    }

    @Override
    public String toString() {
        return "LivroResponse{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}


