package br.com.ada.sinqia.ProjetoWesleyFaveron.mapper;

import br.com.ada.sinqia.ProjetoWesleyFaveron.domain.Usuario;
import br.com.ada.sinqia.ProjetoWesleyFaveron.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario usuarioDTOtoUsuario(UsuarioDTO dto);
}
