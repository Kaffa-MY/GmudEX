/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BattleStart.java <p>
 * ����ʱ�䣺2013-8-5 ����5:53:03 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.BattleOverScreen;

/**
 * ������BattleStart <p>
 * ˵����
 * @author 12548
 */
public class BattleStart implements Status {

	public static int wp;
	public static String name;
	
	/**
	 * 
	 */
	public BattleStart() {

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		
		GmudWorld.bs.zdp = GmudWorld.mc;
		GmudWorld.bs.bdp = GmudWorld.npc[GmudWorld.bs.enemyid];
//		GmudWorld.bs.bdp.setDifficulty(GmudWorld.game.getDifficulty());
		GmudWorld.bs.bdp.refresh();
		GmudWorld.bs.setStatus(new FreeStatus());
		GmudWorld.bs.eob = false;
		
		
		
		
		BattleOverScreen.tpflag = false;
		
		if(GmudWorld.bs.bdp.id >=124)
		{
			BattleOverScreen.bossflag = true;
		}
		
		wp =  GmudWorld.npc[GmudWorld.bs.enemyid].itemsckd[0];
		name = GmudWorld.mc.name;
		GmudWorld.mc.name = "��";
		
		boolean xg = GmudWorld.rand.nextBoolean(); // �ȹ��ж����Ժ��ٸ�
		
		if(xg)
			GmudWorld.bs.swapp();
		return true;
	}

}
