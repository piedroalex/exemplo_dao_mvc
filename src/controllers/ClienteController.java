package controllers;

import java.util.List;

import models.ClienteModel;
import util.Cliente;
import views.ClienteView;

/**
 * Controller ClienteController
 * 
 * @author Pedro Alex
 */
public class ClienteController {

	private ClienteModel clienteModel;
    private ClienteView clienteView;

    public ClienteController(ClienteModel clienteModel, ClienteView clienteView) {
        this.clienteModel = clienteModel;
        this.clienteView = clienteView;
    }

    public Cliente buscarPorId(Integer idCliente) {
        Cliente cliente = clienteModel.buscarPorId(idCliente);
        return cliente;
    }

    public void listarClientes() {
        List<Cliente> clientes = clienteModel.listarClientes();
        if(clientes.isEmpty()) {
        	clienteView.exibirMensagem("Nenhum cliente cadastrado!");
        }else {
        	clienteView.imprimirClientes(clientes);
        }
    }
    
    public void inserirCliente(Cliente cliente) {
        clienteModel.inserirCliente(cliente);
        clienteView.exibirMensagem("Cliente adicionado com sucesso.");
    }
    
    public void excluirCliente(Cliente cliente) {
        clienteModel.excluirCliente(cliente);
        clienteView.exibirMensagem("Cliente excluido com sucesso.");
    }
}
