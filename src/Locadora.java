import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Filme> filmes;
    private List<Cliente> clientes;

    public Locadora() {
        filmes = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void adicionarFilme(String titulo, String genero) {
        filmes.add(new Filme(titulo, genero));
    }

    public void removerFilme(String titulo) {
        filmes.removeIf(filme -> filme.getTitulo().equals(titulo));
    }

    public Filme buscarFilme(String titulo) {
        return filmes.stream()
                .filter(filme -> filme.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    public void cadastrarCliente(String nome, String id) {
        clientes.add(new Cliente(nome, id));
    }

    public void removerCliente(String id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    public Cliente buscarCliente(String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    public Filme alugarFilme(String nomeCliente, String tituloFilme) {
        Cliente cliente = buscarCliente(nomeCliente);
        Filme filme = buscarFilme(tituloFilme);
        if (filme != null && cliente != null && !filme.isAlugado()) {
            filme.alugar();
            return filme;
        }
        return null;
    }

    public Filme devolverFilme(String tituloFilme) {
        Filme filme = buscarFilme(tituloFilme);
        if (filme != null && filme.isAlugado()) {
            filme.devolver();
            return filme;
        }
        return null;
    }
}

