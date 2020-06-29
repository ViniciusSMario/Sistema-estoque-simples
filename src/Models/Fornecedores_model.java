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
public class Fornecedores_model {

    /**
     * @return the idFornecedor
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
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
     * @return the cidadeFornecedor
     */
    public String getCidadeFornecedor() {
        return cidadeFornecedor;
    }

    /**
     * @param cidadeFornecedor the cidadeFornecedor to set
     */
    public void setCidadeFornecedor(String cidadeFornecedor) {
        this.cidadeFornecedor = cidadeFornecedor;
    }

    /**
     * @return the estadoFornecedor
     */
    public String getEstadoFornecedor() {
        return estadoFornecedor;
    }

    /**
     * @param estadoFornecedor the estadoFornecedor to set
     */
    public void setEstadoFornecedor(String estadoFornecedor) {
        this.estadoFornecedor = estadoFornecedor;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telFornecedor
     */
    public String getTelFornecedor() {
        return telFornecedor;
    }

    /**
     * @param telFornecedor the telFornecedor to set
     */
    public void setTelFornecedor(String telFornecedor) {
        this.telFornecedor = telFornecedor;
    }
   private int idFornecedor;
   private String nomeFornecedor;
   private String cidadeFornecedor;
   private String estadoFornecedor;
   private String cnpj;
   private String email;
   private String telFornecedor;
}
