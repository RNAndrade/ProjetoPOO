package lojaInformatica.util;

/**
 *
 * @author renatoandrade
 */
public class ConexaoException extends Exception {

    public ConexaoException() {
        super();
    }

    public ConexaoException(Exception e) {
        super(e);
    }

    public ConexaoException(String e) {
        super(e);
    }
}
