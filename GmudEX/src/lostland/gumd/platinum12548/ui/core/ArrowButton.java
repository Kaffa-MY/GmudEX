/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ArrowButton.java <p>
 * ����ʱ�䣺2013-7-22 ����2:27:52 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.Assets;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;

/**
 * ������ArrowButton <p>
 * ˵������ť���࣬������߿򻻳��˼�ͷ��~
 * @author 12548
 */
public abstract class ArrowButton extends GmudWindow {

	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public ArrowButton(GmudGame game, int x, int y, int width, int height) {
		super(game, x, y, width, height);
		// TODO �Զ����ɵĹ��캯�����
	}

	protected int padding_top;
	
	@Override
	protected void drawBackground()
	{
		BLGGraphics g =(BLGGraphics) game.getGraphics();
//		g.drawRect(x+1, y+1, width-1, height-1, GameConstants.BG_COLOR);
		if(bordered)
			g.drawPixmap(Assets.arrow, this.x + 1, this.y + padding_top + 2);
	}
}
