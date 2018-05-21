package lojaInformatica.acesso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lojaInformatica.basica.Material;
import lojaInformatica.basica.Pedido;
import lojaInformatica.basica.PedidoMaterial;
import lojaInformatica.util.ConexaoException;
import lojaInformatica.util.GerenciadorConexao;
import lojaInformatica.util.GerenciadorConexaoSQLServer;

/**
 *
 * @author renatoandrade
 */
public class DAOPedidoImpl implements DAOPedido {

    private final GerenciadorConexao g = GerenciadorConexaoSQLServer.getInstancia();

    @Override
    public int inserir(Pedido p) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        Integer ultimoID = 0;
        String sql = "INSERT INTO PEDIDO (pedData,pedValor,pedPgto,clieCpf,funcCpf) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, p.getData());
            pst.setDouble(2, p.getValor());
            pst.setString(3, p.getPagamento());
            pst.setString(4, p.getCliente().getCpf());
            pst.setString(5, p.getFuncionario().getCpf());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                ultimoID = rs.getInt(1);
            }
            pst.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
        return ultimoID;
    }

    @Override
    public void alterar(Pedido p) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "UPDATE PEDIDO SET pedValor=?,pedPgto=? WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setDouble(1, p.getValor());
            pst.setString(2, p.getPagamento());
            pst.setInt(3, p.getCodigo());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Pedido p) throws DAOException, ConexaoException {
        Connection c = g.conectar();

        String sql = "DELETE FROM PEDIDO WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, p.getCodigo());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Integer codigo) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "DELETE FROM PEDIDO WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Pedido> listar() throws DAOException, ConexaoException {
        ArrayList<Pedido> lista = new ArrayList();
        Pedido p;
        Connection c = g.conectar();
        String sql = "SELECT pedCod,pedData,pedValor,pedPgto,clieCpf,funcCpf FROM PEDIDO";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                p = new Pedido();
                p.setCodigo(rs.getInt("pedCod"));
                p.setData(rs.getString("pedData"));
                p.setValor(rs.getDouble("pedValor"));
                p.setPagamento(rs.getString("pedPgto"));
                p.getCliente().setCpf(rs.getString("clieCpf"));
                p.getFuncionario().setCpf(rs.getString("funcCpf"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Pedido pesquisar(Pedido p) throws DAOException, ConexaoException {
        Pedido x = null;
        Connection c = g.conectar();
        String sql = "SELECT p.pedCod,p.pedData,p.pedValor,p.pedPgto,p.clieCpf,p.funcCpf FROM PEDIDO a WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, p.getCodigo());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Pedido();
                x.setCodigo(rs.getInt("pedCod"));
                x.setData(rs.getString("pedData"));
                x.setValor(rs.getDouble("pedValor"));
                x.setPagamento(rs.getString("pedPgto"));
                x.getCliente().setCpf(rs.getString("clieCpf"));
                x.getFuncionario().setCpf(rs.getString("funcCpf"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Pedido pesquisar(Integer codigo) throws DAOException, ConexaoException {
        Pedido x = null;
        Connection c = g.conectar();
        String sql = "SELECT p.pedCod,p.pedData,p.pedValor,p.pedPgto,p.clieCpf,p.funcCpf FROM PEDIDO a WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Pedido();
                x.setCodigo(rs.getInt("pedCod"));
                x.setData(rs.getString("pedData"));
                x.setValor(rs.getDouble("pedValor"));
                x.setPagamento(rs.getString("pedPgto"));
                x.getCliente().setCpf(rs.getString("clieCpf"));
                x.getFuncionario().setCpf(rs.getString("funcCpf"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void inserirPedidoMaterial(Double valor, Integer quantidade, Pedido p, Material m) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "INSERT INTO PEDIDOMATERIAL(matValor, matQtd, pedCod, matCod) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setInt(2, quantidade);
            pst.setInt(3, p.getCodigo());
            pst.setInt(4, p.getCodigo());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException x) {
            throw new DAOException(x);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluirPedidoMaterial(Pedido p) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "DELETE FROM PEDIDOMATERIAL WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, p.getCodigo());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException x) {
            throw new DAOException(x);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<PedidoMaterial> listarPedidoMaterial(Pedido p) throws DAOException, ConexaoException {
        ArrayList<PedidoMaterial> lista = new ArrayList();
        PedidoMaterial x;
        Connection c = g.conectar();
        String sql = "SELECT p.matCod, m.matDesc, p.matQtd, p.matValor FROM PEDIDOMATERIAL AS P INNER JOIN MATERIAL AS M ON P.matCod = M.matCod WHERE P.pedCod = ?";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                x = new PedidoMaterial();
                x.getPedido().setCodigo(rs.getInt("P.pedCod"));
                lista.add(x);
            }
        } catch (SQLException y) {
            throw new DAOException(y);
        } finally {
            g.desconectar(c);
        }
        return lista;
    }
}
