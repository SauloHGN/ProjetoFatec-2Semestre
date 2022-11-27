package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeys implements KeyListener
{
	GamePainel gp;
	public boolean cima, baixo, esquerda, direita;
	public boolean pressEnter;
	
	public boolean loc = false;
	
	
	public InputKeys(GamePainel gp)
	{
		this.gp = gp;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		// Menu State
		if(gp.gameState == gp.menuState)
		{
			
			menuState(code);
		}
							
		// play State
		else if(gp.gameState == gp.playState)
		{
			playState(code);
		
		}				
		
		// pause State
		else if(gp.gameState == gp.pauseState)
		{
			pauseState(code);
		}
		
		// Dialogo state
		else if(gp.gameState == gp.dialogoState)
		{
			dialogoState(code);
		}
		
		// inventario State
		
		else if(gp.gameState == gp.inventarioState)
		{
			inventarioState(code);
			
		}
		
		
		
	}

	
	public void menuState(int code)
	{
		if(code == KeyEvent.VK_W)
		{
			gp.ui.comandoN--;
			
			if(gp.ui.comandoN < 0)
			{
				gp.ui.comandoN = 2;
			}
		}
		
		if(code == KeyEvent.VK_S)
		{
			gp.ui.comandoN++;
			
			if(gp.ui.comandoN > 2)
			{
				gp.ui.comandoN = 0;
			}
		}
		
		if(code == KeyEvent.VK_ENTER)
		{
			
			if(gp.ui.comandoN == 0)
			{
				gp.gameState = gp.playState;	
			}
			
			if(gp.ui.comandoN == 1)
			{
				gp.conexao.getConnection(gp);
			}
			
			if(gp.ui.comandoN == 2)
			{
				System.exit(0);
			}
		}
	}
	
	public void playState(int code)
	{
		
		if(code == KeyEvent.VK_W)
		{
			cima = true;
		}
	
		if(code == KeyEvent.VK_S)
		{
			baixo = true;
		}
	
		if(code == KeyEvent.VK_A)
		{
			esquerda = true;
		}
	
		if(code == KeyEvent.VK_D)
		{
			direita = true;
		}
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			
			gp.gameState = gp.pauseState;
							
		}
		
		if(code == KeyEvent.VK_ENTER)
		{
			pressEnter = true;		
		
		}
		
		if(code == KeyEvent.VK_I)
		{
				
			gp.gameState = gp.inventarioState;
			
		}
		
		if(code == KeyEvent.VK_9)
		{
				if(loc == false)
				{
					loc = true;
				}
				else if(loc == true)
				{
					loc = false;
				}		
		}
		
		if(code == KeyEvent.VK_8)
		{
			gp.tileM.LoadMapa("/mapas/mapa1.txt");
		}
		
		
	}
	
	public void pauseState(int code)
	{
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			
			gp.gameState = gp.playState;					
				
		}
		
		if(code == KeyEvent.VK_W)
		{
			gp.ui.comandoM--;
			
			if(gp.ui.comandoM < 0)
			{
				gp.ui.comandoM = 2;
			}
		}
		
		if(code == KeyEvent.VK_S)
		{
			gp.ui.comandoM++;
			
			if(gp.ui.comandoM > 2)
			{
				gp.ui.comandoM = 0;
			}
		}
		
		if(code == KeyEvent.VK_ENTER)
		{
			
			if(gp.ui.comandoM == 0)
			{
				gp.conexao.getConnection(gp);
				gp.saveload.Salvar(gp);
			}
			
			if(gp.ui.comandoM == 1)
			{
				
			}
			
			if(gp.ui.comandoM == 2)
			{
				System.exit(0);
			}
		}
		
		
	}
	
	public void dialogoState(int code)
	{
		
		if(code == KeyEvent.VK_ENTER)
		{
			gp.gameState = gp.playState;
		}
	}
	
	public void inventarioState(int code)
	{
		
		if(code == KeyEvent.VK_I)
		{
			
			gp.gameState = gp.playState;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W)
		{
			cima = false;
		}
		
		if(code == KeyEvent.VK_S)
		{
			baixo = false;
		}
		
		if(code == KeyEvent.VK_A)
		{
			esquerda = false;
		}
		
		if(code == KeyEvent.VK_D)
		{
			direita = false;
		}
		
	}

}
