package br.com.bancoada.domain;

import java.math.BigDecimal;
import java.time.Instant;

public record Transacao(
        String id,
        Tipo tipo,
        BigDecimal valor,
        Instant dataCriacao
) {

    public enum Tipo {
        DEPOSITO, SAQUE
    }
}
