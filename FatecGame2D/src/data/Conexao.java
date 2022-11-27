
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import main.GamePainel;


public class Conexao 
{
    
    static GamePainel gp;
    
    Connection con;
    Statement stmt;
    public static Conexao instance = null;

    public Conexao(GamePainel gp) 
    {
    	
    	
    	try 
    	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Carregado");
            
        } 
    	catch (ClassNotFoundException e) 
    	{
            System.out.println("Nao foi possivel carregar o driver MySQL");
        }
    }
    
   
    public static Conexao getInstance(GamePainel gp) 
    {
        if (instance == null) 
        {
            instance = new Conexao(gp);
        }
        return instance;
    }

    public Connection getConnection(GamePainel gp) 
    {
        try 
        {
            if ((con == null) || (con.isClosed())) 
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost/datagame", "root", "");
                System.out.println("Conectado com sucesso");
                stmt = con.createStatement();
            }
        } 
        catch (SQLException e)
        {
        	System.out.println("Erro na conexão com o banco de dados");
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void destroy(GamePainel gp) 
    {
        try 
        {
            con.close();
        } 
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    
}
