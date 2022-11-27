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
		
		public void setAction()
		{
			setDialogo();
		}
		
		public void setDialogo()
		{
			if(gp.player.level < 4)
			{
			dialogos[0] ="Euridice: O eu leitor está \n atribulado. \nAo certo, seus proprios textos \nmaculados";		
			dialogos[1] = "Euridice: Se for de má vontade \nsua determinação não serás \ncapaz de achar a solução...";
			dialogos[2] = "Euridice: Procure os livros \ncelestiais e traga-os a minha \npessoa e minha sapiência vai \nindicar sua proxima escolha.";
			}
			
			if(gp.player.level >= 4)
			{
				
				dialogos[0] = "Euridice: Um exímio feito, \nmeu facínio e respeito. \nOs manuscritos revelam a \ntribulação dos discentes";
				dialogos[1] = "Euridice: Cabe a vós o estudo \ndos números condizentes.\nAos colegas professores foram\n confiados as instruções";
				dialogos[2] = "Euridice: que te leva aos perigos \ne aflições. Encontre a sequência\n numérica magistral.";
				dialogos[3] = "E o MASTER OF FLUKERS \nentreverá seu final.";
				dialogos[4] = "Você subiu + 1 nivel";
				
				
			}
		}
		
		
}