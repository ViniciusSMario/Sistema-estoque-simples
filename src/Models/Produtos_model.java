/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author user
 */
public class Produtos_model {

    /**
     * @return the nomeCategoria
     */
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * @param nomeCategoria the nomeCategoria to set
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    /**
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the valor_compra
     */
    public double getValor_compra() {
        return valor_compra;
    }

    /**
     * @param valor_compra the valor_compra to set
     */
    public void setValor_compra(double valor_compra) {
        this.valor_compra = valor_compra;
    }

    /**
     * @return the valor_venda
     */
    public double getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    /**
     * @return the qauntidade
     */
    public int getQauntidade() {
        return qauntidade;
    }

    /**
     * @param qauntidade the qauntidade to set
     */
    public void setQauntidade(int qauntidade) {
        this.qauntidade = qauntidade;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the fornecedor
     */
    public int getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
    private int idProduto;
    private String nomeProduto;
    private double valor_compra;
    private double valor_venda;
    private int qauntidade;
    private int categoria;
    private int fornecedor;
    private String nomeCategoria;
    private String nomeFornecedor;
    
}
