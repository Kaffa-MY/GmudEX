/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����FullScreen.java <p>
 * ����ʱ�䣺2013-8-29 ����11:28:28 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import android.util.Log;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.battle.DummyWindow;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������FullScreen <p>
 * ˵����ȥ����onCancel��DialogScreen������������
 * @author 12548
 */
public abstract class FullScreen extends DialogScreen {

	
	
	/**
	 * @param game
	 */
	public FullScreen(IGame game) {
		super(game);
		Log.i("FS", "C0");
		this.border = new DummyWindow((GmudGame) game);
		Log.i("FS", "C1");
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#onCancel()
	 */
	@Override
	public void onCancel() {
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
