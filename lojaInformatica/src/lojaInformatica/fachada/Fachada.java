package lojaInformatica.fachada;

import lojaInformatica.basica.Cliente;
import lojaInformatica.negocio.GeralException;
import lojaInformatica.negocio.NegCliente;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Funcionario;
import lojaInformatica.basica.Material;
import lojaInformatica.negocio.NegFuncionario;
import lojaInformatica.negocio.NegMaterial;

/**
 *
 * @author renatoandrade Concentra as FUNCIONALIDADES do sistema
 */
public class Fachada {

    private static Fachada instancia;
    private final NegCliente ngCliente = new NegCliente();
    private final NegFuncionario ngFuncionario = new NegFuncionario();
    private final NegMaterial ngMaterial = new NegMaterial();

    private Fachada() {
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    /**
     * Valida, verifica e salva os dados de um Cliente no Banco de Dados
     *
     * @param a Objeto com os dados
     * @throws GeralException
     */
    public void salvarCliente(Cliente a) throws GeralException {
        ngCliente.validarCliente(a);
        ngCliente.verificaDuplicidade(a.getCpf());
        ngCliente.inserir(a);
    }

    /**
     * Valida o CPF e EXCLUI os dados de um Cliente do Banco de Dados
     *
     * @param a Objeto com os dados (CPF)
     * @throws GeralException
     */
    public void excluirCliente(Cliente a) throws GeralException {
        ngCliente.validarExclusao(a);
        ngCliente.excluir(a);
    }

    /**
     * Valida, verifica e salva as alterações de um Cliente no Banco de Dados
     *
     * @param a Objeto com os dados
     * @throws GeralException
     */
    public void alterarCliente(Cliente a) throws GeralException {
        ngCliente.validarAlteracao(a);
        ngCliente.alterar(a);
    }

    /**
     * Valida o CPF e retorna os dados de um Cliente do Banco de Dados
     *
     * @param a Objeto com os dados (CPF)
     * @return Objeto com os dados encontrados
     * @throws GeralException
     */
    public Cliente pesquisarCliente(Cliente a) throws GeralException {
        ngCliente.validarCPF(a);
        return ngCliente.pesquisar(a.getCpf());
    }

    /**
     * Retorna a lista de TODOS os Cliente do Banco de Dados
     *
     * @return Lista de Clientes
     * @throws GeralException
     */
    public ArrayList<Cliente> listarClientes() throws GeralException {
        return ngCliente.listar();
    }

    /**
     * Retorna a lista de TODOS os Cliente do Banco de Dados
     *
     * @return Lista de Clientes
     * @throws GeralException
     */
    public TableModel preencherTabelaClientes() throws GeralException {
        return ngCliente.tabela();
    }

    /**
     * Valida, verifica e salva os dados de um Funcionario no Banco de Dados
     *
     * @param f Objeto com os dados
     * @throws GeralException
     */
    public void salvarFuncionario(Funcionario f) throws GeralException {
        ngFuncionario.validarFuncionario(f);
        ngFuncionario.verificaDuplicidade(f.getCpf());
        ngFuncionario.inserir(f);
    }

    /**
     * Valida o CPF e EXCLUI os dados de um Funcionario do Banco de Dados
     *
     * @param f Objeto com os dados (CPF)
     * @throws GeralException
     */
    public void excluirFuncionario(Funcionario f) throws GeralException {
        ngFuncionario.validarExclusao(f);
        ngFuncionario.excluir(f);
    }

    /**
     * Valida, verifica e salva as alterações de um Funcionario no Banco de
     * Dados
     *
     * @param f Objeto com os dados
     * @throws GeralException
     */
    public void alterarFuncionario(Funcionario f) throws GeralException {
        ngFuncionario.validarAlteracao(f);
        ngFuncionario.alterar(f);
    }

    /**
     * Valida o CPF e retorna os dados de um Funcionario do Banco de Dados
     *
     * @param f Objeto com os dados (CPF)
     * @return Objeto com os dados encontrados
     * @throws GeralException
     */
    public Funcionario pesquisarFuncionario(Funcionario f) throws GeralException {
        ngFuncionario.validarCPF(f);
        return ngFuncionario.pesquisar(f.getCpf());
    }

    /**
     * Retorna a lista de TODOS os Funcionario do Banco de Dados
     *
     * @return Lista de Funconarios
     * @throws GeralException
     */
    public ArrayList<Funcionario> listarFuncionarios() throws GeralException {
        return ngFuncionario.listar();
    }

    /**
     * Retorna a lista de TODOS os Funcionários do Banco de Dados
     *
     * @return Lista de Funcionários
     * @throws GeralException
     */
    public TableModel preencherTabelaFuncionarios() throws GeralException {
        return ngFuncionario.tabela();
    }

    /**
     * Valida, verifica e salva os dados de um Material no Banco de Dados
     *
     * @param m Objeto com os dados
     * @throws GeralException
     */
    public void salvarMaterial(Material m) throws GeralException {
        ngMaterial.validarMaterial(m);
        ngMaterial.verificaDuplicidade(m.getDescricao());
        ngMaterial.inserir(m);
    }

    /**
     * Valida o código e EXCLUI os dados de um Material do Banco de Dados
     *
     * @param m Objeto com os dados (código)
     * @throws GeralException
     */
    public void excluirMaterial(Material m) throws GeralException {
        ngMaterial.validarExclusao(m);
        ngMaterial.excluir(m);
    }

    /**
     * Valida, verifica e salva as alterações de um Material no Banco de Dados
     *
     * @param m Objeto com os dados
     * @throws GeralException
     */
    public void alterarMaterial(Material m) throws GeralException {
        ngMaterial.validarAlteracao(m);
        ngMaterial.alterar(m);
    }

    /**
     * Valida o código e retorna os dados de um material do Banco de Dados
     *
     * @param m Objeto com os dados (código)
     * @return Objeto com os dados encontrados
     * @throws GeralException
     */
    public Material pesquisarMaterial(Material m) throws GeralException {
        ngMaterial.validarDescricao(m);
        return ngMaterial.pesquisar(m.getDescricao());
    }

    /**
     * Retorna a lista de TODOS os Materias do Banco de Dados
     *
     * @return Lista de Materiais
     * @throws GeralException
     */
    public ArrayList<Material> listarMaterial() throws GeralException {
        return ngMaterial.listar();
    }

    /**
     * Retorna a lista de TODOS os Materiais do Banco de Dados
     *
     * @return Lista de Materiais
     * @throws GeralException
     */
    public TableModel preencherTabelaMateriais() throws GeralException {
        return ngMaterial.tabela();
    }
}
