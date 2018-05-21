package lojaInformatica.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Cliente;
import lojaInformatica.util.ConexaoException;
import lojaInformatica.util.GerenciadorConexao;
import lojaInformatica.util.GerenciadorConexaoSQLServer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author renatoandrade
 */
public class DAOClienteImpl implements DAOCliente {

    private final GerenciadorConexao g = GerenciadorConexaoSQLServer.getInstancia();

    @Override
    public void inserir(Cliente a) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "INSERT INTO CLIENTE (clieCpf,clieNome,clieEnd,clieTel,clieEmail) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, a.getCpf());
            pst.setString(2, a.getNome());
            pst.setString(3, a.getEnd());
            pst.setString(4, a.getTel());
            pst.setString(5, a.getEmail());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Cliente a) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "UPDATE CLIENTE SET clieNome=?,clieEnd=?,clieTel=?,clieEmail=? WHERE clieCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, a.getNome());
            pst.setString(2, a.getEnd());
            pst.setString(3, a.getTel());
            pst.setString(4, a.getEmail());
            pst.setString(5, a.getCpf());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Cliente a) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "DELETE FROM CLIENTE WHERE clieCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, a.getCpf());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(String cpf) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "DELETE FROM CLIENTE WHERE clieCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Cliente> listar() throws DAOException, ConexaoException {
        ArrayList<Cliente> lista = new ArrayList();
        Cliente x;
        Connection c = g.conectar();
        String sql = "SELECT clieCpf,clieNome,clieEnd,clieTel,clieEmail FROM CLIENTE";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                x = new Cliente();
                x.setCpf(rs.getString("clieCpf"));
                x.setNome(rs.getString("clieNome"));
                x.setEnd(rs.getString("clieEnd"));
                x.setTel(rs.getString("clieTel"));
                x.setEmail(rs.getString("clieEmail"));
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
    public Cliente pesquisar(Cliente a) throws DAOException, ConexaoException {
        Cliente x = null;
        Connection c = g.conectar();
        String sql = "SELECT clieCpf, clieNome, clieEnd, clieTel, clieEmail FROM CLIENTE WHERE clieCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, a.getCpf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Cliente();
                x.setCpf(rs.getString("clieCpf"));
                x.setNome(rs.getString("clieNome"));
                x.setEnd(rs.getString("clieEnd"));
                x.setTel(rs.getString("clieTel"));
                x.setEmail(rs.getString("clieEmail"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Cliente pesquisar(String cpf) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "SELECT clieCpf, clieNome, clieEnd, clieTel, clieEmail FROM CLIENTE WHERE clieCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            Cliente x = null;
            if (rs.next()) {
                x = new Cliente();
                x.setCpf(rs.getString("clieCpf"));
                x.setNome(rs.getString("clieNome"));
                x.setEnd(rs.getString("clieEnd"));
                x.setTel(rs.getString("clieTel"));
                x.setEmail(rs.getString("clieEmail"));
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
        String sql = "SELECT clieCpf AS 'CPF',clieNome AS 'NOME',clieEnd AS 'ENDEREÇO',clieTel AS 'TELEFONE',clieEmail AS 'EMAIL' FROM CLIENTE";
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
