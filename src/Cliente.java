import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String id;

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Cliente: " + nome + " | ID: " + id;
    }

}
