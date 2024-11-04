public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora();

        // Teste 1: Adicionar um filme e verificar se foi adicionado corretamente
        Filme filme1 = new Filme("O Senhor dos Anéis");
        locadora.adicionarFilme(filme1);
        assertEquals(filme1, locadora.buscarFilme("O Senhor dos Anéis"), "O filme deveria estar na locadora.");

        // Teste 2: Adicionar um cliente e verificar se foi adicionado corretamente
        Cliente cliente1 = new Cliente("João", "12345678900");
        locadora.cadastrarCliente(cliente1);
        assertEquals(cliente1, locadora.buscarCliente("12345678900"), "O cliente deveria estar cadastrado na locadora.");

        // Teste 3: Alugar um filme disponível e verificar se ele está marcado como indisponível
        locadora.alugarFilme("O Senhor dos Anéis", "12345678900");
        assertEquals(false, locadora.buscarFilme("O Senhor dos Anéis").isDisponivel(), "O filme deveria estar indisponível após o aluguel.");

        // Teste 4: Devolver um filme e verificar se ele está marcado como disponível
        locadora.devolverFilme("O Senhor dos Anéis");
        assertEquals(true, locadora.buscarFilme("O Senhor dos Anéis").isDisponivel(), "O filme deveria estar disponível após a devolução.");

        // Teste 5: Remover um filme e verificar se ele foi removido corretamente
        locadora.removerFilme("O Senhor dos Anéis");
        assertEquals(null, locadora.buscarFilme("O Senhor dos Anéis"), "O filme deveria ter sido removido da locadora.");

        // Teste 6: Remover um cliente e verificar se ele foi removido corretamente
        locadora.removerCliente("12345678900");
        assertEquals(null, locadora.buscarCliente("12345678900"), "O cliente deveria ter sido removido da locadora.");

        // Teste 7: Tentar alugar um filme que não existe e verificar o comportamento
        locadora.alugarFilme("Filme Inexistente", "12345678900");
        assertEquals(null, locadora.buscarFilme("Filme Inexistente"), "O filme inexistente não deveria estar na locadora.");

        // Teste 8: Tentar cadastrar um cliente com o mesmo CPF e verificar se o cliente duplicado não foi adicionado
        Cliente clienteDuplicado = new Cliente("João", "12345678900");
        locadora.cadastrarCliente(cliente1); // Primeiro cadastro
        locadora.cadastrarCliente(clienteDuplicado); // Cadastro duplicado
        int clientesCadastrados = locadora.getClientes().size();
        assertEquals(1, clientesCadastrados, "Deveria haver apenas um cliente com o CPF '12345678900'.");
    }

    public static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null && actual == null) {
            System.out.println("Teste passou: " + message);
        } else if (expected != null && expected.equals(actual)) {
            System.out.println("Teste passou: " + message);
        } else {
            System.out.println("Teste falhou: " + message + " - Esperado: " + expected + ", Obtido: " + actual);
        }
    }

    // Método auxiliar para realizar asserções em igualdade com valores booleanos
    public static void assertEquals(boolean expected, boolean actual, String message) {
        if (expected != actual) {
            throw new AssertionError("Teste falhou: " + message + "\nEsperado: " + expected + "\nAtual: " + actual);
        }
    }

    // Método auxiliar para realizar asserções em igualdade com inteiros
    public static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError("Teste falhou: " + message + "\nEsperado: " + expected + "\nAtual: " + actual);
        }
    }
}

