package lojaInformatica.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lojaInformatica.basica.PedidoMaterial;
import lojaInformatica.util.ConexaoException;
import lojaInformatica.util.GerenciadorConexao;
import lojaInformatica.util.GerenciadorConexaoSQLServer;

/**
 *
 * @author renatoandrade
 */
public class DAOPedidoMaterialImpl implements DAOPedidoMaterial {

    private final GerenciadorConexao g;
    private Connection c;

    public DAOPedidoMaterialImpl() {
        g = GerenciadorConexaoSQLServer.getInstancia();
    }

    @Override
    public void inserir(PedidoMaterial p) throws DAOException, ConexaoException {
        c = g.conectar();
        String sql = "INSERT INTO PEDIDO (matValor, matQtd, pedCod, matCod) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setDouble(1, p.getValor());
            pst.setInt(2, p.getQuantidade());
            pst.setInt(3, p.getPedido().getCodigo());
            pst.setInt(4, p.getMaterial().getCodigo());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(PedidoMaterial p) throws DAOException, ConexaoException {
        c = g.conectar();
        String sql = "UPDATE PEDIDOMATERIAL SET matValor=?,matQtd=?, matCod=? WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setDouble(1, p.getValor());
            pst.setInt(2, p.getQuantidade());
            pst.setInt(3, p.getMaterial().getCodigo());
            pst.setInt(4, p.getPedido().getCodigo());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(PedidoMaterial p) throws DAOException, ConexaoException {
        c = g.conectar();

        String sql = "DELETE FROM PEDIDOMATERIAL WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, p.getPedido().getCodigo());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<PedidoMaterial> listar() throws DAOException, ConexaoException {
        ArrayList<PedidoMaterial> lista = new ArrayList();
        PedidoMaterial p;
        c = g.conectar();
        String sql = "SELECT matValor, matQtd, pedCod, matCod FROM PEDIDOMATERIAL";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                p = new PedidoMaterial();
                p.setValor(rs.getDouble("matValor"));
                p.setQuantidade(rs.getInt("matQtd"));
                p.getPedido().setCodigo(rs.getInt("pedCod"));
                p.getMaterial().setCodigo(rs.getInt("matCod"));
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
    public PedidoMaterial pesquisar(PedidoMaterial p) throws DAOException, ConexaoException {
        PedidoMaterial x = null;
        c = g.conectar();
        String sql = "SELECT p.matValor, p.matQtd, p.pedCod, p.matCod FROM PEDIDOMATERIAL a WHERE pedCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, p.getPedido().getCodigo());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new PedidoMaterial();
                x.setValor(rs.getDouble("matValor"));
                x.setQuantidade(rs.getInt("matQtd"));
                x.getPedido().setCodigo(rs.getInt("pedCod"));
                x.getMaterial().setCodigo(rs.getInt("matCod"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

}
