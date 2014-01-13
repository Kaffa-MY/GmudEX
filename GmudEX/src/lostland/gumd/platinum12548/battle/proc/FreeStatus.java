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

	
	public static int nround = -1;
	
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
		
		double basicSpecialMovementRate = 0.2 * GmudWorld.game.newint[0];
		int aiXiqiCooldown = 4 - GmudWorld.game.newint[0];
		int aiStuntCoolDown = 5 - GmudWorld.game.newint[0];
		
		nround++;
		
		int avStunts[] = new int[0];
		
		for(int i = 0; i <  StuntScreen.name.length; i++)
		{
			if(StuntScreen.canuse(i)) {
				avStunts = GmudWorld.push_back(avStunts, i);
				Log.i("FreeStatus", StuntScreen.name[i] + " is avalible");
			}
		}
		
		Log.i("FreeStatus", avStunts.length + " Stunts avalible in total");
		
		if(avStunts.length > 0 && nround >= aiStuntCoolDown && Math.random() < basicSpecialMovementRate)
		{
			StuntScreen.process(avStunts[(int) (Math.random() * avStunts.length)]);
			nround=-1;
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}
		else if(GmudWorld.bs.zdp.sp < GmudWorld.bs.zdp.hp && GmudWorld.bs.zdp.fp > 0 && nround >= aiXiqiCooldown && Math.random() < basicSpecialMovementRate)
		{
			GmudWorld.bs.xiqiprocess();
			nround=-1;
		}
		else
		{
			GmudWorld.bs.atkprocess(null, null);
		}
		
		
		
		
		
//		AttackStatus.ag = GmudWorld.bs.zdp.cg();
//		GmudWorld.bs.setStatus(new AttackStatus(new RoundOverStatus()));
//		ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
//		GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		return false;
	}

}
