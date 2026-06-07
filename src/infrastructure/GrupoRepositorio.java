package infrastructure;

import domain.aggregates.Grupo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrupoRepositorio {

    private final Map<String, Grupo> grupos = new HashMap<>();

    public void salvar(Grupo grupo) {
        if (grupo == null) {
            throw new IllegalArgumentException("Grupo nao pode ser nulo");
        }
        grupos.put(grupo.getNome(), grupo);
    }

    public Grupo buscarPorNome(String nome) {
        return grupos.get(nome);
    }

    public List<Grupo> listarTodos() {
        return new ArrayList<>(grupos.values());
    }
}