/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����LiuXingFeiZhi.java <p>
 * ����ʱ�䣺2013-8-23 ����7:42:53 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.Status;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;

/**
 * ������LiuXingFeiZhi <p>
 * ˵����
 * @author 12548
 */
public class LiuXingFeiZhi implements Status {

	/**
	 * 
	 */
	public LiuXingFeiZhi() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		boolean hit = GmudWorld.rand.nextBoolean();
		
		if(hit)
		{
			GmudWorld.bs.bdp.dmg(1000, 0);
			ViewScreen.setText(GmudWorld.bs.bsp("$n�ŵ�Ŀ�ɿڴ������������ܣ���һ����$n$l�Դ���������Ѫ�������أ�"));
		}
		else
		{
			GmudWorld.bs.zdp.dz += 4;
			ViewScreen.setText(GmudWorld.bs.bsp("û�뵽$n����죬һ����������ˮ���Ծ�����ɣ�$w��δ�����ֺ���"));
		}
		GmudWorld.bs.zdp.itemsckd[0] = 0;
		StuntScreen.StuntOver();
		
		return false;
	}

}
