package lojaInformatica.negocio;

import lojaInformatica.basica.Material;
import lojaInformatica.acesso.DAOMaterial;
import lojaInformatica.acesso.DAOMaterialImpl;
import lojaInformatica.acesso.DAOException;
import lojaInformatica.util.ConexaoException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author renatoandrade
 */
public class NegMaterial {

    private final DAOMaterial DAO = new DAOMaterialImpl();

    /**
     * Verifica se os campos foram preenchidos corretamente
     *
     * @param m Objeto com os dados
     * @throws GeralException
     */
    public void validarMaterial(Material m) throws GeralException {
        if (m == null) {
            throw new GeralException("ERRO: Material inválido");
        }
        if (m.getDescricao() == null || m.getDescricao().isEmpty()) {
            throw new GeralException("ERRO: Descrição inválida");
        }
        if (m.getValor() == null || m.getValor() < 0) {
            throw new GeralException("ERRO: Valor inválido");
        }
    }

    /**
     * Verifica o preenchimento dos campos
     *
     * @param m Objeto com os dados.
     * @throws GeralException
     */
    public void validarAlteracao(Material m) throws GeralException {
        //validar
        if (m == null) {
            throw new GeralException("ERRO: Material invalido");
        }
        if (m.getDescricao() == null || m.getDescricao().isEmpty()) {
            throw new GeralException("ERRO: Descrição inválida");
        }
        if (m.getValor() == null || m.getValor() < 0) {
            throw new GeralException("ERRO: Valor inválido");
        }
        //localizar
        if (pesquisar(m.getCodigo()) == null || m.getCodigo() < 1) {
            throw new GeralException("ERRO: Código não encontrado!");
        }
    }

    /**
     * Verifica no Banco de dados se o Material já existe
     *
     * @param descricao Chave da busca
     * @throws GeralException
     */
    public void verificaDuplicidade(String descricao) throws GeralException {
        if (pesquisar(descricao) != null) {
            throw new GeralException("ERRO: Material já cadastrado!");
        }
    }

    /**
     * Verifica se o Material e Código já existem no Banco de Dados
     *
     * @param m Chave da busca
     * @throws GeralException
     */
    public void validarExclusao(Material m) throws GeralException {
        //validar
        if (m == null) {
            throw new GeralException("ERRO: Material inválido!");
        }
        if (m.getCodigo() == null || m.getCodigo() < 1) {
            throw new GeralException("ERRO: Código inválido!");
        }
        //localizar
        if (pesquisar(m.getCodigo()) == null) {
            throw new GeralException("ERRO: Código não encontrado!");
        }
    }

    /**
     * Salva os dados do cliente no Banco de Dados Assume-se que os dados estao
     * validados e verificados
     *
     * @param m Objeto com os dados do novo cliente
     * @throws GeralException
     */
    public void inserir(Material m) throws GeralException {
        try {
            DAO.inserir(m);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Exclui um Material com base no seu Código
     *
     * @param m Objeto com os dados do Aluno
     * @throws GeralException
     */
    public void excluir(Material m) throws GeralException {
        try {
            DAO.excluir(m.getCodigo());
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna um registro com base na Descrição passada
     *
     * @param descricao Chave da pesquisa
     * @return Objeto com os dados do material encontrado ou NULL
     * @throws GeralException
     */
    public Material pesquisar(String descricao) throws GeralException {
        try {
            return DAO.pesquisar(descricao);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna um registro com base no Código passado
     *
     * @param codigo Chave da pesquisa
     * @return Objeto com os dados do material encontrado ou NULL
     * @throws GeralException
     */
    public Material pesquisar(Integer codigo) throws GeralException {
        try {
            return DAO.pesquisar(codigo);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Retorna uma lista de todos os materiais do banco de dados
     *
     * @return Lista de materiais
     * @throws GeralException
     */
    public ArrayList<Material> listar() throws GeralException {
        try {
            return DAO.listar();
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Valida se o material existe no banco de dados com base no codigo
     *
     * @param m com o código do Material
     * @throws GeralException
     */
    public void validarCodigo(Material m) throws GeralException {
        //validar código
        if (m == null) {
            throw new GeralException("ERRO: Material inválido");
        }
        if (m.getCodigo() == null) {
            throw new GeralException("ERRO: Código inválido");
        }

        //localizar pelo Código
        if (pesquisar(m.getCodigo()) == null) {
            throw new GeralException("ERRO: Produto não encontrado!");
        }
    }

    /**
     * Valida se o material existe no banco de dados com base na descricao
     *
     * @param m com a descricao do Material
     * @throws GeralException
     */
    public void validarDescricao(Material m) throws GeralException {
        //validar descricao
        if (m == null) {
            throw new GeralException("ERRO: Descrição inválida");
        }
        if (m.getDescricao() == null || m.getDescricao().isEmpty()) {
            throw new GeralException("ERRO: Descrição inválida");
        }

        //localizar pela descrição
        if (pesquisar(m.getDescricao()) == null) {
            throw new GeralException("ERRO: Produto não encontrado!");
        }
    }

    /**
     * Altera os dados de um Material no Banco de Dados
     *
     * @param m Objeto com os dados do Material
     * @throws GeralException
     */
    public void alterar(Material m) throws GeralException {
        try {
            DAO.alterar(m);
        } catch (ConexaoException e) {
            throw new GeralException("ERRO: Sem conexão com o Banco de Dados");
        } catch (DAOException e) {
            throw new GeralException("Erro de acesso!");
        }
    }

    /**
     * Preenche a tabela de Materiais no tblMateriais
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
