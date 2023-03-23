package br.com.bancoada.domain;

import java.time.Instant;

public record Conta(
        String id,
        String titular,
        String cpf,
        Instant dataCriacao
) {
}
