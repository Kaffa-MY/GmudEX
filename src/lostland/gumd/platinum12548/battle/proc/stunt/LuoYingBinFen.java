/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����LuoYingBinFen.java <p>
 * ����ʱ�䣺2013-8-23 ����8:09:39 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.Status;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;

/**
 * ������LuoYingBinFen <p>
 * ˵����
 * @author 12548
 */
public class LuoYingBinFen implements Status {

	/**
	 * 
	 */
	public LuoYingBinFen() {
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
			if(GmudWorld.wp[GmudWorld.bs.bdp.itemsckd[0]].kind == 2)
			{
				ViewScreen.setText(GmudWorld.bs.bsp("$n���б��б���Ȧ������ת��Ȧ����Ҳ�ѳֲ�����һ�������ַɳ���"));
				GmudWorld.bs.bdp.itemsckd[0] = 0;
			}
			else
			{
				ViewScreen.setText(GmudWorld.bs.bsp("$n�ۼ������Ӱ��ͷ���£����޿ɶ㣬���޿ɼܣ�һ���Ӿ����Ȧ֮�У�"));
				GmudWorld.bs.bdp.dmg((int) (Math.random()*200 +50), 0);
				GmudWorld.bs.bdp.dz+=3;
			}
		}
		else
		{
			if(GmudWorld.wp[GmudWorld.bs.bdp.itemsckd[0]].kind == 2)
			{
				ViewScreen.setText(GmudWorld.bs.bsp("$n�������ݣ��������죬��æ������������������ϵ�һ���ӹ����б���֮��"));
				GmudWorld.bs.zdp.dz+=3;
			}
			else
			{
				ViewScreen.setText(GmudWorld.bs.bsp("$n�ۼ����ã�������һ���͵�ʮ�˹�����������֮�⣬ȴҲ����Ǳ���"));
				GmudWorld.bs.zdp.dz+=3;
			}
		}
		
		StuntScreen.StuntOver();
		
		return false;
	}

}
