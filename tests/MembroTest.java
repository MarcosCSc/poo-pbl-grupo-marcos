package domain;

import domain.entities.Membro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MembroTest {

    @Test
    void deveCriarMembroValido() {
        Membro membro = new Membro("Marcos");
        assertEquals("Marcos", membro.getNome());
    }

    @Test
    void deveLancarExcecaoParaNomeVazio() {
        assertThrows(IllegalArgumentException.class, () ->
                new Membro("")
        );
    }

    @Test
    void deveLancarExcecaoParaNomeNulo() {
        assertThrows(IllegalArgumentException.class, () ->
                new Membro(null)
        );
    }

    @Test
    void deveTerIdUnico() {
        Membro m1 = new Membro("Marcos");
        Membro m2 = new Membro("Marcos");
        assertNotEquals(m1.getId(), m2.getId());
    }
}