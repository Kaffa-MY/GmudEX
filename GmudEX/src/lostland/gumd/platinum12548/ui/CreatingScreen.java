/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����CreatingScreen.java <p>
 * ����ʱ�䣺2013-12-25 ����8:14:41 <p>
 * ������Ŀ��GmudEX <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.MenuScreen;

/**
 * ������CreatingScreen <p>
 * ˵����
 * @author 12548
 */
public class CreatingScreen extends MenuScreen {

	
	AutoWindow border;
	
	/**
	 * @param game
	 * @param buttons
	 */
	public CreatingScreen(IGame game) {
		super(game, getButtons());
		border = new AutoWindow((GmudGame) game, 95, 31, 36*4+1, 36*4+1, "");
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		// DO NOTHING
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		g.clear(GameConstants.BG_COLOR);
		

	}
	
	static AutoButton[] getButtons() {
		AutoButton[] t;
		t = new AutoButton[6];
		String s[] = new String[] {"����","����","����","����","�Ѷ�","��ʼ��Ϸ"};
		for(int i = 0; i < 6; i++)
		{
			t[i] = new AutoButton(GmudWorld.game,96+32,32+12+24*i,s[i]);
		}
		
		return t;
	}
}
