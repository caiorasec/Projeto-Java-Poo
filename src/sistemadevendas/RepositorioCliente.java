/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas;

import java.util.ArrayList;

/**
 *
 * @author caio
 */
public class RepositorioCliente {
    
    private ArrayList<Cliente> lista;
    private static RepositorioCliente instanciaRep;
    
    private RepositorioCliente() {
        this.lista = new ArrayList<Cliente>();
    }
    
    public static RepositorioCliente obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new RepositorioCliente();
        }
        return instanciaRep;
    }
    
    public ArrayList<Cliente> listarTodos() {
        return this.lista;
    }
        
    public void inserir(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("Cliente não foi instanciado");
        }
        if (cliente.getCpf() == null) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getCpf().trim().equals("")) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getNome() == null) {
            throw new Exception("Informar o NOME do cliente");
        }
        if (cliente.getNome().trim().equals("")) {
            throw new Exception("Informar o NOME do cliente");
        }
        if (this.verificaExistencia(cliente) >= 0) {
            throw new Exception("O referido cliente já se encontra cadastrado");
        }
        this.lista.add(cliente);
    }
    
    public void remover(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("Cliente não foi instanciado");
        }
        if (cliente.getCpf() == null) {
            throw new Exception ("Informar o CPF do cliente");
        }
        if (cliente.getCpf().trim().equals("")) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (this.verificaExistencia(cliente) == -1) {
            throw new Exception("O referido cliente não encontra-se cadastrado");
        }
        this.lista.remove(this.verificaExistencia(cliente));
    }
    
    public void atualiza(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("Cliente não foi instanciado");
        }
        if (cliente.getCpf() == null) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getCpf().trim().equals("")) {
            throw new Exception("Informar o CPF do cliente");
        }
        if (cliente.getNome() == null) {
            throw new Exception("Informar o NOME do cliente");
        }
        if (cliente.getNome().trim().equals("")) {
            throw new Exception("Informar o NOME do cliente");
        }
        if (this.verificaExistencia(cliente) == -1) {
            throw new Exception("O referido cliente não encontra-se cadastrado");
        }
        this.lista.set(this.verificaExistencia(cliente), cliente);
    }
    
        public int verificaExistencia(Cliente cliente) {
        int retorno = -1;
        for (int i = 0; i < this.lista.size(); i++) {
            if (cliente.getCpf().trim().equals(this.lista.get(i).getCpf().trim())) {
                retorno = 1;
                break;
            }
        }
        return retorno;
    }
}