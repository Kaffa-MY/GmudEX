/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����LiuLangWenYing.java <p>
 * ����ʱ�䣺2013-8-23 ����8:24:21 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.proc.RoundOverStatus;
import lostland.gumd.platinum12548.battle.proc.Status;

/**
 * ������LiuLangWenYing <p>
 * ˵����
 * @author 12548
 */
public class LiuLangWenYing implements Status {

	/**
	 * 
	 */
	public LiuLangWenYing() {
		// TODO �Զ����ɵĹ��캯�����
	}

	boolean b = true;
	int round = -1;
	int t;

	int a=3;
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		round++;
		if(round ==0)
		{	
			if(GmudWorld.bs.zdp.skillsckd[0] == 12)
				a=2;
			
			String p = "��������ݺ"  + (round+1) + "/3��";
			if(GmudWorld.bs.zdp.skillsckd[1] == 11)
				p = "�����Ե�Ӱ��"  + (round+1) + "/"+a+"��";
			
			GmudWorld.bs.atkprocess(null, this,p);
			
//			AttackStatus.ag = GmudWorld.bs.zdp.cg();
//			GmudWorld.bs.setStatus(new AnotherDummyStatus(new AttackStatus(this)));
//			ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
//			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}
		else if(round<a)
		{
			if(b){
				t = GmudWorld.bs.zdp.itemsckd[0];
				GmudWorld.bs.zdp.itemsckd[0] = 0;
				b=false;
			}

			
			String p = "��������ݺ"  + (round+1) + "/3��";
			if(GmudWorld.bs.zdp.skillsckd[1] == 11)
				p = "�����Ե�Ӱ��"  + (round+1) + "/"+a+"��";
			
			GmudWorld.bs.atkprocess(null, this,p);
			
//			AttackStatus.ag = GmudWorld.bs.zdp.cg();
//			GmudWorld.bs.setStatus(new AttackStatus(this));
//			ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
//			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}
		else
		{
			GmudWorld.bs.zdp.dz +=3;
			GmudWorld.bs.zdp.itemsckd[0] = t;
			GmudWorld.bs.setStatus(new RoundOverStatus());
		}

		return false;
	}

}

