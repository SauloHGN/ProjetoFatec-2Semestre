package main;

import entidade.Enpc;
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
		gp.npc[0] = new Enpc(gp);
		gp.npc[0].worldX = gp.tileSize*19;
		gp.npc[0].worldY = gp.tileSize*15;
	}	
	
	public void Itens()
	{
		gp.obj[0] = new Moeda(gp);
		gp.obj[0].worldX = gp.tileSize*4;
		gp.obj[0].worldY = gp.tileSize*27; 
		
		gp.obj[1] = new Livro();
		gp.obj[1].worldX = gp.tileSize*8;
		gp.obj[1].worldY = gp.tileSize*27;
		
	}
	
	
}
