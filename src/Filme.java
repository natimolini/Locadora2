public class Filme {
    private String titulo;
    private String genero;
    private boolean alugado;

    public Filme(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.alugado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void alugar() {
        this.alugado = true;
    }

    public void devolver() {
        this.alugado = false;
    }

@Override
    public String toString() {
        return "Filme: " + titulo + " | Gênero: " + genero + " | Disponível: " + (alugado ? "Sim" : "Não");
    }
}
