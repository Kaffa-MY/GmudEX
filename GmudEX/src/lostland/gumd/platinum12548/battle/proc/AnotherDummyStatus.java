/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����AnotherDummyStatus.java <p>
 * ����ʱ�䣺2013-8-23 ����4:44:00 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;

/**
 * ������AnotherDummyStatus <p>
 * ˵����Ϊ�˽��bug��һ��DummyStatus�Ѿ��������ˡ���
 * @author 12548
 */
public class AnotherDummyStatus implements Status {

	Status ts;
	boolean b=true;
	/**
	 * 
	 */
	public AnotherDummyStatus(Status s) {
		ts = s;
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
		GmudWorld.bs.setStatus(ts);
		return false;
	}

}
