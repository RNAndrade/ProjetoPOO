package lojaInformatica.util;

import java.sql.Connection;

/**
 *
 * @author renatoandrade
 */
public interface GerenciadorConexao {

    /**
     * Retorna um objeto de conexao com o BD
     *
     * @return Objeto de conexao
     * @throws ConexaoException
     */
    public Connection conectar() throws ConexaoException;

    /**
     * Fecha uma conexao com o BD
     *
     * @param c Objeto com a conexao a ser fechada
     * @throws ConexaoException
     */
    public void desconectar(Connection c) throws ConexaoException;
}
