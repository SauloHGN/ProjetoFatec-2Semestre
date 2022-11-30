package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;

public class Moeda extends superObjetos
{

	public Moeda(GamePainel gp)
	{
		super(gp);
		
		name = "moeda";
		try
		{
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/itens/moeda.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		colision = true;
	}
	
	
}
