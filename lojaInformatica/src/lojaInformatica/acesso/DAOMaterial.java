package lojaInformatica.acesso;

import java.util.ArrayList;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Material;
import lojaInformatica.util.ConexaoException;

/**
 *
 * @author anderson
 */
public interface DAOMaterial {
    //inserir, excluir, alterar, listar, pesquisar(id)

    /**
     * Salva os dados no BD
     *
     * @param m Objeto validado com os dados
     * @throws DAOException
     * @throws ConexaoException
     */
    public void inserir(Material m) throws DAOException, ConexaoException;

    /**
     * Remove um registro de material do BD
     *
     * @param m Objeto contendo o Codigo do Material
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(Material m) throws DAOException, ConexaoException;

    /**
     * Remove um registro de material do BD
     *
     * @param codigo Objeto contendo o Codigo do Material
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(Integer codigo) throws DAOException, ConexaoException;

    /**
     * Modifica um registro do BD
     *
     * @param m Objeto validado contendo os dados, inclusive o ID
     * @throws DAOException
     * @throws ConexaoException
     */
    public void alterar(Material m) throws DAOException, ConexaoException;

    /**
     * Retorna uma lista de TODOS os materiais do BD
     *
     * @return Lista de materiais
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Material> listar() throws DAOException, ConexaoException;

    /**
     * Retorna UM material com base no codigo passado
     *
     * @param m Objeto contendo o codigo do material para pesquisa
     * @return Material encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Material pesquisar(Material m) throws DAOException, ConexaoException;

    /**
     * Retorna UM material com base na descricao passada
     *
     * @param descricao Objeto contendo a descrição do material para pesquisa
     * @return Material encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Material pesquisar(String descricao) throws DAOException, ConexaoException;

    /**
     * Retorna UM material com base na código passada
     *
     * @param codigo Objeto contendo o codigo do material para pesquisa
     * @return Material encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Material pesquisar(Integer codigo) throws DAOException, ConexaoException;

    /**
     * Retorna uma tabela de materiais
     *
     * @return TableModel
     * @throws DAOException
     * @throws ConexaoException
     */
    public TableModel preencherTabela() throws DAOException, ConexaoException;
}
