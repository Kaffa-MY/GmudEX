/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����Tileset.java <p>
 * ����ʱ�䣺2013-5-20 ����4:16:12 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.blgframework.impl.BLGPixmap;

/**
 * ������Tileset <p>
 * ˵����
 * @author 12548
 */
public abstract class Tileset {
	BLGPixmap pixmap;
	int tileWidth;
	int tileHeight;
	
	/**
	 * @param pixmap
	 * @param tileWidth
	 * @param tileHeight
	 */
	public Tileset(BLGPixmap pixmap, int tileWidth, int tileHeight) {
		this.pixmap = pixmap;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	/**
	 * @return pixmap
	 */
	public BLGPixmap getPixmap() {
		return pixmap;
	}

	/**
	 * @return tileWidth
	 */
	public int getTileWidth() {
		return tileWidth;
	}

	/**
	 * @return tileHeight
	 */
	public int getTileHeight() {
		return tileHeight;
	}
	
	/**
	 * ע�⣺srcX��srcYΪҪ����tile����tileset�е����꣨��0��ʼ����
	 */
	public void draw(BLGGraphics g,int x,int y, int srcX,int srcY)
	{
		g.drawPixmap(pixmap, x, y, srcX*tileWidth, srcY*tileHeight, tileWidth+1, tileHeight+1);
	}
	
}
