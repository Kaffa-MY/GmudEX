/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����DummyStatus.java <p>
 * ����ʱ�䣺2013-8-8 ����6:31:54 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;

/**
 * ������DummyStatus <p>
 * ˵����Ϊ�˽��һ��Ī�������bug��Ī����������õ��࡭����������
 * @author 12548
 */
public class DummyStatus implements Status {

	boolean b = true;
	
	/**
	 * 
	 */
	public DummyStatus() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		if(b)
		{
			b=false;
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}else
		GmudWorld.bs.setStatus(AttackStatus.ts);
		return false;
	}

}
