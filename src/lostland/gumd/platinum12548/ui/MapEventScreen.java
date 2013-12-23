/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MapEventScreen.java <p>
 * ����ʱ�䣺2013-12-22 ����2:08:47 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GameEvent;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������MapEventScreen <p>
 * ˵����
 * @author 12548
 */
public class MapEventScreen extends CScreen {

	boolean b = true;
	
	int eid;
	
	/**
	 * @param game
	 */
	public MapEventScreen(IGame game,int eid) {
		super(game);
		this.eid = eid;
		b=true;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		GmudWorld.ms.present(deltaTime);
		
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
		if(b)
		{
			GameEvent.callEvent(eid);
//			b = false;
		}
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#isStable()
	 */
	@Override
	public boolean isStable() {
		return false;
	}

	
	
}
