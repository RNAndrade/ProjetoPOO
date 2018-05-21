package lojaInformatica.negocio;

import lojaInformatica.basica.Cliente;
import lojaInformatica.acesso.DAOCliente;
import lojaInformatica.acesso.DAOClienteImpl;
import lojaInformatica.acesso.DAOException;
import lojaInformatica.util.ConexaoException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author renatoandrade
 */
public class NegCliente {

    private final DAOCliente DAO = new DAOClienteImpl();

    /**
     * Verifica se os campos foram preenchidos corretamente
     *
     * @param a Objeto com os dados
     * @throws GeralException
     */
    public void validarCliente(Cliente a) throws GeralException {
        if (a == null) {
            throw new GeralException("ERRO: Cliente invalido");
        }
        if (a.getCpf() == null || a.getCpf().isEmpty() || a.getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF inválido");
        }
        if (a.getNome() == null || a.getNome().isEmpty() || a.getNome().trim().length() < 2) {
            throw new GeralException("ERRO: Nome invalido");
        }
        if (a.getEnd() == null || a.getEnd().isEmpty()) {
            throw new GeralException("ERRO: Endereço invalido");
        }
        if (a.getTel() == null || a.getTel().isEmpty() || a.getTel().length() < 11) {
            throw new GeralException("ERRO: Telefone invalido");
        }
        if (a.getEmail() == null || a.getEmail().isEmpty()) {
            throw new GeralException("ERRO: Email invalido");
        }
    }

    /**
     * Verifica o preenchimento dos campos
     *
     * @param a Objeto com os dados.
     * @throws GeralException
     */
    public void validarAlteracao(Cliente a) throws GeralException {
        //validar
        if (a == null) {
            throw new GeralException("ERRO: Cliente invalido");
        }
        if (a.getNome() == null || a.getNome().isEmpty() || a.getNome().trim().length() < 2) {
            throw new GeralException("ERRO: Nome inválido");
        }
        if (a.getEnd() == null || a.getEnd().isEmpty()) {
            throw new GeralException("ERRO: Endereço invalido");
        }
        if (a.getTel() == null || a.getTel().isEmpty() || a.getTel().length() < 11) {
            throw new GeralException("ERRO: Telefone invalido");
        }
        if (a.getEmail() == null || a.getEmail().isEmpty()) {
            throw new GeralException("ERRO: Email invalido");
        }
        //pesquisar
        if (pesquisar(a.getCpf()) == null) {
            throw new GeralException("ERRO: Cliente não encontrado!");
        }
    }

    /**
     * Verifica no BD se o CPF ja existe
     *
     * @param cpf Chave da busca
     * @throws GeralException
     */
    public void verificaDuplicidade(String cpf) throws GeralException {
        if (pesquisar(cpf) != null) {
            throw new GeralException("ERRO: Cliente ja cadastrado!");
        }
    }

    /**
     * Verifica se o Cliente e CPF já existe no Banco de Dados
     *
     * @param a Chave da busca
     * @throws GeralException
     */
    public void validarExclusao(Cliente a) throws GeralException {
        //validar
        if (a == null) {
            throw new GeralException("ERRO: Cliente inválido!");
        }
        if (a.getCpf() == null || a.getCpf().isEmpty() || a.getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF inválido!");
        }
        //localizar
        if (pesquisar(a.getCpf()) == null) {
            throw new GeralException("ERRO: CPF não encontrado!");
        }
    }

    /**
     * Salva os dados do cliente no Banco de Dados Assume-se que os dados estao
     * validados e verificados
     *
     * @param a Objeto com os dados do novo cliente
     * @throws GeralException
     */
    public void inserir(Cliente a) throws GeralException {
        try {
            DAO.inserir(a);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Exclui um Cliente com base no seu CPF
     *
     * @param a Objeto com os dados do Aluno
     * @throws GeralException
     */
    public void excluir(Cliente a) throws GeralException {
        try {
            DAO.excluir(a.getCpf());
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna um registro com base no CPF passado
     *
     * @param cpf Chave da pesquisa
     * @return Objeto com os dados do cliente encontrado ou NULL
     * @throws GeralException
     */
    public Cliente pesquisar(String cpf) throws GeralException {
        try {
            return DAO.pesquisar(cpf);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna uma lista de todos os cliente do banco de dados
     *
     * @return Lista de clientes
     * @throws GeralException
     */
    public ArrayList<Cliente> listar() throws GeralException {
        try {
            return DAO.listar();
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Valida se o cliente existe no banco de dados com base no CPF
     *
     * @param a com o CPF do Cliente
     * @throws GeralException
     */
    public void validarCPF(Cliente a) throws GeralException {
        //validar CPF
        if (a == null) {
            throw new GeralException("ERRO: Cliente inválido");
        }
        if (a.getCpf() == null || a.getCpf().isEmpty() || a.getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF inválido");
        }

        //localizar pelo CPF
        if (pesquisar(a.getCpf()) == null) {
            throw new GeralException("ERRO: CPF não encontrado!");
        }
    }

    /**
     * Altera os dados de um Cliente no Banco de Dados
     *
     * @param a Objeto com os dados do Cliente
     * @throws GeralException
     */
    public void alterar(Cliente a) throws GeralException {
        try {
            DAO.alterar(a);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Preenche a tabela de Clientes no tblClientes
     *
     * @return Tabela Preenchida
     * @throws GeralException
     */
    public TableModel tabela() throws GeralException {
        try {
            return DAO.preencherTabela();
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }
}
