package views;

import java.util.List;

import util.Cliente;

/**
 * View ClienteView
 * 
 * @author Pedro Alex
 */
public class ClienteView {
	
	public void imprimirClientes(List<Cliente> clientes) {
		System.out.println("----- LISTA DE CLIENTES -----");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
        System.out.println("-----------------------------");
    }
	
	public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
