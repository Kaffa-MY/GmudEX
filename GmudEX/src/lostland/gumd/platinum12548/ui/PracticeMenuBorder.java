/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SysMenuBorder.java <p>
 * ����ʱ�䣺2013-7-21 ����1:51:07 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.ui.core.GmudWindow;

/**
 * ������SysMenuBorder <p>
 * ˵����ϵͳ�˵��߽�
 * @author 12548
 */
public class PracticeMenuBorder extends GmudWindow {

	
	public static final int TOP = 5;
	public static final int LEFT = 100;
	public static final int HEIGHT = PracticeMenuButton.HEIGHT *3 + PracticeMenuButton.MARGIN_TOP * 5+2;
	public static final int WIDTH = PracticeMenuButton.WIDTH + PracticeMenuButton.MARGIN_LEFT +4;
	
	public PracticeMenuBorder(GmudGame game)
	{
		super(game,LEFT,TOP,WIDTH,HEIGHT);
	}
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		this.drawBackground();
	}

}
