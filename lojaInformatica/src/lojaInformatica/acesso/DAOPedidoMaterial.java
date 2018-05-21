package lojaInformatica.acesso;

import java.util.ArrayList;
import lojaInformatica.basica.PedidoMaterial;
import lojaInformatica.util.ConexaoException;

/**
 *
 * @author renatoandrade
 */
public interface DAOPedidoMaterial {
    //inserir, excluir, alterar, listar, pesquisar(id)

    /**
     * Salva os dados no BD
     *
     * @param a Objeto validado com os dados
     * @throws DAOException
     * @throws ConexaoException
     */
    public void inserir(PedidoMaterial a) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um cliente do BD
     *
     * @param a Objeto contendo o CPF do Cliente
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(PedidoMaterial a) throws DAOException, ConexaoException;

    /**
     * Modifica um registro do BD
     *
     * @param a Objeto validado contendo os dados, inclusive o CPF
     * @throws DAOException
     * @throws ConexaoException
     */
    public void alterar(PedidoMaterial a) throws DAOException, ConexaoException;

    /**
     * Retorna uma lista de TODOS os clientes do BD
     *
     * @return Lista de clientes
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<PedidoMaterial> listar() throws DAOException, ConexaoException;

    /**
     * Retorna um cliente com base no CPF passado
     *
     * @param a Objeto contendo o CPF do cliente para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public PedidoMaterial pesquisar(PedidoMaterial a) throws DAOException, ConexaoException;

}
