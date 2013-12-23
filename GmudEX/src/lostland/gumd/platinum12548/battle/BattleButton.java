/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BattleButton.java <p>
 * ����ʱ�䣺2013-7-29 ����3:53:16 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle;

import lostland.gumd.platinum12548.Assets;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.GmudWindow;

/**
 * ������BattleButton <p>
 * ˵����
 * @author 12548
 */
public class BattleButton extends GmudWindow {

	public static int X = 130;
	public static int Y = 96;
	
	public static int dx = -2;
	public static int dy = 13;
	
	protected String text[] ={"����", "����","����","��Ʒ","����"};
	
	public int index;
	public BattleButton(GmudGame game, int index) {
		super(game, X + index * 12, Y, 12, 12);
		this.index = index;
	}

	
	
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		if(this.bordered)
		{
			g.drawPixmap(Assets.filled, x, y);
			g.drawText(text[index], x+dx, Y+dy, FontSize.FT_12PX);
		}
		else
		{
			g.drawPixmap(Assets.empty, x, y);
		}
	}

}
