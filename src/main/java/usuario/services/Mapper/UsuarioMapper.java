package usuario.services.Mapper;

import usuario.database.entity.UsuarioDatabase;

public interface UsuarioMapper <T1, T2> {
    UsuarioDatabase dtoToDatabase(T2 obj);
    T2 databaseToDto(T1 obj);
}
