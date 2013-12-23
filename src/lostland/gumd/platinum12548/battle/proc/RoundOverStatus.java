/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����RoundOverStatus.java <p>
 * ����ʱ�䣺2013-8-7 ����9:22:55 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import android.util.Log;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;

/**
 * ������RoundOverStatus <p>
 * ˵����
 * @author 12548
 */
public class RoundOverStatus implements Status {

	/**
	 * 
	 */
	public RoundOverStatus() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {

		if(GmudWorld.bs.bdp.sp <= 0){
			GmudWorld.bs.eob = true;
			return false;
		}
		for(int i = 0; i < GmudWorld.bs.zdp.sz.length; i++)
			if(GmudWorld.bs.zdp.sz[i] > 0)
				GmudWorld.bs.zdp.sz[i]--;

		for(int i  = 0; i < GmudWorld.bs.zdp.buff.length; i++)
			if(GmudWorld.bs.zdp.buff[i] > 0)
			{
				GmudWorld.bs.zdp.buff[i]--;
				if(GmudWorld.bs.zdp.buff[i] == 0)
				{
					switch(i)
					{
					case 0:
						ViewScreen.setText(GmudWorld.bs.bsp("$N��ʽһ�������ϵĴ�С��Ȧ�漴������"));
						GmudWorld.bs.zdp.evd_bouns -= GmudWorld.bs.zdp.skills[30] / 10;
						GmudWorld.bs.zdp.hit_bouns -= 10;
						break;
					case 1:
						ViewScreen.setText(GmudWorld.bs.bsp("$N�����ջ��������Ʒ�Ҳ�ָ�ƽ����"));
						GmudWorld.bs.zdp.hit_bouns -= (GmudWorld.bs.zdp.skills[1]+GmudWorld.bs.zdp.skills[12])/20;
						break;
					case 2:
						ViewScreen.setText(GmudWorld.bs.bsp("$N�����ķ��ñϣ���Ҳ�ָ�������"));
						GmudWorld.bs.zdp.agi_bouns -= GmudWorld.bs.zdp.skills[20] / 10;
						GmudWorld.bs.zdp.def_bouns -= (GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[20]*2)/10 -5;
						break;
					case 3:
						ViewScreen.setText(GmudWorld.bs.bsp("$nʶ����$N����Ļ��ƣ�����������ˡ�"));
						GmudWorld.bs.zdp.hit_bouns -= GmudWorld.bs.bdp.hit;
						break;
					case 4:
						ViewScreen.setText(GmudWorld.bs.bsp("$N�̷�Ӱ����������ϣ���������Ļ�ӰҲ������ʧ��"));
						GmudWorld.bs.zdp.wxg_bouns -= 90;
						break;
					case 5:
						ViewScreen.setText(GmudWorld.bs.bsp("$N���ľ�������ϣ����������ܵĻ���������ɢȥ��"));
						GmudWorld.bs.zdp.def_bouns -= (GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[36]*2)/8;
						break;
					case 6:
						ViewScreen.setText(GmudWorld.bs.bsp("$N�����ջ��������Ʒ�Ҳ�ָ�ƽ����"));
						GmudWorld.bs.zdp.str_bouns -= GmudWorld.bs.zdp.skills[13]/5;
						GmudWorld.bs.zdp.hit_bouns -= GmudWorld.bs.zdp.skills[13]/10;
						break;
					}

					GmudWorld.bs.setStatus(new AnotherDummyStatus(new FreeStatus()));
					GmudWorld.bs.swapp();
					return true;
				}
			}

		
		GmudWorld.bs.bdp.temp_dmg_multiplier = 1.0;

		Log.i("�غϽ���", "doing");
		GmudWorld.bs.setStatus(new FreeStatus());
		GmudWorld.bs.swapp();
		return true;
	}

}
