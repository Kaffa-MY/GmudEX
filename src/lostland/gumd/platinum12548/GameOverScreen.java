/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����GameOverScreen.java <p>
 * ����ʱ�䣺2013-8-27 ����10:25:20 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������GameOverScreen <p>
 * ˵����
 * @author 12548
 */
public class GameOverScreen extends CScreen {

	/**
	 * @param game
	 */
	public GameOverScreen(IGame game) {
		super(game);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		game.oo();

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

}
