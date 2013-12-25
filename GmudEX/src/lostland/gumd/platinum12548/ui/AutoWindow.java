/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����AutoWindow.java <p>
 * ����ʱ�䣺2013-12-22 ����10:36:09 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.GmudWindow;

/**
 * ������AutoWindow <p>
 * ˵����
 * @author 12548
 */
public class AutoWindow extends GmudWindow {

	public String text;
	
	
	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public AutoWindow(GmudGame game, int x, int y, int width, int height,String text) {
		super(game, x, y, width, height);
		this.text = text;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		this.drawBackground();
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		g.drawText(text, x+1, y+1, FontSize.FT_12PX, width - 2); 
	}
}
