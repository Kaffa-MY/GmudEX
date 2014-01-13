/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����AutoButton.java <p>
 * ����ʱ�䣺2013-12-22 ����5:46:54 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.ArrowButton;

/**
 * ������AutoButton <p>
 * ˵����
 * @author 12548
 */
public class AutoButton extends ArrowButton {

	
	String s;
	

	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public AutoButton(GmudGame game, int x, int y, String s) {
		super(game, x, y, s.length() * 12 + 10, 12);
		this.s = s;
		this.padding_top = 0;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		
		drawBackground();
		BLGGraphics  g = (BLGGraphics) game.getGraphics();
		
		g.draw2Text(s, x + 10, y, FontSize.FT_12PX);

	}

	/**
	 * @return s
	 */
	public String getS() {
		return s;
	}

	/**
	 * @param s Ҫ���õ� s
	 */
	public void setS(String s) {
		this.s = s;
	}

}
