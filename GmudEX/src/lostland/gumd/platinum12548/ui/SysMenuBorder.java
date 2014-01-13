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
public class SysMenuBorder extends GmudWindow {

	
	public static final int TOP = 5;
	public static final int LEFT = 110;
	public static final int HEIGHT = SysMenuButton.HEIGHT * 5 + SysMenuButton.MARGIN_TOP * 6 + 2;
	public static final int WIDTH = SysMenuButton.WIDTH + SysMenuButton.MARGIN_LEFT + 4;
	
	public SysMenuBorder(GmudGame game)
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
