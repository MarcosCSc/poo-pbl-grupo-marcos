package domain;

import infrastructure.GrupoRepositorio;
import domain.aggregates.Grupo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrupoRepositorioTest {

    @Test
    void deveSalvarEBuscarGrupo() {
        GrupoRepositorio repo = new GrupoRepositorio();
        Grupo grupo = new Grupo("Republica");
        repo.salvar(grupo);

        Grupo resultado = repo.buscarPorNome("Republica");
        assertNotNull(resultado);
        assertEquals("Republica", resultado.getNome());
    }

    @Test
    void deveRetornarNuloSeNaoEncontrar() {
        GrupoRepositorio repo = new GrupoRepositorio();
        Grupo resultado = repo.buscarPorNome("NaoExiste");
        assertNull(resultado);
    }

    @Test
    void deveLancarExcecaoSeGrupoNulo() {
        GrupoRepositorio repo = new GrupoRepositorio();
        assertThrows(IllegalArgumentException.class, () ->
                repo.salvar(null)
        );
    }

    @Test
    void deveListarTodosOsGrupos() {
        GrupoRepositorio repo = new GrupoRepositorio();
        repo.salvar(new Grupo("Republica"));
        repo.salvar(new Grupo("Viagem"));
        assertEquals(2, repo.listarTodos().size());
    }
}