package domain;

import application.RegistrarDespesaUseCase;
import domain.aggregates.Grupo;
import domain.entities.Membro;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RegistrarDespesaUseCaseTest {

    @Test
    void deveRegistrarDespesaNoGrupo() {
        Grupo grupo = new Grupo("Republica");
        Membro marcos = new Membro("Marcos");
        grupo.adicionarMembro(marcos);

        RegistrarDespesaUseCase useCase = new RegistrarDespesaUseCase(grupo);
        useCase.executar("Internet", new BigDecimal("100.00"), marcos, List.of(marcos));

        assertEquals(1, grupo.getDespesas().size());
    }

    @Test
    void deveLancarExcecaoSeGrupoNulo() {
        assertThrows(IllegalArgumentException.class, () ->
                new RegistrarDespesaUseCase(null)
        );
    }

    @Test
    void deveLancarExcecaoSeValorNegativo() {
        Grupo grupo = new Grupo("Republica");
        Membro marcos = new Membro("Marcos");
        grupo.adicionarMembro(marcos);

        RegistrarDespesaUseCase useCase = new RegistrarDespesaUseCase(grupo);

        assertThrows(IllegalArgumentException.class, () ->
                useCase.executar("Internet", new BigDecimal("-10.00"), marcos, List.of(marcos))
        );
    }
}