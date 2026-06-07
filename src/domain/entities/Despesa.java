package domain.entities;

import domain.valueobjects.Dinheiro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Despesa {

    private final String id;
    private final String descricao;
    private final Dinheiro valor;
    private final Membro pagador;
    private final List<Membro> participantes;

    public Despesa(String descricao, Dinheiro valor, Membro pagador, List<Membro> participantes) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descricao nao pode ser vazia");
        }
        if (valor == null) {
            throw new IllegalArgumentException("Valor nao pode ser nulo");
        }
        if (pagador == null) {
            throw new IllegalArgumentException("Pagador nao pode ser nulo");
        }
        if (participantes == null || participantes.isEmpty()) {
            throw new IllegalArgumentException("Deve haver ao menos um participante");
        }
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.valor = valor;
        this.pagador = pagador;
        this.participantes = new ArrayList<>(participantes);
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Dinheiro getValor() {
        return valor;
    }

    public Membro getPagador() {
        return pagador;
    }

    public List<Membro> getParticipantes() {
        return Collections.unmodifiableList(participantes);
    }

    public Dinheiro getValorPorParticipante() {
        return valor.dividir(participantes.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return Objects.equals(id, despesa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Despesa{descricao='" + descricao + "', valor=" + valor + "'}";
    }
}