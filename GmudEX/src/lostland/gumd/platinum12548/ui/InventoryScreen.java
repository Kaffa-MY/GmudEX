/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����InventoryScreen.java <p>
 * ����ʱ�䣺2013-12-23 ����7:04:35 <p>
 * ������Ŀ��GmudEX <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.core.DoubleScrollScreen;

/**
 * ������InventoryScreen <p>
 * ˵����
 * @author 12548
 */
public class InventoryScreen extends DoubleScrollScreen {

	boolean b = false;
	
	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param w1
	 * @param w2
	 * @param max
	 */
	public InventoryScreen(IGame game, boolean b) {
		super(game, 50, 50, 25, 100, 6);
		this.b = b;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#gets()
	 */
	@Override
	public void gets() {
		if(b)
			s1 = new String[] {"ʳ��","ҩ��"};
		else
			s1 = new String[] {"ʳ��","ҩ��","����","װ��","����","����"};
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#onClick(int)
	 */
	@Override
	public void onClick(int cursor) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#drawbg()
	 */
	@Override
	public void drawbg() {
		// TODO �Զ����ɵķ������

	}

}
