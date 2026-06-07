package domain;

import domain.valueobjects.Dinheiro;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class DinheiroTest {

    @Test
    void deveCriarDinheiroValido() {
        Dinheiro dinheiro = new Dinheiro(new BigDecimal("90.00"));
        assertEquals(new BigDecimal("90.00"), dinheiro.getValor());
    }

    @Test
    void deveLancarExcecaoParaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Dinheiro(new BigDecimal("-1.00"))
        );
    }

    @Test
    void deveLancarExcecaoParaValorNulo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Dinheiro(null)
        );
    }

    @Test
    void deveSomarCorretamente() {
        Dinheiro a = new Dinheiro(new BigDecimal("30.00"));
        Dinheiro b = new Dinheiro(new BigDecimal("20.00"));
        assertEquals(new BigDecimal("50.00"), a.somar(b).getValor());
    }

    @Test
    void deveDividirCorretamente() {
        Dinheiro dinheiro = new Dinheiro(new BigDecimal("90.00"));
        assertEquals(new BigDecimal("30.00"), dinheiro.dividir(3).getValor());
    }

    @Test
    void deveLancarExcecaoAoDividirPorZero() {
        Dinheiro dinheiro = new Dinheiro(new BigDecimal("90.00"));
        assertThrows(IllegalArgumentException.class, () ->
                dinheiro.dividir(0)
        );
    }
}