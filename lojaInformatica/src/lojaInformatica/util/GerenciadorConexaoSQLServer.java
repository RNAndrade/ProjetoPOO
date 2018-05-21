package lojaInformatica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author renatoandrade
 */
public class GerenciadorConexaoSQLServer implements GerenciadorConexao {

    private static GerenciadorConexaoSQLServer instancia;
    private final String end;
    private final String usu;
    private final String sen;

    private GerenciadorConexaoSQLServer() {
        ResourceBundle rb = ResourceBundle.getBundle("lojaInformatica.util.banco");
        end = rb.getString("url");
        usu = rb.getString("usuario");
        sen = rb.getString("senha");
    }

    public static GerenciadorConexaoSQLServer getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorConexaoSQLServer();
        }
        return instancia;
    }

    @Override
    public Connection conectar() throws ConexaoException {
        try {
            Connection c = DriverManager.getConnection(end, usu, sen);
            return c;
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }

}
