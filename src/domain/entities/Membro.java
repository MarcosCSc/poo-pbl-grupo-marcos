package domain.entities;

import java.util.Objects;
import java.util.UUID;

public class Membro {

    private final String id;
    private final String nome;

    public Membro(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do membro nao pode ser vazio");
        }
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return Objects.equals(id, membro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Membro{nome='" + nome + "'}";
    }
}