/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SignScreen.java <p>
 * ����ʱ�䣺2013-7-26 ����10:28:49 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.core.DialogScreen;

/**
 * ������SignScreen <p>
 * ˵������������
 * @author 12548
 */
public class SignScreen extends DialogScreen {

	/**
	 * @param game
	 */
	public SignScreen(IGame game) {
		super(game);
		String text;
		
		if(GmudWorld.mc.fame < 128)
			text = "����ͨ���ӷ�"+GmudWorld.mc.name;
		else if(!GmudWorld.game.hunting)
			text = "�����ΰ�����";
		else
			text = "����ͨ���ӷ�"+GmudWorld.npc[GmudWorld.npc.length-1].name;
		
		this.border = new BottomWindow((GmudGame) game,text);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchDown(int, int)
	 */
	@Override
	protected void onTouchDown(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchMove(int, int)
	 */
	@Override
	protected void onTouchMove(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchUp(int, int)
	 */
	@Override
	protected void onTouchUp(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onClick(int, int)
	 */
	@Override
	protected void onClick(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		game.setScreen(GmudWorld.ms);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		border.draw();
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
