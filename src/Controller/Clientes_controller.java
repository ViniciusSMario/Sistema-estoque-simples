/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Clientes_model;
import Models.Fornecedores_model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Clientes_controller {
    
    Conexao c = new Conexao();

     public void inserir(Clientes_model cli) {
                
        try{
            c.conectar();
            
            PreparedStatement pst = c.con.prepareStatement("INSERT INTO Clientes " +
              " (nome_cliente, CPF_cliente, telefone_cliente, rua_cliente, bairro_cliente) "
                    + "VALUES (?, ?, ?, ?, ?)");
            
            pst.setString(1, cli.getNomeCliente());
            pst.setString(2, cli.getCpf());
            pst.setString(3, cli.getTelefone());
            pst.setString(4, cli.getRua());
            pst.setString(5, cli.getBairro());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso","",1);
         
            

        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta", 2);

        }   
    }
     
     public ArrayList busca(){
        
        ArrayList<Clientes_model> lista = new ArrayList<Clientes_model>();
        
         try {
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement("SELECT * FROM Clientes");
            
            ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               
              Clientes_model cli = new Clientes_model();
              cli.setIdCliente(rs.getInt("id_cliente"));
              cli.setNomeCliente(rs.getString("nome_cliente"));
              cli.setCpf(rs.getString("CPF_cliente"));
              cli.setTelefone(rs.getString("telefone_cliente"));
              cli.setRua(rs.getString("rua_cliente"));
              cli.setBairro(rs.getString("bairro_cliente"));
             
              
              lista.add(cli);
              
           }
            rs.close();
            pst.close();
            c.Fechar_Conexao();
            
                
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
         }
        
        return lista;
        
    }
     
     
      public void alterar(Clientes_model cli) {

        try{
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement(
                       "UPDATE Clientes " +
                       "SET " +
                               "nome_cliente = ?, " +
                               "CPF_cliente = ?, "+
                               "telefone_cliente = ?, "+
                               "rua_cliente = ?, " +
                               "bairro_cliente = ?" +
                       "WHERE " +
                               "id_cliente = ?");

               pst.setString(1, cli.getNomeCliente());
               pst.setString(2, cli.getCpf());
               pst.setString(3, cli.getTelefone());
               pst.setString(4, cli.getRua());
               pst.setString(5, cli.getBairro());
               pst.setInt(6, cli.getIdCliente());

               pst.execute();
               pst.close();

               JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso","",1);


           } catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração de Cliente", 0);
           }
    }
      
      public List listar_dados() {

     List<Clientes_model> lista = new ArrayList<Clientes_model>();

      try{
          c.conectar();
     
          PreparedStatement stmt = c.con.prepareStatement(
              "SELECT * FROM Clientes" );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Clientes_model t = new Clientes_model();
          t.setIdCliente(rs.getInt("id_cliente"));
          t.setNomeCliente(rs.getString("nome_cliente"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Clientes", 0);
      }
      return lista;
    }
    
     
}
