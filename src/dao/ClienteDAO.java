package dao;

import java.util.List;

import util.Cliente;

/**
 * Interface ClienteDAO
 * 
 * @author Pedro Alex
 */
public interface ClienteDAO {
	
	Cliente buscarPorId(Integer id);
	
    List<Cliente> buscarTodos();    
    
    void inserir(Cliente cliente);    
    
    void atualizar(Cliente cliente);
    
    void excluir(Integer id);
    
}
