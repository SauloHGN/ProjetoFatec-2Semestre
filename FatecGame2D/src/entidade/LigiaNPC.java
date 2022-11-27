package entidade;

import main.GamePainel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LigiaNPC extends Entidade
{

	public LigiaNPC(GamePainel gp)
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
				baixo1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				baixo2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				cima1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				cima2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				costas = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				parado = ImageIO.read(getClass().getResourceAsStream("/LigiaNPC/Lteste.png"));
				
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
			if(gp.player.level <= 4)
			{
				dialogos[0][0] ="Ligia: Seja Bem-vindo à Fatec \n Cruzeiro! \nTemos os melhores cursos de \ngraduação da região...";
				dialogos[0][1] = "Ligia: Porem, recentes eventos \nvem dificultando a vida dos \nnossos alunos, precisamos de \n"
					+ "uma mente brilhante ";
				dialogos[0][2] = "Ligia: para passar por todos os \ndesafios e salvar a faculdade \ndo MASTER OF FLUKERS";
				dialogos[0][3] = "Ligia: Vá a biblioteca pois a Prof. \nEuridice tem mais pistas sobre o \ncaso.";
			}
			
			if(gp.player.level > 4)
			{
				dialogos[0][0] = "Ligia: Oh não, uma clausula \ncontratual me impede de dizer \no codigo de acesso da sala do \nMASTER OF FLUKERS";
				dialogos[0][1] = "Ligia: Mas saiba que na minha \nfamilia \"um único primo se \ndestaca entre todos\"";
				dialogos[0][2] = "Ligia: Oh não, uma clausula \ncontratual me impede de dizer \no codigo de acesso da sala do \nMASTER OF FLUKERS";
				dialogos[0][3] = "Ligia: Mas saiba que na minha \nfamilia \"um único primo se \ndestaca entre todos\"";
			}
		}
		
		public void fala()
		{
			IniciarDialogo(this, setDialogo);
		}
}
