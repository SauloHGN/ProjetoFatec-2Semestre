package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import main.GamePainel;

public class SaveLoad 
{
	GamePainel gp;
	private Connection connection;
	
	
	
	
	
	
	public SaveLoad(GamePainel gp)
	{
		this.gp = gp;
		
		
		
	}
	
	public void Salvar(GamePainel gp)
	{
		connection = null;
		Statement stmt = null;
		
		try 
        {
            stmt = connection.createStatement();
            

           String sql = "INSERT INTO progresso(id,level,vida,moeda,posLinha,posColuna) "
            		   + "VALUES ('"+gp.player.speed+"','"+gp.player.level+"', '"+gp.player.vida+"', '"+gp.player.moeda+"', '"+(gp.player.worldY + gp.player.solidArea.x)/gp.tileSize+"', '"+ (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize+"')";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            System.out.println("Os dados foram salvados com sucesso");
           
            
            return;
        } 
        catch (SQLException e)
        {
        	System.out.println("Falha ao salvar dados");
            System.out.println(e.getMessage());
            return;
        } 
		finally
		{
	       try 
	        {
	           stmt.close();
	           connection.close();
	           System.out.println("Desconectado com sucesso");
	        }
	        catch (SQLException e)
	        {
	            System.out.println("Erro ao desconectar" + e.getMessage());
	        }
	    }
		
	}
	
} 
	
	
	

