/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����JiZiJue.java <p>
 * ����ʱ�䣺2013-8-21 ����9:22:40 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import android.util.Log;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.Status;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;

/**
 * ������JiZiJue <p>
 * ˵����
 * @author 12548
 */
public class JiZiJue implements Status {

	/**
	 * 
	 */
	public JiZiJue() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		
		double hit_rate = 0.3 + 0.3 * (((double)GmudWorld.bs.zdp.fp - GmudWorld.bs.bdp.fp) / (double)(GmudWorld.bs.zdp.fp + GmudWorld.bs.bdp.fp + 1));

		Log.i("���־�","������1=" + hit_rate);

		boolean hit = Math.random() < hit_rate;

		if(hit)
		{
			ViewScreen.setText(GmudWorld.bs.bsp("����$N�ᾢ������$n����ôһ������ʽ�еľ������˸��գ����пյ�����ʮ�����ܣ�"));
			GmudWorld.bs.bdp.fp-=GmudWorld.bs.zdp.fp/10+315+GmudWorld.bs.zdp.ads;
			if(GmudWorld.bs.bdp.fp<0)GmudWorld.bs.bdp.fp=0;
		}
		else
		{
			double hit_rate2 = 0.4 + 0.4 * (((double)GmudWorld.bs.zdp.fp - GmudWorld.bs.bdp.fp) / (double)(GmudWorld.bs.zdp.fp + GmudWorld.bs.bdp.fp + 1));

			Log.i("���־�","������2=" + hit_rate2);

			boolean hit2 = Math.random() < hit_rate2;
			
			if(hit2)
			{
				ViewScreen.setText(GmudWorld.bs.bsp("$n�����龰��һ�����棬��æ�ջ��Լ��ľ�����������ã�"));
				GmudWorld.bs.bdp.fp-=350;
				if(GmudWorld.bs.bdp.fp<0)GmudWorld.bs.bdp.fp=0;
			}
			else
			{
				ViewScreen.setText(GmudWorld.bs.bsp("û�뵽$n��������ޱȣ�$N��һ���ǵ��ֺ��޹����Լ�������ǣ�õ���������"));
				GmudWorld.bs.zdp.dz = 3;
			}
		}

		StuntScreen.StuntOver();

		return false;
	}

}
