/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author user
 */
public class Vendas_model {

    /**
     * @return the idvenda
     */
    public int getIdvenda() {
        return idvenda;
    }

    /**
     * @param idvenda the idvenda to set
     */
    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the totalpagar
     */
    public double getTotalpagar() {
        return totalpagar;
    }

    /**
     * @param totalpagar the totalpagar to set
     */
    public void setTotalpagar(double totalpagar) {
        this.totalpagar = totalpagar;
    }
    
    private int idvenda;
    private int idCliente;
    private Date data;
    private double totalpagar;
    
}
