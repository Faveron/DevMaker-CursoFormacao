package br.com.ada.sinqia.ProjetoWesleyFaveron.mapper;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Jogo;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.JogoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JogoMapper {
    Jogo jogoDTOToJogo(JogoDTO dto);
}
