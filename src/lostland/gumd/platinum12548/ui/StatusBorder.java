/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����StatusBorder.java <p>
 * ����ʱ�䣺2013-8-13 ����3:24:43 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.ui.core.GmudWindow;

/**
 * ������StatusBorder <p>
 * ˵����
 * @author 12548
 */
public class StatusBorder extends GmudWindow {

	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StatusBorder(GmudGame game) {
		super(game, GameConstants.FBWIDTH/2 - 75, GameConstants.FBHEIGHT/2 - 38, 150, 76);
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		this.drawBackground();
	}

}
