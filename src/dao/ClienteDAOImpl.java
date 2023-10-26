package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Cliente;
import util.ParametrosDaConexao;

/**
 * Implementação da interface ClienteDAO
 * 
 * @author Pedro Alex
 */
public class ClienteDAOImpl implements ClienteDAO {
	
    private Integer proximoId = 1;

    @Override
    public Cliente buscarPorId(Integer idCliente) {
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "SELECT * FROM clientes WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	Integer id = resultSet.getInt("id"); 
                String nome = resultSet.getString("nome");
            	return new Cliente(id, nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(resultSet != null) {
            		resultSet.close();
				}
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<>();
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "SELECT * FROM clientes";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
            	Integer id = resultSet.getInt("id"); 
                String nome = resultSet.getString("nome");
            	Cliente cliente = new Cliente(id, nome);
            	clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(resultSet != null) {
            		resultSet.close();
				}
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return clientes;
    }

    @Override
    public void inserir(Cliente cliente) {
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "INSERT INTO clientes (id, nome) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, proximoId++);
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

    @Override
    public void atualizar(Cliente cliente) {
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "UPDATE clientes SET nome = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

    @Override
    public void excluir(Integer idCliente) {
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "DELETE FROM clientes WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

}
