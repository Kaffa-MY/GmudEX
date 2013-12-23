/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MapTile.java <p>
 * ����ʱ�䣺2013-5-21 ����12:23:50 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.blgframework.impl.BLGPixmap;
import android.util.Log;


/**
 * ������MapTile <p>
 * ˵����
 * @author 12548
 */
@SuppressWarnings("unused")
public class MapTile extends Tileset {

	public final static int TILE_WIDTH=32;
	
	private GmudGame game;
	
	/**
	 * ��Ҫʹ��������캯����
	 */
	public MapTile(BLGPixmap pixmap, int tileWidth, int tileHeight) {
		super(pixmap, tileWidth, tileHeight);
	}
	
	public MapTile(GmudGame game)
	{
		super((BLGPixmap) Assets.mapTile,TILE_WIDTH,TILE_WIDTH);
		this.game=game;
	}
	
	/**
	 * @param x ��0��4��������
	 * @param y ��0��2��������
	 * @param srcX ��0��7��������
	 * @param srcY ��0��63��������
	 */
	public void draw(int x,int y ,int srcX,int srcY)
	{
		super.draw((BLGGraphics) game.getGraphics(), x*TILE_WIDTH, y*TILE_WIDTH, srcX, srcY);
	}
	
	public void drawBiased(int x,int y,int srcX,int srcY,int dx,int dy)
	{
		super.draw((BLGGraphics) game.getGraphics(), x*TILE_WIDTH+dx, y*TILE_WIDTH+dy, srcX,srcY);
	}
	
	public void drawMap(GmudMap map,int mapX,int mapY)
	{
		int i,j,k;
		for(i=0;i<3;i++)
		{
			for(j=0;j<MapScreen.C_ROWS;j++)
				for(k=0;k<MapScreen.C_COLUMNS;k++)
					if(map.getTileX(i, j+mapX, k+mapY)>-1 && map.getTileY(i, j+mapX, k+mapY)>-1)
					{
						//Log.v("drawMap:","drawing:screen("+j+","+k+")is tile("+map.getTileX(i, j+mapX, k+mapY)+","+map.getTileY(i, j+mapX, k+mapY)+")in layer"+i);
						this.draw(j,k,map.getTileX(i, j+mapX, k+mapY),map.getTileY(i, j+mapX, k+mapY));
					}
		}
		for(j=0;j<MapScreen.C_ROWS;j++)
			for(k=0;k<MapScreen.C_COLUMNS;k++)
				if(map.getWalkable(j+mapX, k+mapY)==GmudMap.MP_NPC)
					GmudWorld.npcc.draw(j, k, map.getEvent(j+mapX, k+mapY));
	}

	public void drawMapWalking(GmudMap map,int x,int y,int dx,int dy)
	{
		int i,j,k;
		for(i=0;i<3;i++)
			for(j=-1;j<=MapScreen.C_ROWS;j++)
				for(k=-1;k<=MapScreen.C_COLUMNS;k++)
					if(map.getTileX(i, j+x, k+y)>-1 && map.getTileY(i, j+x, k+y)>-1)
						this.drawBiased(j, k, map.getTileX(i, j+x,k+y), map.getTileY(i, j+x, k+y), dx, dy);
		for(j=-1;j<=MapScreen.C_ROWS;j++)
			for(k=-1;k<=MapScreen.C_COLUMNS;k++)
				if(map.getWalkable(j+x, k+y)==GmudMap.MP_NPC)
					GmudWorld.npcc.drawBiased(j, k, dx, dy, map.getEvent(j+x, k+y));
	}
}
