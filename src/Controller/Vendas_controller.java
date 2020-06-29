/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Categorias_model;
import Models.ItemVendas_model;
import Models.Produtos_model;
import Models.Vendas_model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Vendas_controller {
    
     Conexao c = new Conexao();

    public void salvar(Vendas_model cli) {

     try{
      c.conectar();
      PreparedStatement pst = c.con.prepareStatement(
     "INSERT INTO Vendas (Clientes_id_cliente, data_venda , valor_total_venda) " +
     "VALUES( ?, ?, ? )");

       pst.setInt(1, cli.getIdCliente());
       pst.setString(2, (String.valueOf(cli.getData())));
       pst.setDouble(3, cli.getTotalpagar());       
       
       pst.execute();
       pst.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro da Venda",0);
      }
   }
    
    public ArrayList busca(Vendas_model v){
        
        ArrayList<ItemVendas_model> lista = new ArrayList<ItemVendas_model>();
        
         try {
             c.conectar();
            PreparedStatement pst = c.con.prepareStatement("Select * from Vendas va "
                    + "INNER JOIN ItensVenda iv on iv.Vendas_id_venda = va.id_venda "
                    + "where va.Clientes_id_cliente = ?");
            
            pst.setInt(1, v.getIdCliente());
            
            ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               
               
             ItemVendas_model ven = new ItemVendas_model();
               ven.setIdVenda(rs.getInt("id_venda"));
               ven.setQtde(rs.getInt("quantidade_itens"));
               ven.setTotalparc(rs.getDouble("valor_total_itens"));
           
              lista.add(ven);
              
           }
            rs.close();
            pst.close();
            c.Fechar_Conexao();
            
                
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
         }
        
        return lista;
        
    }
    
    
    public ArrayList<Vendas_model> buscar(Vendas_model v){
         ArrayList<Vendas_model> lista = new ArrayList<Vendas_model>();

        try{
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement("Select * from Vendas va "
                    + "INNER JOIN ItensVenda iv on iv.Vendas_id_venda = va.id_venda "
                    + "where va.Clientes_id_cliente = ?");
            
            pst.setInt(1, v.getIdCliente());
            
            ResultSet rs = pst.executeQuery();
           
            while(rs.next()){

               Vendas_model ven = new Vendas_model();
               ven.setIdvenda(rs.getInt("id_venda"));
               ven.setData((Date) rs.getObject("data_venda"));
               ven.setTotalpagar(rs.getDouble("valor_total_venda"));

               lista.add(ven);

            }
                        
            pst.execute();
            pst.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro da Venda",0);
        }
        return lista;
    }
    
    
    public void alterar(Vendas_model cli) {

     try{
         c.conectar();
         PreparedStatement stmt = c.con.prepareStatement(
            "UPDATE Vendas SET Clientes_id_cliente = ?, data_venda = ?, valor_total_venda = ? WHERE id_venda = ?");

            stmt.setInt(1,cli.getIdCliente());
            stmt.setString(2, (String.valueOf(cli.getData())));
            stmt.setDouble(3, cli.getTotalpagar());
            stmt.setInt(4, cli.getIdvenda());
            
            
            System.out.println(stmt);
            
            stmt.execute();
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração da Venda", 0);
        }
    }

    public int listar() {

     int lista=0;

      try{
          c.conectar();
          PreparedStatement stmt = c.con.prepareStatement(
                "SELECT MAX(id_venda) FROM Vendas");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            lista = rs.getInt(1);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Vendas", 0);
      }
      return lista;
    }
}

/* 

Select * from Vendas v Where id_vendas = 1 INNER JOIN ItensVenda iv on iv.Vendas_id_venda = id_venda;

Select * from Vendas v INNER JOIN ItensVenda iv on iv.Vendas_id_venda = v.id_venda where v.Clientes_id_cliente = ?

UPDATE Vendas SET Clientes_id_cliente = 1, data_venda = '2020-06-29', valor_total_venda =  10.00 WHERE id_venda =  4

*/