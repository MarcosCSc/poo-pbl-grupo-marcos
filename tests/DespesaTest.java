package domain;

import domain.entities.Despesa;
import domain.entities.Membro;
import domain.valueobjects.Dinheiro;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DespesaTest {

    @Test
    void deveCriarDespesaValida() {
        Membro marcos = new Membro("Marcos");
        Dinheiro valor = new Dinheiro(new BigDecimal("100.00"));
        Despesa despesa = new Despesa("Mercado", valor, marcos, List.of(marcos));

        assertEquals("Mercado", despesa.getDescricao());
        assertEquals(marcos, despesa.getPagador());
    }

    @Test
    void deveCalcularValorPorParticipante() {
        Membro marcos = new Membro("Marcos");
        Membro joao = new Membro("Joao");
        Dinheiro valor = new Dinheiro(new BigDecimal("100.00"));
        Despesa despesa = new Despesa("Aluguel", valor, marcos, List.of(marcos, joao));

        Dinheiro esperado = new Dinheiro(new BigDecimal("50.00"));
        assertEquals(esperado, despesa.getValorPorParticipante());
    }

    @Test
    void deveLancarExcecaoSeDescricaoVazia() {
        Membro marcos = new Membro("Marcos");
        Dinheiro valor = new Dinheiro(new BigDecimal("50.00"));

        assertThrows(IllegalArgumentException.class, () ->
                new Despesa("", valor, marcos, List.of(marcos))
        );
    }

    @Test
    void deveLancarExcecaoSeDescricaoNula() {
        Membro marcos = new Membro("Marcos");
        Dinheiro valor = new Dinheiro(new BigDecimal("50.00"));

        assertThrows(IllegalArgumentException.class, () ->
                new Despesa(null, valor, marcos, List.of(marcos))
        );
    }

    @Test
    void deveLancarExcecaoSeValorNulo() {
        Membro marcos = new Membro("Marcos");

        assertThrows(IllegalArgumentException.class, () ->
                new Despesa("Aluguel", null, marcos, List.of(marcos))
        );
    }

    @Test
    void deveLancarExcecaoSePagadorNulo() {
        Dinheiro valor = new Dinheiro(new BigDecimal("50.00"));
        Membro marcos = new Membro("Marcos");

        assertThrows(IllegalArgumentException.class, () ->
                new Despesa("Aluguel", valor, null, List.of(marcos))
        );
    }

    @Test
    void deveLancarExcecaoSeListaVazia() {
        Membro marcos = new Membro("Marcos");
        Dinheiro valor = new Dinheiro(new BigDecimal("50.00"));

        assertThrows(IllegalArgumentException.class, () ->
                new Despesa("Aluguel", valor, marcos, List.of())
        );
    }
}