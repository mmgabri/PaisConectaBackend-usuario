package usuario.exceptions;

public class ErroAutenticacaoException extends RuntimeException {
    public ErroAutenticacaoException(String msg){
        super(msg);
    }
}
