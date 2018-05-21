package lojaInformatica.acesso;

import java.util.ArrayList;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Cliente;
import lojaInformatica.util.ConexaoException;

/**
 *
 * @author renatoandrade
 */
public interface DAOCliente {
    //inserir, excluir, alterar, listar, pesquisar(cpf)

    /**
     * Salva os dados no BD
     *
     * @param a Objeto validado com os dados
     * @throws DAOException
     * @throws ConexaoException
     */
    public void inserir(Cliente a) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um cliente do BD
     *
     * @param a Objeto contendo o CPF do Cliente
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(Cliente a) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um cliente do BD
     *
     * @param cpf Objeto contendo o CPF do Cliente
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(String cpf) throws DAOException, ConexaoException;

    /**
     * Modifica um registro do BD
     *
     * @param a Objeto validado contendo os dados, inclusive o CPF
     * @throws DAOException
     * @throws ConexaoException
     */
    public void alterar(Cliente a) throws DAOException, ConexaoException;

    /**
     * Retorna uma lista de TODOS os clientes do BD
     *
     * @return Lista de clientes
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Cliente> listar() throws DAOException, ConexaoException;

    /**
     * Retorna um cliente com base no CPF passado
     *
     * @param a Objeto contendo o CPF do cliente para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Cliente pesquisar(Cliente a) throws DAOException, ConexaoException;

    /**
     * Retorna um cliente com base no CPF passado
     *
     * @param cpf Objeto contendo o CPF do cliente para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Cliente pesquisar(String cpf) throws DAOException, ConexaoException;

    /**
     * Retorna uma tabela de clientes
     *
     * @return TableModel
     * @throws DAOException
     * @throws ConexaoException
     */
    public TableModel preencherTabela() throws DAOException, ConexaoException;

}
