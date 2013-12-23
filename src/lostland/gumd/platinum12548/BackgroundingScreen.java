/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BackgroundingScreen.java <p>
 * ����ʱ�䣺2013-12-20 ����3:29:49 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������BackgroundingScreen <p>
 * ˵����
 * @author 12548
 */
public class BackgroundingScreen extends CScreen {

	CScreen ts;
	
	/**
	 * @param game
	 */
	public BackgroundingScreen(IGame game, CScreen s) {
		super(game);
		ts = s;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#pause()
	 */
	@Override
	public void pause() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#resume()
	 */
	@Override
	public void resume() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#dispose()
	 */
	@Override
	public void dispose() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.BasicScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		if(deltaTime>0)
			game.setScreen(ts);

	}

}
