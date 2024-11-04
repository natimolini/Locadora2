import java.util.ArrayList;

public class Locadora {
    private ArrayList<Filme> filmes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Função para adicionar um novo filme
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        System.out.println("Filme adicionado: " + filme.getTitulo());
    }

    // Função para remover um filme pelo título
    public void removerFilme(String titulo) {
        Filme filme = buscarFilme(titulo);
        if (filme != null) {
            filmes.remove(filme);
            System.out.println("Filme removido: " + titulo);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    // Função para buscar um filme pelo título
    public Filme buscarFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                return filme;
            }
        }
        System.out.println("Filme não encontrado.");
        return null;
    }

    // Função para cadastrar um novo cliente
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome());
    }

    // Função para remover um cliente pelo CPF
    public void removerCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Função para buscar um cliente pelo CPF
    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente não encontrado.");
        return null;
    }

    // Função para alugar um filme
    public void alugarFilme(String titulo, String cpf) {
        Filme filme = buscarFilme(titulo);
        Cliente cliente = buscarCliente(cpf);

        if (filme != null && cliente != null) {
            if (filme.isDisponivel()) {
                filme.setDisponivel(false);
                System.out.println("Filme alugado: " + titulo + " para o cliente: " + cliente.getNome());
            } else {
                System.out.println("Filme indisponível para aluguel.");
            }
        } else {
            System.out.println("Filme ou cliente não encontrado.");
        }
    }

    // Função para devolver um filme
    public void devolverFilme(String titulo) {
        Filme filme = buscarFilme(titulo);
        if (filme != null && !filme.isDisponivel()) {
            filme.setDisponivel(true);
            System.out.println("Filme devolvido: " + titulo);
        } else {
            System.out.println("Erro ao devolver o filme. Verifique se o filme está alugado.");
        }
    }

    // Novo método: retorna a lista de clientes
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}

