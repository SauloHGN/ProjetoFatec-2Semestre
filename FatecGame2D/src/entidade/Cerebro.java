package entidade;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePainel;
import main.InputKeys;

public class Cerebro extends Entidade
{
	//
	GamePainel gp;
	InputKeys KeyH;
	//
	int cerebroX = 363;
	int cerebroY = 368;
	int speedC = 3;
	

	public Cerebro(GamePainel gp, InputKeys KeyH) 
	{
		super(gp);
		
		this.gp = gp;
		this.KeyH = KeyH;
		
		getCerebroImage();
		
		
	}

	
	public void getCerebroImage()
	{
		try
		{
			cerebro = ImageIO.read(getClass().getResourceAsStream("/Batalha/cerebro.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void UpdateC()
	{
		
		if(KeyH.cima == true && cerebroY >302)
		{
			cerebroY = cerebroY - speedC;
			
		}
		
		else if(KeyH.baixo == true && cerebroY < 432)
		{
			cerebroY = cerebroY + speedC;
			
		}
		
		else if(KeyH.esquerda == true && cerebroX > 157)
		{
			cerebroX = cerebroX - speedC;
			
		}
		
		else if(KeyH.direita == true && cerebroX < 577)
		{
			cerebroX = cerebroX + speedC;
			
		}	
	}
	
	
	public void drawC(Graphics2D g2)
	{
		g2.drawImage(cerebro, cerebroX, cerebroY, 30, 30, null);
	}

}
