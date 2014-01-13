/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ShenDaoGuiDie.java <p>
 * ����ʱ�䣺2013-8-23 ����8:03:18 <p>
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
 * ������ShenDaoGuiDie <p>
 * ˵����
 * @author 12548
 */
public class ShenDaoGuiDie implements Status {

	/**
	 * 
	 */
	public ShenDaoGuiDie() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {

		double hit_rate = 0.7 + 0.3 * (((double)GmudWorld.bs.zdp.fp - GmudWorld.bs.bdp.fp) / (double)(GmudWorld.bs.zdp.fp + GmudWorld.bs.bdp.fp + 1));

		Log.i("�񵹹��","������=" + hit_rate);

		boolean hit = Math.random() < hit_rate;

		if(hit)
		{
			ViewScreen.setText(GmudWorld.bs.bsp("���$n�ۻ����ң���ͨһ����ˤ������ڵأ���Ҫ����վ�𣬿��������ó�������"));
			GmudWorld.bs.bdp.dmg((int) ((GmudWorld.bs.zdp.skills[1]+GmudWorld.bs.zdp.skills[39]*1.5)/5), 0);
			GmudWorld.bs.bdp.dz+=8;
		}
		else
		{
			ViewScreen.setText(GmudWorld.bs.bsp("����$n������񣬼��������񵲣������Ī����������о�ȫ����գ�"));
			GmudWorld.bs.zdp.dz+=3;
		}

		StuntScreen.StuntOver();

		return false;
	}

}
