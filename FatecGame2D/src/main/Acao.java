package main;

import java.awt.Rectangle;

public class Acao 
{
	GamePainel gp;
	Rectangle checarAcao;
	int defaultAcaoX, defaultAcaoY;
	
	public int v[] = new int[3];
	
	
	public Acao(GamePainel gp)
	{
		this.gp = gp;
		
		checarAcao = new Rectangle();
		checarAcao.x = 23;
		checarAcao.y = 23;
		checarAcao.width = 8;
		checarAcao.height = 2;
		
		defaultAcaoX = checarAcao.x;
		defaultAcaoY = checarAcao.y;
	}
	
	
	public void verificarAcao()
	{
		//Escada
		if(trigger(38,19,"baixo") == true || trigger(39,19,"baixo") == true || trigger(40,19,"baixo") == true || trigger(41,19,"baixo") == true)
		{
			aviso(gp.dialogoState);
		}
		//Senha + entrar na sala
		if(trigger(25,13,"cima") == true ||trigger(24,13,"cima") == true /*&& gp.player.level >= 2*/)
		{
			gp.gameState = gp.senhaState;
			
			if(gp.KeyH.password == true)
			{
				teleporte(gp.dialogoState);
			}
			
		}
		// Sair da sala
		if(trigger(96,21,"baixo") == true)
		{
			teleporteVolta(gp.dialogoState);
		}
		// porta de vidro 
		if(trigger(14,3,"cima") == true || trigger(13,3,"cima") == true)
		{
			teleporteLopping();
		}
		// mensagem na entrada
		/*if(gp.player.level == 0)
		{
			if(trigger(19,32,"cima") == true || trigger(18,32,"cima") == true || trigger(17,32,"cima") == true) 
			{
				gp.player.level = 1;
				aviso2(gp.dialogoState);
			}
		}*/
		
	}
	
	public boolean trigger(int AcaoColuna, int AcaoLinha, String DirectionAcao)
	{
		boolean trigger = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		checarAcao.x  = AcaoColuna*gp.tileSize + checarAcao.x;
		checarAcao.y  = AcaoLinha*gp.tileSize + checarAcao.y;
		
		
		if(gp.player.solidArea.intersects(checarAcao))
		{
			if(gp.player.Direction.contentEquals(DirectionAcao) || DirectionAcao.contentEquals("any"))
			{
				trigger = true;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		
		checarAcao.x = defaultAcaoX;
		checarAcao.y = defaultAcaoY;
		
		return trigger;
	}
	
	public void aviso(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Você não tem nível suficiente \n para avançar";
		
		
	}
	
	public void aviso2(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Seja Bem-vindo à Fatec Cruzeiro!\n Temos os melhores cursos de \n graduação da região...";
		
	}
	
	public void teleporte(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Entrou na sala";
		gp.player.worldX = gp.tileSize*96;
		gp.player.worldY = gp.tileSize*21;
	}
	
	public void teleporteVolta(int gameState)
	{
		gp.gameState = gameState;
		gp.ui.conversa = "Saiu da sala";
		gp.player.worldX = gp.tileSize*25;
		gp.player.worldY = gp.tileSize*13;
	}
	
	public void teleporteLopping()
	{
		gp.player.worldX = gp.tileSize*18;
		gp.player.worldY = gp.tileSize*33;
	}
	
}