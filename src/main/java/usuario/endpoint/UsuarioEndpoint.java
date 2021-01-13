package usuario.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import usuario.database.entity.UsuarioDatabase;
import usuario.domain.dto.UsuarioDto;
import usuario.services.UsuarioServiceImpl;
import usuario.exceptions.ObjectNotFoundException;
import usuario.exceptions.RegraNegocioException;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin("*")
public class UsuarioEndpoint {

    @Autowired
    private UsuarioServiceImpl service;

    @PostMapping
    public ResponseEntity post(@Validated @RequestBody UsuarioDto in) {
        try {
            service.post(in);
           // return ResponseEntity.ok("ok");
           return new ResponseEntity<>(HttpStatus.OK);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no processamento: " + e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable String id) {
        try {
            UsuarioDatabase out = service.get(id);
            return ResponseEntity.ok(out);
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no processamento: " + e.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            service.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no processamento: " + e.getMessage());

        }
    }

    @PutMapping
    public ResponseEntity put(@Validated @RequestBody UsuarioDto in) {
        try {
            service.put(in);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ObjectNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro no processamento: " + e.getMessage());
        }
    }
}
