/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MainMenuBorder.java <p>
 * ����ʱ�䣺2013-6-30 ����10:23:49 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.ui.core.GmudWindow;

/**
 * ������MainMenuBorder <p>
 * ˵�������˵��ı߽硣
 * @author 12548
 */
public class MainMenuBorder extends GmudWindow {
	
	public final static int HEIGHT = 20;
	
	public MainMenuBorder(GmudGame game)
	{
		super(game, 0, 0, GameConstants.FBWIDTH+1, HEIGHT);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		drawBackground();
	}

}
