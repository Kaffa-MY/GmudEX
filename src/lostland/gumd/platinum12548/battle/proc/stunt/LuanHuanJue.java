/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����LuanHuanJue.java <p>
 * ����ʱ�䣺2013-8-23 ����11:32:41 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.Status;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;

/**
 * ������LuanHuanJue <p>
 * ˵�����һ���
 * @author 12548
 */
public class LuanHuanJue implements Status {

	/**
	 * 
	 */
	public LuanHuanJue() {
		
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
			ViewScreen.setText(GmudWorld.bs.bsp("���$n���ɼ������ƽ���$N���һ����ڣ�"));
			GmudWorld.bs.bdp.dz+=5;
		}
		else
		{
			ViewScreen.setText(GmudWorld.bs.bsp("����$n�������Ƿ���һ������Ȼ�ѳ��� [�һ���] �İ�Χ��"));
			GmudWorld.bs.zdp.dz+=3;
		}
		
		StuntScreen.StuntOver();
		
		return false;
	}

}
