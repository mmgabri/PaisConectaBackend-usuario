package usuario.services.Mapper;

import org.springframework.stereotype.Service;
import usuario.database.entity.UsuarioDatabase;
import usuario.domain.enuns.StatusUsuarioEnum;
import usuario.domain.dto.UsuarioDto;

import java.time.LocalDateTime;

@Service
public class UsuarioMapperImpl implements UsuarioMapper <UsuarioDatabase, UsuarioDto> {


    @Override
    public UsuarioDatabase dtoToDatabase(UsuarioDto dto) {

        UsuarioDatabase usuarioDatabase = UsuarioDatabase.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .nome(dto.getNome())
                .status(StatusUsuarioEnum.ATIVO)
                .dataHora(LocalDateTime.now())
                .build();

        return usuarioDatabase;
    }

    @Override
    public UsuarioDto databaseToDto(UsuarioDatabase database) {

        UsuarioDto usuarioDto = UsuarioDto.builder()
                .email(database.getEmail())
                .nome(database.getNome())
                .id(database.getId())
                .build();

        return usuarioDto;
    }
}
