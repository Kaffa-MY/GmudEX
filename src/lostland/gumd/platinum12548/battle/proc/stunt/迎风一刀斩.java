/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ӭ��һ��ն.java <p>
 * ����ʱ�䣺2013-8-23 ����11:35:21 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.AnotherDummyStatus;
import lostland.gumd.platinum12548.battle.proc.AttackStatus;
import lostland.gumd.platinum12548.battle.proc.RoundOverStatus;
import lostland.gumd.platinum12548.battle.proc.Status;

/**
 * ������ӭ��һ��ն <p>
 * ˵����
 * @author 12548
 */
public class ӭ��һ��ն implements Status {

	/**
	 * 
	 */
	public ӭ��һ��ն() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		AttackStatus.ag = GmudWorld.bs.zdp.cg();
		GmudWorld.bs.bdp.temp_dmg_multiplier = 3.0;
		GmudWorld.bs.setStatus(new AnotherDummyStatus(new AttackStatus(new RoundOverStatus())));
		ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
		GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		return false;
	}

}
