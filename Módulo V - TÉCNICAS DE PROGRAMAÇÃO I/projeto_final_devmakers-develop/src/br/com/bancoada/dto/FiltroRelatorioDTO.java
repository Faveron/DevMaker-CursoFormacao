package br.com.bancoada.dto;

import br.com.bancoada.domain.Conta;
import br.com.bancoada.domain.Transacao;

import java.math.BigDecimal;
import java.util.List;

public record FiltroRelatorioDTO(
        Conta conta,
        List<Transacao> transacoes,
        BigDecimal saldo,
        String de,
        String ate

) {
}
