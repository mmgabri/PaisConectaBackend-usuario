package usuario.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import usuario.domain.enuns.StatusUsuarioEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.net.URI;
import java.time.LocalDateTime;

@Entity
@Table(name="usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDatabase {
    @Id
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private URI uriImagem;
    private StatusUsuarioEnum status;
    private LocalDateTime dataHora;

}
