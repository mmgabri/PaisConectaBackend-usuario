package usuario.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usuario.database.entity.UsuarioDatabase;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioDatabase, String> {
}
