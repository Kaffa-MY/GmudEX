/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����FixedScreen.java <p>
 * ����ʱ�䣺2013-8-30 ����12:07:32 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������FixedScreen <p>
 * ˵������ΪFixedScreen����ʵ���Ǳ�������ȷ����Screen
 * @author 12548
 */
public abstract class FixedScreen extends FullScreen {

	public CScreen bg;
	
	/**
	 * @param game
	 */
	public FixedScreen(IGame game,CScreen bg) {
		super(game);
		this.bg = bg;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		bg.present(deltaTime);
		draw();
	}

	public abstract void draw();

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#isStable()
	 */
	@Override
	public boolean isStable() {
		return false;
	}
}
