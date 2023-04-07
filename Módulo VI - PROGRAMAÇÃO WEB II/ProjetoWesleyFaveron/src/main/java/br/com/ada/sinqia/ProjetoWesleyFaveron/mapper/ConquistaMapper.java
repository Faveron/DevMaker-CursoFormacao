package br.com.ada.sinqia.ProjetoWesleyFaveron.mapper;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Conquista;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.ConquistaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConquistaMapper {
    Conquista conquistaDTOToConquista(ConquistaDTO dto);
}
