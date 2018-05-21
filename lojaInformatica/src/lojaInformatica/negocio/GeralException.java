package lojaInformatica.negocio;

/**
 *
 * @author renatoandrade
 */
public class GeralException extends Exception {

    public GeralException() {
        super();
    }

    public GeralException(Exception e) {
        super(e);
    }

    public GeralException(String msg) {
        super(msg);
    }

}
