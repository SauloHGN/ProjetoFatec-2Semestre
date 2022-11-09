package entidade;

import main.GamePainel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EuNPC extends Entidade
{

	public EuNPC(GamePainel gp)
	{
		super(gp);	
		Direction = "parado";
		
		getImage();			
		setDialogo();
	}
	
			
		public void getImage()// tiles das animações do npc
		{
			try 
			{
				baixo1 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				baixo2 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				cima1 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				cima2 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				costas = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				parado = ImageIO.read(getClass().getResourceAsStream("/EuNPC/Euparado.png"));
				
			}
			
			catch(IOException e) 
			{
				e.printStackTrace();
			}			
		}
		
		
		public void setDialogo()
		{
			dialogos[0] ="Euridice";
		}
		
		
}