package lojaInformatica.negocio;

import lojaInformatica.basica.Pedido;
import lojaInformatica.acesso.DAOPedido;
import lojaInformatica.acesso.DAOPedidoImpl;
import lojaInformatica.acesso.DAOException;
import lojaInformatica.util.ConexaoException;
import java.util.ArrayList;
import lojaInformatica.basica.PedidoMaterial;

/**
 *
 * @author renatoandrade
 */
public class NegPedido {

    private final DAOPedido DAO = new DAOPedidoImpl();

    /**
     * Verifica se os campos foram preenchidos corretamente
     *
     * @param p Objeto com os dados
     * @throws GeralException
     */
    public void validarPedido(Pedido p) throws GeralException {
        if (p == null) {
            throw new GeralException("ERRO: Pedido inválido");
        }
        if (p.getData() == null || p.getData().isEmpty() || p.getData().length() < 10) {
            throw new GeralException("ERRO: Data inválido");
        }
        if (p.getValor() == null || p.getValor() < 0) {
            throw new GeralException("ERRO: Valor inválido");
        }
        if (p.getPagamento() == null || p.getPagamento().isEmpty() || p.getPagamento().length() > 2) {
            throw new GeralException("ERRO: Pagamento inválido");
        }
        if (p.getCliente().getCpf() == null || p.getCliente().getCpf().isEmpty() || p.getCliente().getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF do Cliente inválido");
        }
        if (p.getFuncionario().getCpf() == null || p.getFuncionario().getCpf().isEmpty() || p.getFuncionario().getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF do Funcionário inválido");
        }
        if (p.getPedidoMaterial() == null || p.getPedidoMaterial().isEmpty()) {
            throw new GeralException("ERRO: Lista de pedido material inválida");
        }
    }

    /**
     * Verifica o preenchimento dos campos
     *
     * @param p Objeto com os dados.
     * @throws GeralException
     */
    public void validarAlteracao(Pedido p) throws GeralException {
        //validar
        if (p == null) {
            throw new GeralException("ERRO: Pedido inválido");
        }
        if (p.getData() == null || p.getData().isEmpty() || p.getData().length() < 10) {
            throw new GeralException("ERRO: Data inválida");
        }
        if (p.getValor() == null || p.getValor() < 0) {
            throw new GeralException("ERRO: Valor inválido");
        }
        if (p.getPagamento() == null || p.getPagamento().isEmpty() || p.getPagamento().length() > 2) {
            throw new GeralException("ERRO: Pagamento inválido");
        }
        if (p.getCliente().getCpf() == null || p.getCliente().getCpf().isEmpty() || p.getCliente().getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF do Cliente inválido");
        }
        if (p.getFuncionario().getCpf() == null || p.getFuncionario().getCpf().isEmpty() || p.getFuncionario().getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF do Funcionário inválido");
        }
        //pesquisar
        if (pesquisar(p.getCodigo()) == null) {
            throw new GeralException("ERRO: Pedido não encontrado!");
        }
    }

    /**
     * Verifica no BD se o código do pedido já existe
     *
     * @param codigo Chave da busca
     * @throws GeralException
     */
    public void verificaDuplicidade(Integer codigo) throws GeralException {
        if (pesquisar(codigo) != null) {
            throw new GeralException("ERRO: Pedido já cadastrado!");
        }
    }

    /**
     * Verifica se o Pedido e o código já existem no Banco de Dados
     *
     * @param p Chave da busca
     * @throws GeralException
     */
    public void validarExclusao(Pedido p) throws GeralException {
        //validar
        if (p == null) {
            throw new GeralException("ERRO: Pedido inválido!");
        }
        if (p.getCodigo() == null || p.getCodigo() < 1) {
            throw new GeralException("ERRO: Código inválido!");
        }
        //localizar
        if (pesquisar(p.getCodigo()) == null) {
            throw new GeralException("ERRO: Pedido não encontrado!");
        }
    }

    /**
     * Salva os dados do pedido no Banco de Dados Assume-se que os dados estao
     * validados e verificados
     *
     * @param p Objeto com os dados do novo pedido
     * @throws GeralException
     */
    public void inserir(Pedido p) throws GeralException {
        try {
            int ultimoId = DAO.inserir(p);
            p.setCodigo(ultimoId);
            for (PedidoMaterial pm : p.getPedidoMaterial()) {
                DAO.inserirPedidoMaterial(pm.getValor(), pm.getQuantidade(), pm.getPedido(), pm.getMaterial());
            }
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Exclui um Pedido com base no seu Código
     *
     * @param p Objeto com os dados do Aluno
     * @throws GeralException
     */
    public void excluir(Pedido p) throws GeralException {
        try {
            DAO.excluir(p.getCodigo());
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna um registro com base no código passado
     *
     * @param codigo Chave da pesquisa
     * @return Objeto com os dados do cliente encontrado ou NULL
     * @throws GeralException
     */
    public Pedido pesquisar(Integer codigo) throws GeralException {
        try {
            return DAO.pesquisar(codigo);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna uma lista de todos os pedidos do banco de dados
     *
     * @return Lista de clientes
     * @throws GeralException
     */
    public ArrayList<Pedido> listar() throws GeralException {
        try {
            return DAO.listar();
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Valida se o pedido existe no banco de dados com base no código
     *
     * @param p com o código do Pedido
     * @throws GeralException
     */
    public void validarCodigo(Pedido p) throws GeralException {
        //validar CPF
        if (p == null) {
            throw new GeralException("ERRO: Pedido inválido");
        }
        if (p.getCodigo() == null || p.getCodigo() < 1) {
            throw new GeralException("ERRO: CPF inválido");
        }

        //localizar pelo CPF
        if (pesquisar(p.getCodigo()) == null) {
            throw new GeralException("ERRO: Código não encontrado!");
        }
    }

    /**
     * Altera os dados de um Pedido no Banco de Dados
     *
     * @param p Objeto com os dados do Cliente
     * @throws GeralException
     */
    public void alterar(Pedido p) throws GeralException {
        try {
            DAO.alterar(p);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }
}
