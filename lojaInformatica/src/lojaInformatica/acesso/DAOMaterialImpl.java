package lojaInformatica.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Material;
import lojaInformatica.util.ConexaoException;
import lojaInformatica.util.GerenciadorConexao;
import lojaInformatica.util.GerenciadorConexaoSQLServer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author renatoandrade
 */
public class DAOMaterialImpl implements DAOMaterial {

    private final GerenciadorConexao g = GerenciadorConexaoSQLServer.getInstancia();

    @Override
    public void inserir(Material m) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "INSERT INTO MATERIAL (matDesc, matValor) VALUES (?,?)";
        try {
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setString(1, m.getDescricao());
                pst.setDouble(2, m.getValor());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Material m) throws DAOException, ConexaoException {
        Connection c = g.conectar();

        String sql = "DELETE FROM MATERIAL WHERE matCod=?";
        try {
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setInt(1, m.getCodigo());
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Integer codigo) throws DAOException, ConexaoException {
        Connection c = g.conectar();

        String sql = "DELETE FROM MATERIAL WHERE matCod=?";
        try {
            try (PreparedStatement pst = c.prepareStatement(sql)) {
                pst.setInt(1, codigo);
                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Material m) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "UPDATE MATERIAL SET matDesc=?, matValor=? WHERE matCod=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, m.getDescricao());
            pst.setDouble(2, m.getValor());
            pst.setInt(3, m.getCodigo());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Material> listar() throws DAOException, ConexaoException {
        ArrayList<Material> lista = new ArrayList();
        Material x;
        Connection c = g.conectar();
        String sql = "SELECT matCod, matDesc, matValor FROM MATERIAL";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                x = new Material();
                x.setCodigo(rs.getInt("matCod"));
                x.setDescricao(rs.getString("matDesc"));
                x.setValor(rs.getDouble("matValor"));
                lista.add(x);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Material pesquisar(Material m) throws DAOException, ConexaoException {
        Material x = null;
        Connection c = g.conectar();
        String sql = "SELECT m.matCod, m.matDesc, m.matValor FROM MATERIAL m WHERE matCod = ? ";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, m.getCodigo());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Material();
                x.setCodigo(rs.getInt("matCod"));
                x.setDescricao(rs.getString("matDesc"));
                x.setValor(rs.getDouble("matValor"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Material pesquisar(String descricao) throws DAOException, ConexaoException {
        Material x = null;
        Connection c = g.conectar();
        String sql = "SELECT m.matCod, m.matDesc, m.matValor FROM MATERIAL m WHERE matDesc LIKE ? ";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, descricao);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Material();
                x.setCodigo(rs.getInt("matCod"));
                x.setDescricao(rs.getString("matDesc"));
                x.setValor(rs.getDouble("matValor"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Material pesquisar(Integer codigo) throws DAOException, ConexaoException {
        Material x = null;
        Connection c = g.conectar();
        String sql = "SELECT m.matCod, m.matDesc, m.matValor FROM MATERIAL m WHERE matCod = ? ";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Material();
                x.setCodigo(rs.getInt("matCod"));
                x.setDescricao(rs.getString("matDesc"));
                x.setValor(rs.getDouble("matValor"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public TableModel preencherTabela() throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "SELECT matCod AS 'CÓDIGO', matDesc AS 'DESCRIÇÃO', matValor AS 'VALOR (R$)' FROM MATERIAL";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            TableModel tb = new TableModel() {

                @Override
                public int getRowCount() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getColumnCount() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public String getColumnName(int columnIndex) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void addTableModelListener(TableModelListener l) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void removeTableModelListener(TableModelListener l) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            tb = DbUtils.resultSetToTableModel(rs);
            return tb;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
