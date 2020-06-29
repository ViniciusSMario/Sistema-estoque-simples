/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Categorias_model;
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
public class Fornecedores_controller {
     Conexao c = new Conexao();

     public void inserir(Fornecedores_model forn) {
                
        try{
            c.conectar();
            
            PreparedStatement pst = c.con.prepareStatement("INSERT INTO Fornecedores " +
              " (nome_fornecedor, cidade_fornecedor, estado_fornecedor, CNPJ_fornecedor, email_fornecedor, telefone_fornecedor ) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");
            
            pst.setString(1, forn.getNomeFornecedor());
            pst.setString(2, forn.getCidadeFornecedor());
            pst.setString(3, forn.getEstadoFornecedor());
            pst.setString(4, forn.getCnpj());
            pst.setString(5, forn.getEmail());
            pst.setString(6, forn.getTelFornecedor());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso","",1);
         
            

        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta", 2);

        }   
    }
     
     
     public ArrayList busca(){
        
        ArrayList<Fornecedores_model> lista = new ArrayList<Fornecedores_model>();
        
         try {
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement("SELECT * FROM Fornecedores");
            
            ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               
              Fornecedores_model forn = new Fornecedores_model();
              forn.setIdFornecedor(rs.getInt("id_fornecedor"));
              forn.setNomeFornecedor(rs.getString("nome_fornecedor"));
              forn.setCidadeFornecedor(rs.getString("cidade_fornecedor"));
              forn.setEstadoFornecedor(rs.getString("estado_fornecedor"));
              forn.setCnpj(rs.getString("CNPJ_fornecedor"));
              forn.setEmail(rs.getString("email_fornecedor"));
              forn.setTelFornecedor(rs.getString("telefone_fornecedor"));
             
              
              lista.add(forn);
              
           }
            rs.close();
            pst.close();
            c.Fechar_Conexao();
            
                
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
         }
        
        return lista;
        
    }
     
     
    public void alterar(Fornecedores_model forn) {

        try{
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement(
                       "UPDATE Fornecedores " +
                       "SET " +
                               "nome_fornecedor = ?, " +
                               "cidade_fornecedor = ?, "+
                               "estado_fornecedor = ?, "+
                               "CNPJ_fornecedor = ?, " +
                               "email_fornecedor = ?," +
                               "telefone_fornecedor = ?" +
                       "WHERE " +
                               "id_fornecedor = ?");

               pst.setString(1, forn.getNomeFornecedor());
               pst.setString(2, forn.getCidadeFornecedor());
               pst.setString(3, forn.getEstadoFornecedor());
               pst.setString(4, forn.getCnpj());
               pst.setString(5, forn.getEmail());
               pst.setString(6, forn.getTelFornecedor());
               pst.setInt(7, forn.getIdFornecedor());

               pst.execute();
               pst.close();

               JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso","",1);


           } catch(SQLException e){
               JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração de Fornecedor", 0);
           }
    }
    
     public void deletar(Fornecedores_model forn){
         try{
             c.conectar();
              PreparedStatement pst = c.con.prepareStatement(
                    "DELETE from Fornecedores WHERE id_fornecedor = ?");

            pst.setInt(1, forn.getIdFornecedor());
            
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso","",1);

             
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Exclusão de Fornecedor", 0);
        }
     }
     
     public List listar() {

     List<Fornecedores_model> lista = new ArrayList<Fornecedores_model>();

      try{
          c.conectar();
          PreparedStatement stmt = c.con.prepareStatement(
                "SELECT * FROM Fornecedores");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Fornecedores_model t = new Fornecedores_model();
          t.setIdFornecedor(rs.getInt("id_fornecedor"));
          t.setNomeFornecedor(rs.getString("nome_fornecedor"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Fornecedores", 0);
      }
      return lista;
    }
}
