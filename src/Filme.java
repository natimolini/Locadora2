public class Filme {
    private String titulo;
    private boolean disponivel;

    public Filme(String titulo) {
        this.titulo = titulo;
        this.disponivel = true; // Todos os filmes são disponíveis no início
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Filme{" + "titulo='" + titulo + '\'' + ", disponivel=" + disponivel + '}';
    }
}

