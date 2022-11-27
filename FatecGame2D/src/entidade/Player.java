package entidade;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;
import main.InputKeys;

public class Player extends Entidade
{
	
	GamePainel gp;
	 InputKeys KeyH;
	public final int screenX;
	public final int screenY;
	
	
	
	public Player(GamePainel gp, InputKeys KeyH)
	{
		super(gp);
		
		this.gp = gp;
		this.KeyH = KeyH;
		
		screenX = gp.screenLargura/2;
		screenY = gp.screenAltura/2;
		
		
		// colisão
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDefaultValues();
		getPlayerImage();
			
	}
	
	
	public void setDefaultValues()
	{
		worldX = gp.tileSize * 19 - (gp.tileSize/2); // onde o personagem vai spawnar
		worldY = gp.tileSize * 31 - (gp.tileSize/2); // onde o persongem vai spawnar
		speed = 4;
		Direction = "parado";
		
		vidaM = 5;
		vida = vidaM;
		level = 1;
		moeda = 0;
	}
	
	
	public void getPlayerImage()// tiles das animações do personagem
	{
		try 
		{
			// animação
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem baixo1.png"));
			baixo2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem baixo2.png"));
			cima1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem cima1.png"));
			cima2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem cima2.png"));
			costas = ImageIO.read(getClass().getResourceAsStream("/player/personagem costas.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem left2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/personagem left3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/personagem right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/personagem right2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/personagem right3.png"));
			parado = ImageIO.read(getClass().getResourceAsStream("/player/personagem parado.png"));
			
			
			// menu
			telainicio = ImageIO.read(getClass().getResourceAsStream("/menu/telainicio.PNG"));
			botaojogar = ImageIO.read(getClass().getResourceAsStream("/menu/botaojogar.png"));
			botaoopc = ImageIO.read(getClass().getResourceAsStream("/menu/botaoopc.png"));
			botaosair = ImageIO.read(getClass().getResourceAsStream("/menu/botaosair.png"));
			botaoCarregar = ImageIO.read(getClass().getResourceAsStream("/menu/botaoCarregar.png"));
			menufundo = ImageIO.read(getClass().getResourceAsStream("/menu/menufundo.png"));
			
			
			// inventario
			inventario = ImageIO.read(getClass().getResourceAsStream("/menu/Inventario.png"));
			
			// menu Pausado
			
			menu2 = ImageIO.read(getClass().getResourceAsStream("/menu/menu2.png"));
			botaosalvar = ImageIO.read(getClass().getResourceAsStream("/menu/botaosalvar.png"));
			botaoteclas = ImageIO.read(getClass().getResourceAsStream("/menu/botaoteclas.png"));
		
		}
		
		catch(IOException e ) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void Update()
	{
		
		if(KeyH.cima == true || KeyH.baixo == true || KeyH.esquerda == true || KeyH.direita == true || KeyH.pressEnter == true)
		{
			
			// movimentação do personagem
			if(KeyH.cima == true)
			{
				Direction = "cima";
				
			}
			
			else if(KeyH.baixo == true)
			{
				Direction = "baixo";
				
			}
			
			else if(KeyH.esquerda == true)
			{
				Direction = "left";
				
			}
			
			else if(KeyH.direita == true)
			{
				Direction = "right";
				
			}	
			
			// Checar a colisão
			colisionOn = false;
			gp.cColisao.checarTile(this);
			
			
			// colisao npc
			int npcIndex = gp.cColisao.cEntidade(this, gp.npc);
			interacaoNpc(npcIndex);
			
			
			
			
			// se não colidir o personagem pode andar
			if(colisionOn == false && KeyH.pressEnter == false)
			{
				switch(Direction)
				{
				case "cima":
				worldY = worldY - speed;
					break;
					
				case "baixo":
				worldY = worldY + speed;
					break;
						
				case "left":
					worldX = worldX - speed;
					
						break;	
						
				case "right":
					worldX = worldX + speed;
					break;				
					
				}
			}
			
			gp.KeyH.pressEnter = false;
			
			
			// looping para animação das pixels arts
			spriteCont++;
			if(spriteCont > 15 )//velocidade
			{
				if(spriteNum == 1)
				{
					spriteNum = 2;
				}
				else if(spriteNum == 2)
				{
					spriteNum = 1;
				}
				spriteCont = 0;
			}
						
			
		}
		
		
		
	}
	
	
	public void interacaoNpc(int i)
	{
		if(i != 999)
		{
			if(gp.KeyH.pressEnter == true)// parar npc no dialogo
			{
				gp.gameState = gp.dialogoState;
				gp.npc[i].fala();
			}
			
		}	
		
	}
	
	
	
	public void Draw(Graphics2D g2)
	{
		
	//	g2.setColor(Color.white);		
	//	g2.fillRect(x, y, gp.tileSize, gp.tileSize); // (x, y, largura, altura)
		
		BufferedImage Image = null;
		
		switch (Direction)
		{
		
		case "parado":
			Image = parado;
			break;
		
		case "cima":
			if(spriteNum == 1)
			{
				Image = cima1;
			}
			if(spriteNum == 2)
			{
				Image = cima2;
			}
			break;
			
		case "baixo":
			if(spriteNum == 1)
			{
				Image = baixo1;
			}
			if(spriteNum == 2)
			{
				Image = baixo2;
			}
			break;
			
		case "left":
			if(spriteNum == 1)
			{
				Image = left1;
			}
			if(spriteNum == 2)
			{
				Image = left2;
			}
			
			break;
			
		case "right":
			if(spriteNum == 1)
			{
				Image = right1;
			}
			if(spriteNum == 2)
			{
				Image = right2;
			}
			break;		
		}
		
		g2.drawImage(Image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
		
	}

}
