package application;

import domain.aggregates.Grupo;
import domain.entities.Despesa;
import domain.entities.Membro;
import domain.valueobjects.Dinheiro;

import java.math.BigDecimal;
import java.util.List;

public class RegistrarDespesaUseCase {

    private final Grupo grupo;

    public RegistrarDespesaUseCase(Grupo grupo) {
        if (grupo == null) {
            throw new IllegalArgumentException("Grupo nao pode ser nulo");
        }
        this.grupo = grupo;
    }

    public void executar(String descricao, BigDecimal valor, Membro pagador, List<Membro> participantes) {
        Dinheiro dinheiro = new Dinheiro(valor);
        Despesa despesa = new Despesa(descricao, dinheiro, pagador, participantes);
        grupo.registrarDespesa(despesa);
    }
}