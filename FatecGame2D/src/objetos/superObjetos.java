package objetos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePainel;

public class superObjetos 
{
public BufferedImage Image, Image1, Image2, Image3, Image4, Image5;
public String name;
public boolean colision = false;
public int worldX, worldY;
public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
public int solidAreaDefaultX = 0;
public int solidAreaDefaultY = 0;

public void draw(Graphics2D g2, GamePainel gp)
{
	int screenX = worldX - gp.player.worldX + gp.player.screenX;
	int screenY = worldY - gp.player.worldY + gp.player.screenY;
	

	if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
	   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
	   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
	   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
	{
		g2.drawImage(Image, screenX+5, screenY+5, gp.tileSize-10, gp.tileSize-10, null);
	}
	
	
}

}
