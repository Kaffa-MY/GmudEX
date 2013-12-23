/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����AttackStatus.java <p>
 * ����ʱ�䣺2013-8-7 ����8:22:58 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import android.util.Log;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.data.Gesture;
import lostland.gumd.platinum12548.data.Npc;
import lostland.gumd.platinum12548.data.Skill;

/**
 * ������AttackStatus <p>
 * ˵����
 * @author 12548
 */
public class AttackStatus implements Status {

	public static Status ts;
	
	public static Gesture ag;
	public Skill as;
	
	/**
	 * 
	 */
	public AttackStatus(Status s) {
		Log.d("AttackStatus","constructing");
		ts = s;
		as = GmudWorld.bs.zdp.getAttackSkill();
		Log.d("AttackStatus","constructed");
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.battle.proc.Status#execute()
	 */
	@Override
	public boolean execute() {
		
		if(evd())
			ViewScreen.setText(GmudWorld.bs.bsp(GmudWorld.bs.bdp.getEquipedSkill(2).chooseAGesture().c));
		else if(blk())
			ViewScreen.setText(GmudWorld.bs.bsp(GmudWorld.skill[Skill.KIND_ZHAOJIA].chooseAGesture().c));
		else if(GmudWorld.bs.bdp.buff[4]>0 && GmudWorld.rand.nextBoolean())
		{
			ViewScreen.setText(GmudWorld.bs.bsp("$Nû�ϵ���һ��ȴ��գ�ԭ�����е�ֻ�Ǹ�Ӱ��"));
		}
		else
		{
			int a;
			if(GmudWorld.bs.zdp.fp>0 && GmudWorld.bs.zdp.ads>0){
				a = (int) ((GmudWorld.bs.zdp.getStr() + GmudWorld.bs.zdp.ads/2 + GmudWorld.bs.zdp.getAtk() + Math.min(GmudWorld.bs.zdp.fp/20.0, 150)) *
					(ag.force1 / 100.0) + (GmudWorld.bs.zdp.getStr() + GmudWorld.bs.zdp.ads + GmudWorld.bs.zdp.getAtk() + 
							Math.min(GmudWorld.bs.zdp.fp/20.0, 150)) *
					(ag.force2 / 100.0 + 0.8));
				GmudWorld.bs.zdp.fp -= GmudWorld.bs.zdp.ads;
				if(GmudWorld.bs.zdp.fp<0)GmudWorld.bs.zdp.fp=0;
			}
			else
				a = (int) ((GmudWorld.bs.zdp.getStr()  + GmudWorld.bs.zdp.getAtk()) * ((ag.force1+ag.force2) / 100.0 + 0.8));
			
			int dmg = (int) (a/2.0 + Math.random()*a/2.0);
			
			
			GmudWorld.bs.bdp.dmg(dmg,ag.dmgfix);
			
			GmudWorld.bs.zdp.sp += GmudWorld.bs.zdp.skills[41]*dmg / 100;
			if(GmudWorld.bs.zdp.sp>GmudWorld.bs.zdp.hp)GmudWorld.bs.zdp.sp=GmudWorld.bs.zdp.hp;
			
			ViewScreen.setText(GmudWorld.bs.bsp(get_damage_string(ag.dmg_type,dmg))+shfj(GmudWorld.bs.bdp) + "#hit#");
			
			
		}
		
		
		
		GmudWorld.bs.setStatus(new DummyStatus());
		GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
		return false;
	}

	
	boolean evade()
	{
		double basic_hit_rate;
		double hit_agility_addition;
		double evade_agility_addition;
		double basic_art_suppress_rate;
		double advanced_art_suppress_rate;
		double hit_rate;

		basic_hit_rate=GameConstants.BASE_BASIC_HIT_RATE-GmudWorld.bs.bdp.agi*GameConstants.INNATE_AGI_EVADE_RATE;
		Log.i("attack_process", "����������="+basic_hit_rate);
		if(basic_hit_rate<GameConstants.BASIC_HIT_RATE_LOWERLIMIT)
			basic_hit_rate=GameConstants.BASIC_HIT_RATE_LOWERLIMIT;
		hit_agility_addition=GmudWorld.bs.zdp.getAgi()*GameConstants.HIT_RATE_AGI_ADDITION_RATE;
		Log.i("attack_process", "�������ݼӳ�ֵ="+hit_agility_addition);
		evade_agility_addition=GmudWorld.bs.bdp.getAgi()*GameConstants.EVADE_RATE_AGI_ADDITION_RATE;
		Log.i("attack_process", "�ر����ݼӳ�ֵ="+evade_agility_addition);
		basic_art_suppress_rate=Math.pow((1.0*
				GmudWorld.bs.zdp.skills[as.kind + as.subkind]+1.0)/(1.0+GmudWorld.bs.bdp.skills[Skill.KIND_QINGGONG]),
				1.0/GameConstants.BASIC_ART_HIT_RATE_SUPPRESS_REDUCE_RATE);
		Log.i("attack_process", "������ѧ����ѹ��="+basic_art_suppress_rate);
		advanced_art_suppress_rate=
				((1.0+GmudWorld.bs.zdp.skills[as.id]+
						GmudWorld.bs.zdp.skills[GmudWorld.bs.zdp.getEquipedSkill(2).id])*
						GameConstants.ADVANCED_QINGGONG_HIT_QUE)/
				((1.0+GmudWorld.bs.bdp.skills[GmudWorld.bs.zdp.getEquipedSkill(2).id])*  
						GameConstants.ADVANCED_QINGGONG_EVADE_QUE);
		Log.i("attack_process", "������ѧ����ѹ��="+advanced_art_suppress_rate);
		double extra_hit_rate_suppress_rate=Math.pow((GmudWorld.bs.zdp.hit+100+ag.hitfix)*1.0/(100+GmudWorld.bs.bdp.evd), 
				1.0/GameConstants.ADDITIONAL_HIT_RATE_SUPPRESS_REDUCE_RATE);
		hit_rate=basic_hit_rate*(1+hit_agility_addition)*(1-evade_agility_addition)*
				basic_art_suppress_rate*advanced_art_suppress_rate*extra_hit_rate_suppress_rate;
		Log.i("attack_process", "������="+hit_rate);
		boolean isHit=Math.random()<=hit_rate;
		Log.i("attack_process", "����="+isHit);

		return !isHit;
	}
	
	boolean block()
	{
		
		
		double basic_block_rate=GameConstants.BASE_BASIC_BLOCK_RATE;
		Log.i("attack_process", "�������ʣ�"+basic_block_rate);
		double basic_attributes_block_suppress=Math.pow((GmudWorld.bs.bdp.getAgi()+GmudWorld.bs.bdp.getBon()+GmudWorld.bs.bdp.getStr())*1.0/
				(GmudWorld.bs.zdp.getAgi()+GmudWorld.bs.zdp.getBon()+GmudWorld.bs.zdp.getStr()),1.0/GameConstants.BASIC_ABILITY_BLOCK_RATE_SUPPRESS_REDUCE_RATE);
		Log.i("attack_process", "�������Ը�ѹ�ƣ�"+basic_attributes_block_suppress);
		double basic_art_block_suppress=
				Math.pow(1.0*GmudWorld.bs.bdp.skills[Skill.KIND_ZHAOJIA]/GmudWorld.bs.zdp.skills[as.getBasicSkill().id],1.0/GameConstants.BASIC_ART_BLOCK_RATE_SUPPRESS_REDUCE_RATE);
		Log.i("attack_process", "������ѧ��ѹ�ƣ�"+basic_art_block_suppress);
		double debug11=GmudWorld.bs.bdp.skills[GmudWorld.bs.bdp.getAttackSkill().id];
		double debug221=GmudWorld.bs.zdp.skills[as.id];
		double debug22=debug221;
		double advanced_art_block_suppress=debug11/debug22;
		Log.i("attack_process", "������ѧ��ѹ�ƣ�"+advanced_art_block_suppress);
		double block_rate= basic_block_rate* basic_attributes_block_suppress* basic_art_block_suppress* advanced_art_block_suppress;
		Log.i("attack_process", "���ʣ�"+block_rate);
		
		
		boolean isBlocked=Math.random()<=block_rate;
		Log.i("attack_process", "�񵲣�"+isBlocked);

		
		return isBlocked;
	}
	
	
	public static String get_damage_string(int damage_type,int dmg)
	{
		String s[];
		s=new String[9];
		s[0] = "���û������˺�";
		
		switch(damage_type)
		{
		case 2:
			s[1] = "ֻ����ش���$nƤ��";
			s[2] = "��$n���ϴ̳�һ������";
			s[3]="���$n�������˴���";
			s[4]="����̵�$n���˼���";
			s[5]="����̳�һ��Ѫ��ģ�����˿�";
			s[6]="���$n�����˸�͸����������Ѫ�ɽ�";
			s[7]="���$n�����˸�͸����������Ѫ�ɽ�";
			s[8]="���$n�����˸�͸����������Ѫ�ɽ�";
			break;
		case 3:
			s[1] = "ֻ�����������$n";
			s[2] = "��$n���˴����һ������";
			s[3]="���һ�����У�$n��������һ���ϸ�";
			s[4]="���һ�����У�$nʹ����ƺ���һ��";
			s[5]="������须��һ����$n��������";
			s[6]="���$n�����˺ü�������һ��ˤ��";
			s[7]="������صĻ��У�$n�³�һ����Ѫ";
			s[8]="���һ�����죬$n�������ݰ���˳�ȥ";
			break;
		case 5:
			s[1] = "ֻ��ץ��$n��һ��Ƥ";
			s[2]="���$n��ץ��������������Ѫ��";
			s[3]="���һצ���У�$n��ץ��������Ѫ��";
			s[4]="���ץ����$nһС��Ƥ��";
			s[5]="���$nƤ�����ƣ���Ѫ��������";
			s[6]="���$n��ץ�������Ѫ������Ѫ����";
			s[7]="���$n����Ƥ����ץ����һ��飬¶���˹�ͷ";
			s[8]="��������꡻һ����$n�Ĺ�ͷ��ץ�÷���";
			break;
		case 1:
			s[1] = "ֻ����ػ���$n��Ƥ��";
			s[2] = "����һ��ϸ����Ѫ��";
			s[3]="���$n�������һ���˿�";
			s[4]="���$n��������һ��Ѫ���ܵ��˿�";
			s[5]="���$n��������һ���ֳ�������˿�";
			s[6]="���$n��������һ������ǵĿ����˿�";
			s[7]="���$n��������һ������ǵĿ����˿�";
			s[8]="���$n��������һ������ǵĿ����˿�";
			break;
		case 4:
			s[1] = "$n���˰벽����������";
			s[2] = "��$n���һ������";
			s[3]="���һ�����У�$nʹ��������";
			s[4]="���$nʹ����ƺ���һ������Ȼ���˵�����";
			s[5]="���$nҡҡ�λΣ�һ��ˤ���ڵ�";
			s[6]="���$n��ɫһ�±�òҰף������˺ü���";
			s[7]="������䡻��һ����$n������Ѫ�������";
			s[8]="���$nһ���ҽУ���̲�����������ȥ";
			break;
		case 0:
		default:
			s[1] = "ֻ��$n��ǿ�����΢���˺�";
			s[2]="�����$n�������΢���˺�";
			s[3]="�����$n�����һ���˺�";
			s[4]="�����$n�������Ϊ���ص��˺�";
			s[5]="�����$n������൱���ص��˺�";
			s[6]="�����$n�����ʮ�����ص��˺�";
			s[7]="�����$n����˼������ص��˺�";
			s[8]="�����$n����˷ǳ����µ������˺�";
		}
		
		if(dmg==0)
			return s[0];
		else if(dmg<10)
			return s[1];
		else if(dmg<20)
			return s[2];
		else if(dmg<40)
			return s[3];
		else if(dmg<80)
			return s[4];
		else if(dmg<120)
			return s[5];
		else if(dmg<160)
			return s[6];
		else if(dmg<200)
			return s[7];
		else
			return s[8];
	}

	String shfj(Npc p)
	{
		String t;
		String s1[] = new String[]{"����������������һ��Ҳ����",
				"�ƺ���Щƣ��������ʮ���л���",
				"������������Щ����",
				"�����ƺ���ʼ�е㲻̫���",
				"�������꣬������״������̫��",
				"ʮ��ƣ����������Ҫ�ú���Ϣ��",
				"�Ѿ�ͷ�ؽ��ᣬ��������֧��",
				"�������Ѿ�����������",
				"ҡͷ���ԣ��ۿ���Ҫ���ڵ���",
				"�Ѿ���������״̬"
				};
		String s2[] = new String[]{"��������Ѫ��ӯ����û������",
				"�ƺ����˵����ˣ�������������",
				"�������������˵�����",
				"���˼����ˣ������ƺ���������",
				"���˲��ᣬ������״������̫��",
				"������ʼɢ�ң������ܵ��˲���",
				"�Ѿ��˺����ۣ���������֧��",
				"�����൱�أ�ֻ��������Σ��",
				"����֮���Ѿ�����֧��",
				"���˹��أ��Ѿ����ڵ�Ϧ��",
				"���˹��أ���ʱ�����ܶ���"
				};
		int t1 = p.maxhp - p.sp;
		int t2 = p.maxhp - p.hp;
		
		if(t2>=p.maxhp)
			t = s2[s2.length-1];
		else if(t1>=t2)
		{
			if(t1>=p.maxhp)
				t=s1[s1.length-1];
			else
				t=s1[(int) (1.0*t1*s1.length/p.maxhp)];
		}
		else
		{
			t=s2[(int) (1.0*t2*s2.length/p.maxhp)];
		}
		return GmudWorld.bs.bsp("��$n"+t+"��");

	}

	
	boolean evd()
	{
		Log.w("Attack", "���ڻ�ȡ������");
		double hr = GmudWorld.bs.zdp.getBattleHit() / GmudWorld.bs.bdp.getBattleEvd() * 0.5;
		Log.i("attack_process", "������="+hr);
		boolean isHit=Math.random()<=hr;
		Log.i("attack_process", "����="+isHit);
		return !isHit;
	}
	
	boolean blk()
	{
		double hr = GmudWorld.bs.bdp.getBattleBLK() / GmudWorld.bs.zdp.getBattleHit() * 0.1;
		Log.i("attack_process", "���ʣ�"+hr);
		
		boolean isBlocked=Math.random()<=hr;
		Log.i("attack_process", "�񵲣�"+isBlocked);
		return isBlocked;
	}

}
