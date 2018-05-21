package lojaInformatica.negocio;

import lojaInformatica.basica.Funcionario;
import lojaInformatica.acesso.DAOFuncionario;
import lojaInformatica.acesso.DAOFuncionarioImpl;
import lojaInformatica.acesso.DAOException;
import lojaInformatica.util.ConexaoException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author renatoandrade
 */
public class NegFuncionario {

    private final DAOFuncionario DAO = new DAOFuncionarioImpl();

    /**
     * Verifica se os campos foram preenchidos corretamente
     *
     * @param f Objeto com os dados
     * @throws GeralException
     */
    public void validarFuncionario(Funcionario f) throws GeralException {
        if (f == null) {
            throw new GeralException("ERRO: Funcionário inválido");
        }
        if (f.getCpf() == null || f.getCpf().isEmpty() || f.getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF inválido");
        }
        if (f.getNome() == null || f.getNome().isEmpty() || f.getNome().trim().length() < 2) {
            throw new GeralException("ERRO: Nome inválido");
        }
        if (f.getTel() == null || f.getTel().isEmpty() || f.getTel().length() < 11) {
            throw new GeralException("ERRO: Telefone inválido");
        }
        if (f.getEnd() == null || f.getEnd().isEmpty()) {
            throw new GeralException("ERRO: Endereço inválido");
        }
        if (f.getCargo() == null || f.getCargo().isEmpty()) {
            throw new GeralException("ERRO: Cargo inválido");
        }
    }

    /**
     * Verifica o preenchimento dos campos
     *
     * @param f Objeto com os dados.
     * @throws GeralException
     */
    public void validarAlteracao(Funcionario f) throws GeralException {
        //validar
        if (f == null) {
            throw new GeralException("ERRO: Funcionário inválido");
        }
        if (f.getNome() == null || f.getNome().isEmpty() || f.getNome().trim().length() < 2) {
            throw new GeralException("ERRO: Nome inválido");
        }
        if (f.getTel() == null || f.getTel().isEmpty() || f.getTel().length() < 11) {
            throw new GeralException("ERRO: Telefone inválido");
        }
        if (f.getEnd() == null || f.getEnd().isEmpty()) {
            throw new GeralException("ERRO: Endereço inválido");
        }
        if (f.getCargo() == null || f.getCargo().isEmpty() || f.getCargo().length() < 5) {
            throw new GeralException("ERRO: Cargo inválido");
        }
        //localizar
        if (pesquisar(f.getCpf()) == null) {
            throw new GeralException("ERRO: CPF não encontrado!");
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
            throw new GeralException("ERRO: Funcionário já cadastrado!");
        }
    }

    /**
     * Verifica se o Funcionário e CPF já existem no Banco de Dados
     *
     * @param f Chave da busca
     * @throws GeralException
     */
    public void validarExclusao(Funcionario f) throws GeralException {
        //validar
        if (f == null) {
            throw new GeralException("ERRO: Funcionário inválido!");
        }
        if (f.getCpf() == null || f.getCpf().isEmpty() || f.getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF inválido!");
        }
        //localizar
        if (pesquisar(f.getCpf()) == null) {
            throw new GeralException("ERRO: CPF não encontrado!");
        }
    }

    /**
     * Salva os dados do funcionario no Banco de Dados Assume-se que os dados
     * estao validados e verificados
     *
     * @param f Objeto com os dados do novo funcionario
     * @throws GeralException
     */
    public void inserir(Funcionario f) throws GeralException {
        try {
            DAO.inserir(f);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Exclui um Funcionario com base no seu CPF
     *
     * @param f Objeto com os dados do Aluno
     * @throws GeralException
     */
    public void excluir(Funcionario f) throws GeralException {
        try {
            DAO.excluir(f.getCpf());
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
    public Funcionario pesquisar(String cpf) throws GeralException {
        try {
            return DAO.pesquisar(cpf);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna uma lista de todos os funcionarios do banco de dados
     *
     * @return Lista de funcionarios
     * @throws GeralException
     */
    public ArrayList<Funcionario> listar() throws GeralException {
        try {
            return DAO.listar();
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Valida se o funcionario existe no banco de dados com base no CPF
     *
     * @param f com o CPF do Funcionario
     * @throws GeralException
     */
    public void validarCPF(Funcionario f) throws GeralException {
        //validar CPF
        if (f == null) {
            throw new GeralException("ERRO: Funcionário inválido");
        }
        if (f.getCpf() == null || f.getCpf().isEmpty() || f.getCpf().length() < 11) {
            throw new GeralException("ERRO: CPF inválido");
        }

        //localizar pelo CPF
        if (pesquisar(f.getCpf()) == null) {
            throw new GeralException("ERRO: CPF não encontrado!");
        }
    }

    /**
     * Altera os dados de um Funcionario no Banco de Dados
     *
     * @param f Objeto com os dados do Funcionario
     * @throws GeralException
     */
    public void alterar(Funcionario f) throws GeralException {
        try {
            DAO.alterar(f);
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
