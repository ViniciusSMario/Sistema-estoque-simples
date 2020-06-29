/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.ItemVendas_model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ItemVendas_controller {
    Conexao c = new Conexao();

  public void salvar(ItemVendas_model cli) {

    try{
      c.conectar();
      PreparedStatement stmt = c.con.prepareStatement(
        "INSERT INTO ItensVenda (Produtos_id_produto ,Vendas_id_venda ,quantidade_itens ,valor_total_itens) " +
        "VALUES( ?, ?, ?, ?)");

       stmt.setInt(1, cli.getIdProduto());
       stmt.setInt(2, cli.getIdVenda());
       stmt.setInt(3, cli.getQtde());
       stmt.setDouble(4, cli.getTotalparc());

       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Vendas",0);
      }
   }
}
