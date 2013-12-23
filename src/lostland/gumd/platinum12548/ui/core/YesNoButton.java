/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����YesNoButton.java <p>
 * ����ʱ�䣺2013-8-24 ����4:58:28 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;

/**
 * ������YesNoButton <p>
 * ˵����
 * @author 12548
 */
public class YesNoButton extends ArrowButton {

	int index;
	String S[] = {"��","��"};
	
	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public YesNoButton(GmudGame game,int index) {
		super(game, 26, 27 + index *12, 24, 13);
		this.index = index;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		this.drawBackground();
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		g.drawText(S[index], x  + 12, y ,FontSize.FT_12PX);
	}

}
