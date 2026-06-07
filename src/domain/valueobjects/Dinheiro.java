package domain.valueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {

    private final BigDecimal valor;

    public Dinheiro(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor nao pode ser nulo ou negativo");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
    }

    public Dinheiro somar(Dinheiro outro) {
        return new Dinheiro(this.valor.add(outro.valor));
    }

    public Dinheiro dividir(int partes) {
        if (partes <= 0) {
            throw new IllegalArgumentException("Numero de partes deve ser maior que zero");
        }
        return new Dinheiro(this.valor.divide(BigDecimal.valueOf(partes), 2, RoundingMode.HALF_UP));
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return Objects.equals(valor, dinheiro.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return "R$ " + valor;
    }
}