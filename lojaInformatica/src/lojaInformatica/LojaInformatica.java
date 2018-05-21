package lojaInformatica;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import lojaInformatica.util.ConexaoException;
import lojaInformatica.util.GerenciadorConexao;
import lojaInformatica.util.GerenciadorConexaoSQLServer;
import lojaInformatica.acesso.DAOCliente;
import lojaInformatica.acesso.DAOClienteImpl;
import lojaInformatica.acesso.DAOMaterial;
import lojaInformatica.acesso.DAOMaterialImpl;
import lojaInformatica.acesso.DAOFuncionario;
import lojaInformatica.acesso.DAOFuncionarioImpl;
import lojaInformatica.basica.Funcionario;
import lojaInformatica.basica.Cliente;
import lojaInformatica.basica.Material;

import lojaInformatica.acesso.DAOException;
import lojaInformatica.acesso.DAOPedido;
import lojaInformatica.acesso.DAOPedidoImpl;
import lojaInformatica.basica.Pedido;
import lojaInformatica.fachada.Fachada;
import lojaInformatica.negocio.GeralException;
import lojaInformatica.negocio.NegCliente;
import lojaInformatica.negocio.NegFuncionario;
import lojaInformatica.negocio.NegMaterial;

/**
 *
 * @author renatoandrade
 */
public class LojaInformatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testaConexao();
        testaDAO();
        //testaDAOExcluir();
        //testaPesquisarDAOCliente();
        //testaDAOPedido();
        //testaNegocio();
        //testaListarDAOCliente();
        //testaFachada();
    }

    private static void testaConexao() {
        GerenciadorConexao g = GerenciadorConexaoSQLServer.getInstancia();
        try {
            g.conectar();
            System.out.println("Conexao OK!");
        } catch (ConexaoException e) {
            System.out.println("ERRO de Conexao: " + e.getMessage());
        }
    }

    private static void testaDAO() {
        DAOCliente dao = new DAOClienteImpl();
        Cliente aux = new Cliente();
        aux.setCpf("00012345675");
        aux.setNome("teste");
        aux.setEnd("Rua 1232, 423");
        aux.setTel("1234-1234");
        aux.setEmail("cliente@cliente.com");
        try {
            dao.inserir(aux);
            System.out.println("Dados SALVOS com Sucesso");
        } catch (ConexaoException e) {
            System.out.println("Erro na Conexao: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println("Erro no DAO: " + e.getMessage());
        }
    }

    private static void testaDAOExcluir() {
        DAOCliente dao = new DAOClienteImpl();
        Cliente aux = new Cliente();
        aux.setCpf("77777777777");
        try {
            dao.excluir(aux);
            System.out.println("Dados EXCLUÃ�DOS com Sucesso");
        } catch (ConexaoException e) {
            System.out.println("Erro na Conexao: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println("Erro no DAO: " + e.getMessage());
        }
    }

    private static void testaNegocio() {
        NegMaterial neg = new NegMaterial();
        try {
            Material m = new Material("Processador", 200.00);
            neg.validarMaterial(m);
            neg.verificaDuplicidade(m.getDescricao());
            neg.inserir(m);
            System.out.println("Dados SALVOS com Sucesso");
        } catch (GeralException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void testaFachada() {
        Fachada f = Fachada.getInstancia();
        Cliente aux = new Cliente();
        aux.setCpf("22222222221");
        aux.setNome("teste6");
        aux.setEnd("Rua 1232, 423");
        aux.setTel("081991971791");
        aux.setEmail("teste@teste.com");
        try {
            f.salvarCliente(aux);
            System.out.println("Dados SALVOS com Sucesso");
        } catch (GeralException e) {
            System.out.println("Erro na Conexao: " + e.getMessage());
        }
    }

    private static void testaDAOPedido() {
        DAOPedido dao = new DAOPedidoImpl();
        Pedido aux = new Pedido();
        aux.setData("24/11/2016");
        aux.setValor(1000.12);
        aux.setPagamento("CC");
        aux.getCliente().setCpf("04670463446");
        aux.getFuncionario().setCpf("12112345685");
        try {
            dao.inserir(aux);
            System.out.println("Dados SALVOS com Sucesso");
        } catch (ConexaoException e) {
            System.out.println("Erro na Conexao: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println("Erro no DAO: " + e.getMessage());
        }
    }

    private static void testaListarDAOCliente() {
        DAOCliente dao = new DAOClienteImpl();
        try {
            ArrayList<Cliente> lista = dao.listar();
            for (Cliente a : lista) {
                System.out.println(a);
            }
        } catch (ConexaoException e) {
            System.out.println("ERRO de Conexao: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println("ERRO de DAO: " + e.getMessage());
        }
    }

    private static void testaPesquisarDAOCliente() {
        DAOCliente dao = new DAOClienteImpl();
        Cliente aux = new Cliente();
        aux.setCpf("04670463446");
        try {

            System.out.println(dao.pesquisar(aux).toString());
        } catch (ConexaoException e) {
            System.out.println("ERRO de Conexao: " + e.getMessage());
        } catch (DAOException e) {
            System.out.println("ERRO de DAO: " + e.getMessage());
        }
    }

}
