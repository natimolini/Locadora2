import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora();

        // Testando as funcionalidades da locadora
        locadora.cadastrarCliente("João", "001");
        locadora.cadastrarCliente("Maria", "002");

        locadora.adicionarFilme("O Poderoso Chefão", "Drama");
        locadora.adicionarFilme("Matrix", "Ficção Científica");

        locadora.buscarFilme("O Poderoso Chefão");

        locadora.alugarFilme("João", "O Poderoso Chefão");
        locadora.buscarFilme("O Poderoso Chefão");

        locadora.devolverFilme("O Poderoso Chefão");
        locadora.buscarFilme("O Poderoso Chefão");

        locadora.buscarCliente("João");
        locadora.removerCliente("João");
        locadora.buscarCliente("João");

        // Testes
        testAdicionarFilme(locadora);
        testRemoverFilme(locadora);
        testBuscarFilme(locadora);
        testCadastrarCliente(locadora);
        testRemoverCliente(locadora);
        testBuscarCliente(locadora);
        testAlugarFilme(locadora);
        testDevolverFilme(locadora);
    }

    public static void testAdicionarFilme(Locadora locadora) {
        locadora.adicionarFilme("O Poderoso Chefão", "Drama");
        assertNotNull(locadora.buscarFilme("O Poderoso Chefão"), "Filme deve ser adicionado e encontrado");
    }

    public static void testRemoverFilme(Locadora locadora) {
        locadora.adicionarFilme("Matrix", "Ação");
        locadora.removerFilme("Matrix");
        assertNull(locadora.buscarFilme("Matrix"), "Filme deve ser removido e não encontrado");
    }

    public static void testBuscarFilme(Locadora locadora) {
        locadora.adicionarFilme("O Senhor dos Anéis", "Fantasia");
        assertNotNull(locadora.buscarFilme("O Senhor dos Anéis"), "Filme deve ser encontrado");
    }

    public static void testCadastrarCliente(Locadora locadora) {
        locadora.cadastrarCliente("Maria", "001");
        assertNotNull(locadora.buscarCliente("Maria"), "Cliente deve ser cadastrado e encontrado");
    }

    public static void testRemoverCliente(Locadora locadora) {
        locadora.cadastrarCliente("João", "002");
        locadora.removerCliente("002");
        assertNull(locadora.buscarCliente("João"), "Cliente deve ser removido e não encontrado");
    }

    public static void testBuscarCliente(Locadora locadora) {
        locadora.cadastrarCliente("Ana", "003");
        assertNotNull(locadora.buscarCliente("Ana"), "Cliente deve ser encontrado");
    }

    public static void testAlugarFilme(Locadora locadora) {
        locadora.cadastrarCliente("Maria", "001");
        locadora.adicionarFilme("O Poderoso Chefão", "Drama");
        locadora.alugarFilme("O Poderoso Chefão", "001");
        assertFalse(locadora.buscarFilme("O Poderoso Chefão").isAlugado(), "Filme deve estar alugado e não disponível");
    }

    public static void testDevolverFilme(Locadora locadora) {
        locadora.adicionarFilme("O Poderoso Chefão", "Drama");
        locadora.alugarFilme("O Poderoso Chefão", "001");
        locadora.devolverFilme("O Poderoso Chefão");
        assertTrue(locadora.buscarFilme("O Poderoso Chefão").isAlugado(), "Filme deve estar disponível após devolução");
    }

}
