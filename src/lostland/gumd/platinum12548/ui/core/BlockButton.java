/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BlockButton.java <p>
 * ����ʱ�䣺2013-7-23 ����5:52:35 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.Assets;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;

/**
 * ������BlockButton <p>
 * ˵����
 * @author 12548
 */
public abstract class BlockButton extends GmudWindow {

	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public BlockButton(GmudGame game, int x, int y, int width, int height) {
		super(game, x, y, width, height);
		// TODO �Զ����ɵĹ��캯�����
	}


	@Override
	protected void drawBackground()
	{
		BLGGraphics g =(BLGGraphics) game.getGraphics();
//		g.drawRect(x, y, width, height, GameConstants.BG_COLOR);
		if(bordered)
			g.drawPixmap(Assets.filled, x, y);
		else
			g.drawPixmap(Assets.empty, x, y);
	}

}
