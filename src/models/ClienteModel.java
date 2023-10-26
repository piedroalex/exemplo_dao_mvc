package models;

import java.util.List;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import util.Cliente;

/**
 * Modelo ClienteModel
 * 
 * @author Pedro Alex
 */
public class ClienteModel {
	
	private ClienteDAO clienteDAO;

    public ClienteModel() {
        clienteDAO = new ClienteDAOImpl();
    }

    public Cliente buscarPorId(Integer id) {
        return clienteDAO.buscarPorId(id);
    }
    
    public List<Cliente> listarClientes() {
        return clienteDAO.buscarTodos();
    }

    public void inserirCliente(Cliente cliente) {
        clienteDAO.inserir(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public void excluirCliente(Cliente cliente) {
        clienteDAO.excluir(cliente.getId());
    }
}
