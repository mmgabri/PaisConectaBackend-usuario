package usuario.services;

public interface UsuarioService <T1, T2>{
    void post(T2 obj);
    void delete (String id);
    void put(T2 obj);
    T1 get (String id);
}
