package main;

import entidade.Enpc;
import entidade.LigiaNPC;
import entidade.EuNPC;
import objetos.Livro;
import objetos.Moeda;

public class setAssets 
{

	GamePainel gp;
	
	public setAssets(GamePainel gp)
	{
		this.gp = gp;
	}
	
	
	
	public void setNpc()
	{
		int i = 0;
		
		gp.npc[i] = new Enpc(gp);
		gp.npc[i].worldX = gp.tileSize*13;
		gp.npc[i].worldY = gp.tileSize*26;
		i++;
		
		gp.npc[i] = new LigiaNPC(gp);
		gp.npc[i].worldX = gp.tileSize*18;
		gp.npc[i].worldY = gp.tileSize*26;
		i++;
		
		gp.npc[i] = new EuNPC(gp);
		gp.npc[i].worldX = gp.tileSize*16;
		gp.npc[i].worldY = gp.tileSize*26;
		
	}	
	
	public void Itens()
	{
		int i = 0;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*4;
		gp.obj[i].worldY = gp.tileSize*27; 
		i++;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*4;
		gp.obj[i].worldY = gp.tileSize*24; 
		i++;
		
		gp.obj[i] = new Moeda(gp);
		gp.obj[i].worldX = gp.tileSize*8;
		gp.obj[i].worldY = gp.tileSize*24; 
		i++;
		
		gp.obj[i] = new Livro(gp);
		gp.obj[i].worldX = gp.tileSize*8;
		gp.obj[i].worldY = gp.tileSize*27;
		i++;
		
	}
	
	
}
