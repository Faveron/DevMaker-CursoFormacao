package br.com.bancoada.repository;

import br.com.bancoada.dto.FiltroRelatorioDTO;

public interface RelatorioRepository<T> extends Repository<T> {

    void gerarRelatorio(FiltroRelatorioDTO filtro);

}
