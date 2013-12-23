/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����YinYangJue.java <p>
 * ����ʱ�䣺2013-8-23 ����12:16:25 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc.stunt;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.AnotherDummyStatus;
import lostland.gumd.platinum12548.battle.proc.AttackStatus;
import lostland.gumd.platinum12548.battle.proc.DummyStatus;
import lostland.gumd.platinum12548.battle.proc.RoundOverStatus;
import lostland.gumd.platinum12548.battle.proc.Status;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;

/**
 * ������YinYangJue <p>
 * ˵����
 * @author 12548
 */
public class YinYangJue implements Status {

	/**
	 * 
	 */
	public YinYangJue() {
		
	}

	boolean yin;
	
	int round = -1;
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		
		if(round==-1)yin = GmudWorld.rand.nextBoolean();
		
		round++;
		
		if(yin)
		{
			if(round==0){
				ViewScreen.setText(GmudWorld.bs.bsp("$N��ʽһ�䷭Ϊ���֣�һ�����ྡྷ��ֱ��$nȫ����ȥ ��"));
				AttackStatus.ts = this;
				GmudWorld.bs.setStatus(new DummyStatus());
			}else{
				boolean hit = GmudWorld.rand.nextBoolean();
				if(hit)
				{
					ViewScreen.setText(GmudWorld.bs.bsp("$n�$N�����仯Ī��֮�ʣ����ﻹ���мܣ����ӱ�̫���ᾢ�Ƶõ���ײײ��"));
					GmudWorld.bs.bdp.dz = 8;
				}
				else
				{
					ViewScreen.setText(GmudWorld.bs.bsp("$n���һ��֮�ʣ���������ȫ���࿹���Ǳ���״�ش�̫���ᾢ���ѵ�������"));
					GmudWorld.bs.zdp.dz = 3;
				}
				StuntScreen.StuntOver();
			}
			
			
		}else if(round ==0)
		{
			AttackStatus.ag = GmudWorld.zs[121+round];
			GmudWorld.bs.setStatus(new AnotherDummyStatus(new AttackStatus(this)));
			ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}else if(round<3)
		{
			AttackStatus.ag = GmudWorld.zs[121+round];
			GmudWorld.bs.setStatus(new AttackStatus(this));
			ViewScreen.setText(GmudWorld.bs.bsp(AttackStatus.ag.c));
			GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		}
		else
		{
			GmudWorld.bs.zdp.dz +=3;
			GmudWorld.bs.zdp.str_bouns += ( GmudWorld.bs.zdp.skills[1] +GmudWorld.bs.zdp.skills[31] * 2 ) / 10;
			
			GmudWorld.bs.setStatus(new RoundOverStatus());
		}
		
		return false;
	}

}
