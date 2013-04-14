/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadevendas;

/**
 *
 * @author caio
 */
public class ItemVenda {
    private float quantidade;
    private float preco;
    private Produto produto;
    
    public ItemVenda() {
        this.produto = new Produto();
    }

    /**
     * @return the quantidade
     */
    public float getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
