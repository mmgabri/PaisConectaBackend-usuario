package usuario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String id;
    private String nome;
    private String email;
}
