/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ��������־�.java <p>
 * ����ʱ�䣺2013-8-23 ����5:53:12 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.Status;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;

/**
 * ���������־� <p>
 * ˵����
 * @author 12548
 */
public class ���־� implements Status {

	/**
	 * 
	 */
	public ���־�() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		
		boolean hit = Math.random() < 0.5 + Math.random() * 0.5;
		
		if(hit)
		{
			ViewScreen.setText(GmudWorld.bs.bsp("̫������ɢ������ϸ˿Խ��Խ�࣬���ǻ�����һ����˿�ޣ���$n��������������"));
			GmudWorld.bs.bdp.dz+=5;
		}
		else
		{
			ViewScreen.setText(GmudWorld.bs.bsp("$n���һ�����ã�һ��ϸ���ɷ���ԶԶԾ�����⡣"));
			GmudWorld.bs.zdp.dz+=3;
		}
		
		StuntScreen.StuntOver();
		
		return false;
	}

}
