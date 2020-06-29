/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Categorias_model;
import Models.Fornecedores_model;
import Models.Produtos_model;
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
public class Produtos_controller {
    Conexao c = new Conexao();
    
    public void salvar(Produtos_model prod) {
        
     try{
      c.conectar();
      PreparedStatement stmt = c.con.prepareStatement(
     "INSERT INTO Produtos(Fornecedores_id_fornecedor, Categorias_id_categoria, nome_produto ,valor_compra, valor_venda, quantidade ) " +
     "VALUES( ?, ?, ?, ?, ?, ? )");

       stmt.setInt(1, prod.getFornecedor());
       stmt.setInt(2, prod.getCategoria());
       stmt.setString(3, prod.getNomeProduto());
       stmt.setDouble(4, prod.getValor_compra());
       stmt.setDouble(5,prod.getValor_venda());
       stmt.setInt(6,prod.getQauntidade());
 
       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Produtos",0);
      }
   }  
    
    
    
    public int listar() {

     int lista=0;

      try{
          c.conectar();
          PreparedStatement stmt = c.con.prepareStatement(
                "SELECT MAX(idproduto) FROM produto");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            lista = rs.getInt(1);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Clientes", 0);
      }
      return lista;
    }



 public ArrayList busca(){
        
        ArrayList<Produtos_model> lista = new ArrayList<Produtos_model>();
        
         try {
            c.conectar();
            PreparedStatement pst = c.con.prepareStatement("SELECT * FROM Produtos p "
                    + " INNER JOIN Fornecedores f on f.id_fornecedor = p.Fornecedores_id_fornecedor"
                    + " INNER JOIN Categorias c on c.id_categoria = p.Categorias_id_categoria");
            
            ResultSet rs = pst.executeQuery();
           
           while(rs.next()){
               
               
              Produtos_model prod = new Produtos_model();
              prod.setIdProduto(rs.getInt("id_produto"));
              prod.setNomeFornecedor(rs.getString("nome_fornecedor"));
              prod.setNomeCategoria(rs.getString("nome_categoria"));
              prod.setNomeProduto(rs.getString("nome_produto"));
              prod.setValor_compra(rs.getDouble("valor_compra"));
              prod.setValor_venda(rs.getDouble("valor_venda"));
              prod.setQauntidade(rs.getInt("quantidade"));
             
              
              lista.add(prod);
              
           }
            rs.close();
            pst.close();
            c.Fechar_Conexao();
            
                
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
         }
        
        return lista;
        
    }
 
  public void alterar(Produtos_model p) {

     try{
         c.conectar();
         PreparedStatement stmt = c.con.prepareStatement(
                    "UPDATE Produtos " +
                    "SET " +
                       "    quantidade = ? " +
                    "WHERE " +
                    "    id_produto = ?");

            stmt.setInt(1,p.getQauntidade());
            stmt.setInt(2, p.getIdProduto());
            
            stmt.execute();
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração da Venda", 0);
        }
    }
  
  
  public void alterarEstoque(Produtos_model p) {

     try{
         c.conectar();
         PreparedStatement stmt = c.con.prepareStatement(
                    "UPDATE Produtos " +
                    "SET " +
                       "    quantidade = ? " +
                    "WHERE " +
                    "    id_produto = ?");

            stmt.setInt(1,p.getQauntidade());
            stmt.setInt(2, p.getIdProduto());
            
            stmt.execute();
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração da Venda", 0);
        }
    }
  
  public List listar_dados() {

     List<Produtos_model> lista = new ArrayList<Produtos_model>();

      try{
          c.conectar();
          PreparedStatement stmt = c.con.prepareStatement(
                "SELECT * FROM Produtos");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Produtos_model t = new Produtos_model();
          t.setIdProduto(rs.getInt("id_produto"));
          t.setNomeProduto(rs.getString("nome_produto"));
          t.setValor_venda(rs.getDouble("valor_venda"));
          t.setQauntidade(rs.getInt("quantidade"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração de Clientes", 0);
      }
      return lista;
    }
}

