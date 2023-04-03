package br.com.ada.Industria.eolica.mapper;

import br.com.ada.Industria.eolica.domain.ParqueEolico;
import br.com.ada.Industria.eolica.dto.ParqueEolicoListDTO;
import br.com.ada.Industria.eolica.dto.ParqueEolicoSaveDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParqueEolicoMapper {

    //    @Mapping(source = "cep", target = "endereco", ignore = true)
    ParqueEolico parqueEolicoSaveDTOToParqueEolico(ParqueEolicoSaveDTO dto);

    ParqueEolicoListDTO parqueEolicoToParqueEolicoListDTO(ParqueEolico parqueEolico);
}