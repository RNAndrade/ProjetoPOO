package lojaInformatica.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import lojaInformatica.basica.Funcionario;
import lojaInformatica.util.ConexaoException;
import lojaInformatica.util.GerenciadorConexao;
import lojaInformatica.util.GerenciadorConexaoSQLServer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author renatoandrade
 */
public class DAOFuncionarioImpl implements DAOFuncionario {

    private final GerenciadorConexao g = GerenciadorConexaoSQLServer.getInstancia();

    @Override
    public void inserir(Funcionario f) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "INSERT INTO FUNCIONARIO (funcCpf,funcNome,funcTel,funcEnd,funcCargo) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, f.getCpf());
            pst.setString(2, f.getNome());
            pst.setString(3, f.getTel());
            pst.setString(4, f.getEnd());
            pst.setString(5, f.getCargo());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Funcionario f) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "UPDATE FUNCIONARIO SET funcNome=?,funcTel=?,funcEnd=?,funcCargo=? WHERE funcCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, f.getNome());
            pst.setString(2, f.getTel());
            pst.setString(3, f.getEnd());
            pst.setString(4, f.getCargo());
            pst.setString(5, f.getCpf());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Funcionario f) throws DAOException, ConexaoException {
        Connection c = g.conectar();

        String sql = "DELETE FROM FUNCIONARIO WHERE funcCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, f.getCpf());
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

        String sql = "DELETE FROM FUNCIONARIO WHERE funcCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Funcionario> listar() throws DAOException, ConexaoException {
        ArrayList<Funcionario> lista = new ArrayList();
        Funcionario x;
        Connection c = g.conectar();
        String sql = "SELECT funcCpf,funcNome,funcTel,funcEnd,funcCargo FROM FUNCIONARIO";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                x = new Funcionario();
                x.setCpf(rs.getString("funcCpf"));
                x.setNome(rs.getString("funcNome"));
                x.setEnd(rs.getString("funcTel"));
                x.setTel(rs.getString("funcEnd"));
                x.setCargo(rs.getString("funcCargo"));
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
    public Funcionario pesquisar(Funcionario f) throws DAOException, ConexaoException {
        Funcionario x = null;
        Connection c = g.conectar();
        String sql = "SELECT f.funcCpf,f.funcNome,f.funcTel,f.funcEnd, f.funcCargo FROM FUNCIONARIO a WHERE funcCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, f.getCpf());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                x = new Funcionario();
                x.setCpf(rs.getString("funcCpf"));
                x.setNome(rs.getString("funcNome"));
                x.setEnd(rs.getString("funcTel"));
                x.setTel(rs.getString("funcEnd"));
                x.setCargo(rs.getString("funcCargo"));
            }
            return x;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Funcionario pesquisar(String cpf) throws DAOException, ConexaoException {
        Connection c = g.conectar();
        String sql = "SELECT f.funcCpf,f.funcNome,f.funcTel,f.funcEnd, f.funcCargo FROM FUNCIONARIO f WHERE funcCpf=?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            Funcionario x = null;
            if (rs.next()) {
                x = new Funcionario();
                x.setCpf(rs.getString("funcCpf"));
                x.setNome(rs.getString("funcNome"));
                x.setTel(rs.getString("funcTel"));
                x.setEnd(rs.getString("funcEnd"));
                x.setCargo(rs.getString("funcCargo"));
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
        String sql = "SELECT funcCpf AS 'CPF',funcNome AS 'NOME',funcTel AS 'TELEFONE',funcEnd AS 'ENDEREÇO',funcCargo AS 'CARGO' FROM FUNCIONARIO";
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
