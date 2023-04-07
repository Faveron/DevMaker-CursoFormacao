package br.com.ada.sinqia.ProjetoWesleyFaveron.mapper;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Console;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.ConsoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsoleMapper {
    Console consoleDTOToConsole(ConsoleDTO dto);
}
