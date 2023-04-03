package br.com.ada.Industria.eolica.mapper;

import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.dto.ParqueEolicoListDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParqueEolicoMapper {

    ParqueEolicoListDTO parqueEolicoToParqueEolicoListDTO(ParqueEolico parqueEolico);
}