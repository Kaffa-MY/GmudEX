/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����DummyWindow.java <p>
 * ����ʱ�䣺2013-7-30 ����1:44:18 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.ui.core.GmudWindow;

/**
 * ������DummyWindow <p>
 * ˵����
 * @author 12548
 */
public class DummyWindow extends GmudWindow {


	public DummyWindow(GmudGame game) {
		super(game, 0, 0, GameConstants.FBWIDTH, GameConstants.FBHEIGHT);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		// do nothing
	}

}
