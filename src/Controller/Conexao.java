package Controller;

import java.sql.*; // pacote jdbc

public class Conexao {

  public Connection con;
  //static String usuario="postgres";
  static String usuario="root";
  static String senha="root";
  static String database="vendinha"; // base de dados
 
  //static String url="jdbc:postgresql://localhost/javaJDBC"; 
  static String url="jdbc:mysql://localhost/"+database;
    
  public Conexao(){ // construtor
      }
  
  public void conectar() //conecta com o BD
  {
    try {   
       //Class.forName("org.postgresql.Driver"); 
       Class.forName("org.gjt.mm.mysql.Driver");
       System.out.println("Driver OK!!!");
           
       con = DriverManager.getConnection(url,usuario,senha);
       System.out.println("Conexão OK!!!");
    } catch ( ClassNotFoundException exc ) {
       System.out.println("Erro no driver "+exc.getMessage());
    } catch(SQLException exc){
       System.out.println("Erro de conexao ="+exc.getMessage());
    }
  }

  public void Fechar_Conexao()  {
       try{
           con.close(); // fechando a conexao
       } catch(SQLException exc) {
           System.out.println(exc.getMessage());
       }
   }
}  // fechando a classe Conexao
