package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;

import objetos.barraVida;

import objetos.superObjetos;

public class UI 
{
	GamePainel gp;
	Graphics2D g2;
	Font  arial_40, RetroGaming;
	
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String conversa = "";
	
	// imagem da barra de vida
	BufferedImage Vida1, Vida2, Vida3, Vida4, Vida5;
	
	// Imagem inventario
	
	
	// menu inicio
	public int comandoN = 0;
	
	// menu pausa
	public int comandoM = 0;
	
	// senha
	public int comandoS = 1;
	
	// Resposta
	public int comandoR = 1;
	
	// Resposta 2
	public int comandoR2 = 1;
	 
	
	
	public UI(GamePainel gp)
	{
		this.gp = gp;
		
		try {	
		InputStream is = getClass().getResourceAsStream("/font/RETRO GAMING.TTF");
		RetroGaming = Font.createFont(Font.TRUETYPE_FONT, is);
		
		}
		catch(FontFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		superObjetos Vida = new barraVida(gp);
		Vida1 = Vida.Image1;
		Vida2 = Vida.Image2;
		Vida3 = Vida.Image3;
		Vida4 = Vida.Image4;
		Vida5 = Vida.Image5;
		
		
		
		
		
	}
	
	
	public void showMessage(String text) 
	{
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2)
	{
		this.g2 = g2;
			
		g2.setFont(RetroGaming);
		g2.setColor(Color.white);
		
		
		// Menu
		if(gp.gameState == gp.menuState)
		{
			drawMenuScreen();
		}
		
		// Play
		if(gp.gameState == gp.playState)
		{
			drawVida();
		}
		// Pause
		if(gp.gameState == gp.pauseState)
		{
			drawPauseScreen();
			drawVida();
		
		}	
		// dialogo
		if(gp.gameState == gp.dialogoState)
		{
			drawVida();
			drawDialogo();
		}
		// inventario
		if(gp.gameState == gp.inventarioState)
		{
			drawInventario();
			
		}
		//senha 
		if(gp.gameState == gp.senhaState)
		{
			drawSenha();
			
		}
		// battle 
		if(gp.gameState == gp.battleState)
		{
			drawBattle();
		}
		
		// resposta
		if(gp.gameState == gp.respostaState)
		{
			drawResposta();
		}
		// resposta 2
		if(gp.gameState == gp.respostaState2)
		{
			drawResposta2();
		}
		if(gp.gameState == gp.teclaState)
		{
			drawTeclas();
		}
		
	}
	
	public void drawMenuScreen()
	{
			// Background
			//g2.setColor(new Color(0,0,0)); // cor de fundo
			//g2.fillRect(0, 0, gp.screenLargura, gp.screenAltura);		
			g2.drawImage(gp.player.menufundo, 0, 0, gp.screenLargura, gp.screenAltura, null); // imagem de fundo
					
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,65F));
			String text = "Fatec Chronicles";
			
			int x = textoCentralizado(text);
			int y = gp.tileSize*1 +30;
			
			//sombra
			g2.setColor(Color.gray);
			g2.drawString(text, x+5, y+5);
			
			// cor da fonte
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			
			// Imagens botão
			x = textoCentralizado(text)+130;
			y = y +gp.tileSize*2;
			
			g2.drawImage(gp.player.botaojogar, x+115, y-10, gp.tileSize*4, gp.tileSize*2, null);
			if(comandoN == 0)
			{
				g2.drawString(">", (x-gp.tileSize)+ 80, y+60);
			}
			
			
			g2.drawImage(gp.player.botaoCarregar, x+115, y+100, gp.tileSize*4, gp.tileSize*2, null);
			if(comandoN == 1)
			{
				g2.drawString(">", (x-gp.tileSize)+80, y+170);
			}
			
			
			g2.drawImage(gp.player.botaosair, x+115, y+210, gp.tileSize*4, gp.tileSize*2, null);
			if(comandoN == 2)
			{
				g2.drawString(">", (x-gp.tileSize)+ 80, y+280);
			}
		
	}
	
	public void drawPauseScreen()
	{
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
		/*String text = "Jogo Pausado";
		int x = textoCentralizado(text);
		int y = gp.screenAltura/2;	
		g2.drawString(text, x, y);*/
		
		
		int x = 0;
		int y = 0;
		
		// desenha o fundo do menu 2
		g2.drawImage(gp.player.menu2, x+183, y+40, 400, 500, null);
		
		
		// botoes do menu 2
		x = (gp.screenLargura/2)-140;
		y = y + (gp.tileSize*4)-20;
		
		g2.drawImage(gp.player.botaosalvar, x+50, y-10, gp.tileSize*4, gp.tileSize*2, null);
		if(comandoM == 0)
		{
			g2.drawString(">", x-10, y+50);
		}
		
		
		g2.drawImage(gp.player.botaoteclas, x+50, y+100, gp.tileSize*4, gp.tileSize*2, null);
		if(comandoM == 1)
		{
			g2.drawString(">", x-10, y+150);
		}
		
		
		g2.drawImage(gp.player.botaosair, x+50, y+210, gp.tileSize*4, gp.tileSize*2, null);
		if(comandoM == 2)
		{
			g2.drawString(">", x-10, y+270);
		}
		
		
	}
	
	public int textoCentralizado(String text)
	{
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenLargura/2 - lenght/2;
		
		return x;
	}
	
	public void drawDialogo()
	{
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
		
		int x = gp.tileSize*2;
		int y = gp.tileSize/2;
		int largura = gp.screenLargura - (gp.tileSize*4);
		int altura = gp.screenAltura - (gp.tileSize*8);
	
		drawJanela(x, y, largura, altura);// desenha a janela dos dialogos
		
		// loc dos dialogos
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String linha : conversa.split("\n"))
		{
			g2.drawString(linha, x, y);
			y = y + 40;
		}
		
	}
	
	public void drawJanela(int x, int y, int largura, int altura)
	{
		Color black = new Color(0,0,0,200);
		g2.setColor(black);
		g2.fillRoundRect(x, y, largura, altura, 35, 35);
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(x+5, y+5, largura-10, altura-10, 35, 35);
	}
	
	public void drawVida()
	{
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		
		if(gp.player.vida == 5)
		{
			g2.drawImage(Vida5, x, y, (gp.tileSize*4)+10, gp.tileSize +20, null);			
			
		}
		if(gp.player.vida == 4)	
		{
			g2.drawImage(Vida4, x, y, (gp.tileSize*4)+10, gp.tileSize +20, null);			
			
		}
		if(gp.player.vida == 3)
		{
			g2.drawImage(Vida3, x, y, (gp.tileSize*4)+10, gp.tileSize +20, null);			
			
		}
		if(gp.player.vida == 2)
		{
			g2.drawImage(Vida2, x, y, (gp.tileSize*4)+10, gp.tileSize +20, null);			
			
		}
		if(gp.player.vida == 1)
		{
			g2.drawImage(Vida1, x, y, (gp.tileSize*4)+10, gp.tileSize +20, null);			
			
		}
		
	}
	
	public void drawInventario()
	{
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
		
		g2.setColor(Color.white);
		
		
		// criar a janela
		final int janelaX = gp.tileSize*3;
		final int janelaY = gp.tileSize*2;
		final int janelaLargura = gp.tileSize*9;
		final int janelaAltura = gp.tileSize*10;
		
		
		
		g2.drawImage(gp.player.inventario, janelaX+25, janelaY-40, janelaLargura, janelaAltura+20, null);
		
		int textoX = janelaX + 65;
		int textoY = janelaY +gp.tileSize;
		final int alturaLinha = 32;
		
		// Status do jogador
		g2.drawString("Level:", textoX, textoY);
		textoY = textoY + alturaLinha;
		g2.drawString("Vida:", textoX, textoY);
		textoY = textoY + alturaLinha;
		g2.drawString("Moedas:", textoX, textoY);
		textoY = textoY + alturaLinha;
		
		// loc dos valores de vida, level, moedas ...
		int valorX = (janelaX + janelaLargura) -30;
		textoY = janelaY + gp.tileSize;
		String valores;
		
		// valores 
		valores = String.valueOf(gp.player.level);
		textoX = textoCentralizadoInventario(valores, valorX);
		g2.drawString(valores, textoX-220, textoY);
		textoY = textoY + alturaLinha;
		
		valores = String.valueOf(gp.player.vida);
		textoX = textoCentralizadoInventario(valores, valorX);
		g2.drawString(valores, textoX-230, textoY);
		textoY = textoY + alturaLinha;
		
		valores = String.valueOf(gp.player.moeda);
		textoX = textoCentralizadoInventario(valores, valorX);
		g2.drawString(valores, textoX-185, textoY);
		textoY = textoY + alturaLinha;
		
	
		int slotX = janelaX + 120;
		int slotY = janelaY + 200;
		
		// slot 1 = (265, 300, 48, 48, 10, 10)
		// slot 2 = (357, 300, 48, 48, 10, 10)
		// slot 3 = (452, 300, 48, 48, 10, 10)
		// slot 4 = (265, 385, 48, 48, 10, 10)
		// slot 5 = (357, 385, 48, 48, 10, 10)
		// slot 6 = (452, 385, 48, 48, 10, 10)
		
		// desenhar os itens no inventario
		for(int i = 0; i < gp.player.inventarioL.size(); i++)
		{
			//g2.drawImage(gp.player.iconeLivro, 265, 300, 48, 48, null);
			
			try
			{
				g2.drawImage(gp.player.inventarioL.get(i).baixo1, slotX, slotY, 48, 48, null);
			}
			catch(Exception e)
			{
				
			}
			
			slotX = slotX + 95;
			
			if(i == 2)
			{
				slotX = janelaX + 120;
				slotY = janelaY + 290;
			}
		}
			
			
		// inventario
	}
	
	public void drawSenha()
	{
		//desenhar janela
		final int janelaX = gp.tileSize*3;
		final int janelaY = gp.tileSize*2;
		final int janelaLargura = gp.tileSize*9;
		final int janelaAltura = gp.tileSize*10;
		g2.drawImage(gp.player.senha, janelaX+25, janelaY-40, janelaLargura, janelaAltura+20, null);
		
		//
		final int startLinha = 0;
		final int startColuna = 0;
		int linhaS = startLinha;
		int colunaS = startColuna;
		
		//
		int cursorX = startLinha + (gp.tileSize* linhaS)+235;
		int cursorY = startColuna +(gp.tileSize* colunaS)+205;
		//
		int largura = gp.screenLargura - (gp.tileSize*4);
		int altura = gp.screenAltura - (gp.tileSize*8);
				
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(4));
		
		
		if(comandoS == 1)
		{
			g2.drawRoundRect(cursorX, cursorY, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 2)
		{
			g2.drawRoundRect(cursorX+85, cursorY, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 3)
		{
			g2.drawRoundRect(cursorX+170, cursorY, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 4)
		{
			g2.drawRoundRect(cursorX+255, cursorY, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 5)
		{
			g2.drawRoundRect(cursorX+5, cursorY+65, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 6)
		{
			g2.drawRoundRect(cursorX+85, cursorY+65, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 7)
		{
			g2.drawRoundRect(cursorX+170, cursorY+65, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 8)
		{
			g2.drawRoundRect(cursorX+255, cursorY+65, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 9)
		{
			g2.drawRoundRect(cursorX+5, cursorY+130, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 10)
		{
			g2.drawRoundRect(cursorX+85, cursorY+130, largura-520, altura-140, 10, 10);
		}
		if(comandoS == 11)
		{
			g2.drawRoundRect(cursorX+47, cursorY+232, largura-510, altura-125, 10, 10);
		}
		if(comandoS == 12)
		{
			g2.drawRoundRect(cursorX+177, cursorY+232, largura-510, altura-125, 10, 10);
		}
		
	
	}
	
	public void drawBattle()
	{
		//g2.drawImage(gp.player.batalhaFundo, 0, 0, gp.screenLargura, gp.screenAltura, null);
                g2.drawImage(gp.player.botaoLv, 10, 500, 150, 50, null);
                g2.drawImage(gp.player.botaoPontos, 220, 500, 250, 50, null);
                g2.drawImage(gp.player.botaoBatalha, 500, 500 , 250, 50, null);
                g2.drawImage(gp.player.Arena, 120 ,230, 520, 240, null);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,35F));
		g2.setColor(Color.white);
		
		String valores;
		
		valores = String.valueOf(gp.player.level);
		g2.drawString(valores, 107, 540);
		
		valores = String.valueOf(gp.player.pontos);
		g2.drawString(valores, 385, 540);
		
	}
	
	public void drawResposta()
	{
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
		
		int x = gp.tileSize*2;
		int y = gp.tileSize/2;
		int largura = gp.screenLargura - (gp.tileSize*4);
		int altura = gp.screenAltura - (gp.tileSize*3);
	
		drawJanela(x, y, largura, altura);// desenha a janela dos dialogos
		
		// loc dos dialogos
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String linha : conversa.split("\n"))
		{
			g2.drawString(linha, x, y);
			y = y + 40;
		}
		
		if(comandoR == 1)
		{
			g2.drawString(">", 110, 270);
		}
		if(comandoR == 2)
		{
			g2.drawString(">", 110, 350);
			
		}
		if(comandoR == 3)
		{
			g2.drawString(">", 110, 430);
		}	
	}
	
	public void drawResposta2()
	{
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
		
		int x = gp.tileSize*2;
		int y = gp.tileSize/2;
		int largura = gp.screenLargura - (gp.tileSize*4);
		int altura = gp.screenAltura - (gp.tileSize*3);
	
		drawJanela(x, y, largura, altura);// desenha a janela dos dialogos
		
		// loc dos dialogos
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String linha : conversa.split("\n"))
		{
			g2.drawString(linha, x, y);
			y = y + 40;
		}
		
		if(comandoR2 == 1)
		{
			g2.drawString(">", 110, 270);
		}
		if(comandoR2 == 2)
		{
			g2.drawString(">", 110, 350);
			
		}
		if(comandoR2 == 3)
		{
			g2.drawString(">", 110, 430);
		}	
	}
	
	public void drawTeclas()
	{
		g2.drawImage(gp.player.teclas, 0, 0, gp.screenLargura, gp.screenAltura, null);
	}
	
	public int textoCentralizadoInventario(String text, int valorX)
	{
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = valorX - lenght;
		
		return x;
	}	
	
}
