package br.com.ada.Industria.eolica.mapper;

import br.com.ada.Industria.eolica.domain.Aerogerador;
import br.com.ada.Industria.eolica.dto.AerogeradorSaveDTO;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface AerogeradorMapper {
    @Mapping(target = "parqueEolico", ignore = true)
    Aerogerador aerogeradorSaveDTOToAerogerador(AerogeradorSaveDTO dto);
}
