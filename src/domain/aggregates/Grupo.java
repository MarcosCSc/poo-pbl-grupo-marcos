package domain.aggregates;

import domain.entities.Despesa;
import domain.entities.Membro;
import domain.valueobjects.Dinheiro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grupo {

    private final String nome;
    private final List<Membro> membros;
    private final List<Despesa> despesas;

    public Grupo(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do grupo nao pode ser vazio");
        }
        this.nome = nome;
        this.membros = new ArrayList<>();
        this.despesas = new ArrayList<>();
    }

    public void adicionarMembro(Membro membro) {
        if (membro == null) {
            throw new IllegalArgumentException("Membro nao pode ser nulo");
        }
        if (membros.contains(membro)) {
            throw new IllegalArgumentException("Membro ja esta no grupo");
        }
        membros.add(membro);
    }

    public void registrarDespesa(Despesa despesa) {
        if (despesa == null) {
            throw new IllegalArgumentException("Despesa nao pode ser nula");
        }
        despesas.add(despesa);
    }

    public Map<String, BigDecimal> calcularSaldos() {
        Map<String, BigDecimal> saldos = new HashMap<>();

        for (Membro membro : membros) {
            saldos.put(membro.getNome(), BigDecimal.ZERO);
        }

        for (Despesa despesa : despesas) {
            String pagador = despesa.getPagador().getNome();
            BigDecimal valorTotal = despesa.getValor().getValor();
            BigDecimal valorPorPessoa = despesa.getValorPorParticipante().getValor();

            saldos.merge(pagador, valorTotal, BigDecimal::add);

            for (Membro participante : despesa.getParticipantes()) {
                saldos.merge(participante.getNome(), valorPorPessoa.negate(), BigDecimal::add);
            }
        }

        return Collections.unmodifiableMap(saldos);
    }

    public String getNome() {
        return nome;
    }

    public List<Membro> getMembros() {
        return Collections.unmodifiableList(membros);
    }

    public List<Despesa> getDespesas() {
        return Collections.unmodifiableList(despesas);
    }
}