package usuario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usuario.database.entity.UsuarioDatabase;
import usuario.database.repository.UsuarioRepository;
import usuario.domain.dto.UsuarioDto;
import usuario.services.Mapper.UsuarioMapper;
import usuario.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService<UsuarioDatabase, UsuarioDto> {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    UsuarioMapper map;

    @Override
    public void post(UsuarioDto dto) {
        UsuarioDatabase usuarioDatabase = map.dtoToDatabase(dto);
        repo.save(usuarioDatabase);
    }

    @Override
    public void delete(String id) {

        UsuarioDatabase usuarioDatabase = get(id);
        repo.delete(usuarioDatabase);

    }

    @Override
    public UsuarioDatabase get(String id) {

        Optional<UsuarioDatabase> usuarioDatabase = repo.findById(id);
        return usuarioDatabase.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

    @Override
    public void put(UsuarioDto dto) {
        UsuarioDatabase usuarioDatabase = map.dtoToDatabase(dto);
        repo.save(usuarioDatabase);
    }

}
