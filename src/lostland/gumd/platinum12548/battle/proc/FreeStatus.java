/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����FreeStatus.java <p>
 * ����ʱ�䣺2013-8-5 ����6:00:57 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import android.util.Log;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ControlScreen;
import lostland.gumd.platinum12548.battle.ViewScreen;

/**
 * ������FreeStatus <p>
 * ˵����
 * @author 12548
 */
public class FreeStatus implements Status {

	
	public FreeStatus() {
		// TODO �Զ����ɵĹ��캯�����
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		Log.i("����״̬", "doing");
		if(GmudWorld.bs.zdp == GmudWorld.mc)
		{
			Log.e("����״̬", "����AI");
			GmudWorld.game.setScreen(new ControlScreen(GmudWorld.game));
			Log.e("����״̬", "���ƽ���������");
			return false;
		}
		else if(GmudWorld.bs.zdp.dz>0)
		{
			GmudWorld.bs.zdp.dz--;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			ViewScreen.setText(GmudWorld.bs.zdp.name+"���ڴ���ľ����");
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
			return false;
		}
		
		AttackStatus.ag = GmudWorld.bs.zdp.cg();
		GmudWorld.bs.setStatus(new AttackStatus(new RoundOverStatus()));
		ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
		GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		return false;
	}

}
