/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SanHuanTaoYue.java <p>
 * ����ʱ�䣺2013-8-23 ����6:45:02 <p>
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
 * ������SanHuanTaoYue <p>
 * ˵����
 * @author 12548
 */
public class SanHuanTaoYue implements Status {

	/**
	 * 
	 */
	public SanHuanTaoYue(int huan) {
		this.huan = huan;
	}
	int huan;
	int round = -1;
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		round++;
		if(round ==0)
		{
			AttackStatus.ag = GmudWorld.zs[huan+round];
			GmudWorld.bs.setStatus(new AnotherDummyStatus(new AttackStatus(this)));
			ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}else if(round<3)
		{
			AttackStatus.ag = GmudWorld.zs[huan+round];
			GmudWorld.bs.setStatus(new AttackStatus(this));
			ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}
		else
		{
			GmudWorld.bs.zdp.dz +=3;
			GmudWorld.bs.zdp.str_bouns += ( GmudWorld.bs.zdp.skills[1] +GmudWorld.bs.zdp.skills[31] * 2 ) / 10;
			
			GmudWorld.bs.setStatus(new RoundOverStatus());
		}
		
		return false;
	}

}
