/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ZhenZiJue.java <p>
 * ����ʱ�䣺2013-8-16 ����11:52:09 <p>
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
 * ������ZhenZiJue <p>
 * ˵����
 * @author 12548
 */
public class ZhenZiJue implements Status {

	/**
	 * 
	 */
	public ZhenZiJue() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		
		double hit_rate = 0.5 + 0.5 * (((double)GmudWorld.bs.zdp.fp - GmudWorld.bs.bdp.fp) / (double)(GmudWorld.bs.zdp.fp + GmudWorld.bs.bdp.fp + 1));
		Log.i("���־�","������=" + hit_rate);
		boolean hit = Math.random() < hit_rate;
		
		
		if(hit){
			ViewScreen.setText(GmudWorld.bs.bsp("̫��֮�����಻��,һ��ԲȦδ��,�ڶ���ԲȦ����,����һ��,$nһ����ͷ�ѱ��ʶϣ�"));
			GmudWorld.bs.bdp.dmg(GmudWorld.bs.zdp.fp/10 +GmudWorld.bs.zdp.ads - GmudWorld.bs.bdp.fp/30,0);
		}else{
			ViewScreen.setText(GmudWorld.bs.bsp("$n�������ʶ������������һ�󼱹���$N��ʱ��æ���ң���Ҳ���������У�"));
			GmudWorld.bs.zdp.dz +=3;
		}
		
		StuntScreen.StuntOver();
		return false;
	}

}
