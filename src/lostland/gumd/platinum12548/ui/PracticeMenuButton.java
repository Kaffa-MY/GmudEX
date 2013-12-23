/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SysMenuButton.java <p>
 * ����ʱ�䣺2013-7-21 ����2:31:30 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.ArrowButton;

/**
 * ������SysMenuButton <p>
 * ˵����
 * @author 12548
 */
public class PracticeMenuButton extends ArrowButton {

	public static final int MARGIN_TOP = 1;
	public static final int MARGIN_LEFT = 1;
	static final int PADDING_LEFT = 11;
	static final int PADDING_TOP = 1;
	
	public static final int TOP = PracticeMenuBorder.TOP + MARGIN_TOP;
	public static final int LEFT = PracticeMenuBorder.LEFT + MARGIN_LEFT;
	public static final int WIDTH = 70;
	public static final int HEIGHT = 14;
	
	public int item;
	
	int index;
	public PracticeMenuButton(GmudGame game, int index,int item)
	{
		super(game, LEFT, TOP + index * ( HEIGHT + MARGIN_TOP ), WIDTH, HEIGHT);
		this.index = index;
		this.bordered = false;
		this.padding_top = PADDING_TOP;
		this.item = item;
	}
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		this.drawBackground();
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		g.drawText(GmudWorld.skill[GmudWorld.mc.skillsckd[item]].name, x + PADDING_LEFT, y + PADDING_TOP,FontSize.FT_12PX);
	}

}
