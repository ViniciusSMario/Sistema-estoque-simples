/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Categorias_model;
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
public class Categorias_controller {
    Conexao c = new Conexao();

    public void inserir(Categorias_model cat) {
                
        try{
            c.conectar();
            
            PreparedStatement pst = c.con.prepareStatement("INSERT INTO Categorias " +
              " (nome_categoria) VALUES ( ?)");
            
            pst.setString(1, cat.getNomeCategoria());
            
            pst.execute();
            pst.close();
            
            
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso","",1);
         
            

        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta", 2);

        }   
    }
    
    
    /* public ArrayList<Categorias_model> busca(Categorias_model cat){
        
        ArrayList<Categorias_model> lista = new ArrayList<Categorias_model>();
        
       
         try {
            c.conectar();
            
            PreparedStatement pst = c.con.prepareStatement("SELECT * from Categorias WHERE id_categoria = ?");
            pst.setString(1, cat.getNomeCategoria());
           
           
           ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               
              Categorias_model ca = new Categorias_model();
              ca.setIdCategoria(rs.getInt("id_categoria"));
              ca.setNomeCategoria(rs.getString("nome_categoria"));
             
              
              lista.add(ca);
              
           }
           
                rs.close();
                pst.close();
                c.Fechar_Conexao();
                
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
         }
        
        return lista;
        
    }*/
    
    
    public ArrayList busca2(){
        
        ArrayList<Categorias_model> lista = new ArrayList<Categorias_model>();
        
         try {
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement("SELECT * FROM Categorias ");
            
            ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               
              Categorias_model cat = new Categorias_model();
              cat.setIdCategoria(rs.getInt("id_categoria"));
              cat.setNomeCategoria(rs.getString("nome_categoria"));
             
              
              lista.add(cat);
              
           }
            rs.close();
            pst.close();
            c.Fechar_Conexao();
            
                
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
         }
        
        return lista;
        
    }
    
    public List listar() {

     List<Categorias_model> lista = new ArrayList<Categorias_model>();

      try{
          c.conectar();
          PreparedStatement stmt = c.con.prepareStatement(
                "SELECT * FROM Categorias");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Categorias_model c = new Categorias_model();
          c.setIdCategoria(rs.getInt("id_categoria"));
          c.setNomeCategoria(rs.getString("nome_categoria"));
          lista.add(c);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Categorias", 0);
      }
      return lista;
    }
    
     public void alterar(Categorias_model cat) {

     try{
         c.conectar();
         PreparedStatement pst = c.con.prepareStatement(
                    "UPDATE Categorias " +
                    "SET " +
                       "    nome_categoria = ? " +
                    "WHERE " +
                    "    id_categoria = ?");

            pst.setString(1,cat.getNomeCategoria());
            pst.setInt(2, cat.getIdCategoria());
            
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso","",1);


        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração de Categoria", 0);
        }
    }
     
     
     public void deletar(Categorias_model cat){
         try{
             c.conectar();
              PreparedStatement pst = c.con.prepareStatement(
                    "DELETE from Categorias  WHERE id_categoria = ?");

            pst.setInt(1, cat.getIdCategoria());
            
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso","",1);

             
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Exclusão de Categoria", 0);
        }
     }

    
}
