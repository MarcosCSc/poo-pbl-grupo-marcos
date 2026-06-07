package domain;

import domain.aggregates.Grupo;
import domain.entities.Despesa;
import domain.entities.Membro;
import domain.valueobjects.Dinheiro;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    @Test
    void deveCriarGrupoValido() {
        Grupo grupo = new Grupo("República");
        assertEquals("República", grupo.getNome());
    }

    @Test
    void deveLancarExcecaoParaNomeVazio() {
        assertThrows(IllegalArgumentException.class, () ->
                new Grupo("")
        );
    }

    @Test
    void deveAdicionarMembro() {
        Grupo grupo = new Grupo("República");
        Membro membro = new Membro("Marcos");
        grupo.adicionarMembro(membro);
        assertEquals(1, grupo.getMembros().size());
    }

    @Test
    void deveLancarExcecaoAoAdicionarMembroDuplicado() {
        Grupo grupo = new Grupo("República");
        Membro membro = new Membro("Marcos");
        grupo.adicionarMembro(membro);
        assertThrows(IllegalArgumentException.class, () ->
                grupo.adicionarMembro(membro)
        );
    }

    @Test
    void deveRegistrarDespesa() {
        Grupo grupo = new Grupo("República");
        Membro marcos = new Membro("Marcos");
        Membro joao = new Membro("João");
        grupo.adicionarMembro(marcos);
        grupo.adicionarMembro(joao);

        Despesa despesa = new Despesa(
                "Aluguel",
                new Dinheiro(new BigDecimal("300.00")),
                marcos,
                List.of(marcos, joao)
        );
        grupo.registrarDespesa(despesa);
        assertEquals(1, grupo.getDespesas().size());
    }

    @Test
    void deveCalcularSaldosCorretamente() {
        Grupo grupo = new Grupo("República");
        Membro marcos = new Membro("Marcos");
        Membro joao = new Membro("João");
        grupo.adicionarMembro(marcos);
        grupo.adicionarMembro(joao);

        Despesa despesa = new Despesa(
                "Aluguel",
                new Dinheiro(new BigDecimal("100.00")),
                marcos,
                List.of(marcos, joao)
        );
        grupo.registrarDespesa(despesa);

        var saldos = grupo.calcularSaldos();
        assertEquals(new BigDecimal("50.00"), saldos.get("Marcos"));
        assertEquals(new BigDecimal("-50.00"), saldos.get("João"));
    }
}