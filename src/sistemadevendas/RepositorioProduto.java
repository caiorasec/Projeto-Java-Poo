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
public class RepositorioProduto {
    
    private ArrayList<Produto> lista;
    private static RepositorioProduto instanciaRep;
    private int retorno;
    
    public RepositorioProduto() {
        this.lista = new ArrayList<Produto>();
    }
    
    public static RepositorioProduto obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new RepositorioProduto();
        }
        return instanciaRep;
    }
    
    public ArrayList<Produto> listarTodos() {
        return this.lista;
    }
    
    public void inserir(Produto produto) throws Exception {
        if (produto == null) {
            throw new Exception("Produto não foi instanciado");
        }
        if (produto.getCodigoBarras() == null) {
            throw new Exception("Informar o código de barras do produto");
        }
        if (produto.getCodigoBarras().trim().equals("")) {
            throw new Exception("Informar o código de barras do produto");
        }
        if (produto.getDescricao() == null) {
            throw new Exception("Informar a descrição do produto");
        }
        if (produto.getDescricao().trim().equals("")) {
            throw new Exception("Informar a descrição do produto");
        }
        if (produto.getPreco() <= 0) {
            throw new Exception("O preço deverá ser maior que zero");
        }
        if (this.verificaExistencia(produto) >= 0) {
            throw new Exception("O produto já se encontra cadastrado");
        }
        this.lista.add(produto);
    }
    
    public void remover(Produto produto) throws Exception {
        if (produto == null) {
            throw new Exception("Produto não instanciado");
        }
        if (produto.getCodigoBarras() == null) {
            throw new Exception("Informar o código de barras do produto");
        }
        if (produto.getCodigoBarras().trim().equals("")) {
            throw new Exception("Informar o código de barras do produto");
        }
        if (this.verificaExistencia(produto) == -1) {
            throw new Exception("Produto não ainda não foi cadastrado");
        }
        this.lista.remove(this.verificaExistencia(produto));
    }
    
    public void atualizar(Produto produto) throws Exception {
        if (produto == null) {
            throw new Exception("O produto não foi instanciado");
        }
        if (produto.getCodigoBarras() == null) {
            throw new Exception("Informar o código de barras do produto");
        }
        if (produto.getCodigoBarras().trim().equals("")) {
            throw new Exception("Informar o código de barras do produto");
        }
        if (produto.getDescricao() == null) {
            throw new Exception("Informar a descrição do produto");
        }
        if (produto.getDescricao().trim().equals("")) {
            throw new Exception("Informar a descrição do produto");
        }
        if (produto.getPreco() <= 0) {
            throw new Exception("O preço deverá ser maior que zero");
        }
        if (this.verificaExistencia(produto) < 0) {
            throw new Exception("O produto ainda não esta cadastrado");
        }
    }
    public int verificaExistencia(Produto produto) {
        retorno = -1;
        for (int i = 0; i <= this.lista.size(); i++) {
            if (produto.getCodigoBarras().trim().equals(this.lista.get(i).getCodigoBarras().trim())) {
                retorno = i;
                break;
            }
        }
        return retorno;
    }
    
}
