package lojaInformatica.acesso;

import java.util.ArrayList;
import lojaInformatica.basica.Material;
import lojaInformatica.basica.Pedido;
import lojaInformatica.basica.PedidoMaterial;
import lojaInformatica.util.ConexaoException;

/**
 *
 * @author renatoandrade
 */
public interface DAOPedido {
    //inserir, excluir, alterar, listar, pesquisar(id)

    /**
     * Salva os dados no BD
     *
     * @param p Objeto validado com os dados
     * @return o código do último pedido inserido no BD
     * @throws DAOException
     * @throws ConexaoException
     */
    public int inserir(Pedido p) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um pedido do BD
     *
     * @param p Objeto contendo o Código do pedido
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(Pedido p) throws DAOException, ConexaoException;

    /**
     * Remove um registro de um pedido do BD
     *
     * @param codigo contendo o codigo do pedido
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluir(Integer codigo) throws DAOException, ConexaoException;

    /**
     * Modifica um registro do BD
     *
     * @param p Objeto validado contendo os dados, inclusive o Numero do Pedido
     * @throws DAOException
     * @throws ConexaoException
     */
    public void alterar(Pedido p) throws DAOException, ConexaoException;

    /**
     * Retorna uma lista de TODOS os pedidos do BD
     *
     * @return Lista de pedidos
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<Pedido> listar() throws DAOException, ConexaoException;

    /**
     * Retorna um cliente com base no codigo passado
     *
     * @param p Objeto contendo o codigo do pedido para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Pedido pesquisar(Pedido p) throws DAOException, ConexaoException;

    /**
     * Retorna um cliente com base no codigo passado
     *
     * @param codigo Objeto contendo o codigo do pedido para pesquisa
     * @return Cliente encontrado ou NULL
     * @throws DAOException
     * @throws ConexaoException
     */
    public Pedido pesquisar(Integer codigo) throws DAOException, ConexaoException;

    /**
     * insere na tabela de relação pedidomaterial o valor do material, a
     * quantidade do material, o codigo do pedido e o codigo do material.
     *
     * @param valor
     * @param quantidade
     * @param p
     * @param m
     * @throws DAOException
     * @throws ConexaoException
     */
    public void inserirPedidoMaterial(Double valor, Integer quantidade, Pedido p, Material m) throws DAOException, ConexaoException;

    /**
     * exclui na tabela de relação pedidomaterial o pedido.
     *
     * @param p
     * @throws DAOException
     * @throws ConexaoException
     */
    public void excluirPedidoMaterial(Pedido p) throws DAOException, ConexaoException;

    /**
     * lista da tabela de relação pedidomaterial todos os materiais, valores e
     * quantidades
     *
     * @param p
     * @return
     * @throws DAOException
     * @throws ConexaoException
     */
    public ArrayList<PedidoMaterial> listarPedidoMaterial(Pedido p) throws DAOException, ConexaoException;
}
