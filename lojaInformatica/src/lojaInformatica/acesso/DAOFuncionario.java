package lojaInformatica.acesso;

import java.util.ArrayList;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Funcionario;
import lojaInformatica.util.ConexaoException;

/**
 *
 * @author renatoandrade
 */
public interface DAOFuncionario {
    //inserir, excluir, alterar, listar, pesquisar(id)

    /**
     * Salva os dados no BD
     *
     * @param f Objeto validado com os dados
     * @throws DAOException
     * @throws ConexaoException
     */
    public void inserir(Funcionario f) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um funcionario do BD
     *
     * @param f Objeto contendo o CPF do Funcionario
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(Funcionario f) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um funcionario do BD
     *
     * @param cpf Objeto contendo o CPF do Funcionario
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(String cpf) throws DAOException, ConexaoException;

    /**
     * Modifica um registro do BD
     *
     * @param f Objeto validado contendo os dados, inclusive o CPF
     * @throws DAOException
     * @throws ConexaoException
     */
    public void alterar(Funcionario f) throws DAOException, ConexaoException;

    /**
     * Retorna uma lista de TODOS os funcionarios do BD
     *
     * @return Lista de funcionarios
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Funcionario> listar() throws DAOException, ConexaoException;

    /**
     * Retorna um funcionario com base no CPF passado
     *
     * @param f Objeto contendo o CPF do funcionario para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Funcionario pesquisar(Funcionario f) throws DAOException, ConexaoException;

    /**
     * Retorna um funcionario com base no CPF passado
     *
     * @param cpf Objeto contendo o CPF do funcionario para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Funcionario pesquisar(String cpf) throws DAOException, ConexaoException;

    /**
     * Retorna uma tabela de funcionários
     *
     * @return TableModel
     * @throws DAOException
     * @throws ConexaoException
     */
    public TableModel preencherTabela() throws DAOException, ConexaoException;

}
