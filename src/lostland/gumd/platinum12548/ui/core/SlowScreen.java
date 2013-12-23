/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SlowScreen.java <p>
 * ����ʱ�䣺2013-8-30 ����12:18:27 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������SlowScreen <p>
 * ˵������ʱ��仯
 * @author 12548
 */
public abstract class SlowScreen extends FixedScreen {

	
	/**
	 * @param game
	 * @param bg
	 */
	public SlowScreen(IGame game, CScreen bg, float ticktime) {
		super(game,bg);
		this.tickTime = ticktime;
	}

	public float tickTime;
	
	public float time = 0.0f;

	public abstract void tick();

	public abstract void draw();

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		time += deltaTime;
		if(time >= tickTime)
		{
			time -= tickTime;
			tick();
		}
		
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#onTouchDown(int, int)
	 */
	@Override
	protected void onTouchDown(int tx, int ty) {
		// TODO �Զ����ɵķ������
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#onTouchMove(int, int)
	 */
	@Override
	protected void onTouchMove(int tx, int ty) {
		// TODO �Զ����ɵķ������
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#onTouchUp(int, int)
	 */
	@Override
	protected void onTouchUp(int tx, int ty) {
		// TODO �Զ����ɵķ������
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#onClick(int, int)
	 */
	@Override
	protected void onClick(int tx, int ty) {
		// TODO �Զ����ɵķ������
		
	}


}
