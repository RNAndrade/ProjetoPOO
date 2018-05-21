package lojaInformatica.acesso;

/**
 *
 * @author renatoandrade
 */
public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String e) {
        super(e);
    }
}
