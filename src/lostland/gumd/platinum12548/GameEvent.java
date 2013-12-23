/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����GameEvent.java <p>
 * ����ʱ�䣺2013-5-27 ����5:40:49 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import java.util.ArrayList;

import lostland.gumd.platinum12548.battle.proc.BattleStart;
import lostland.gumd.platinum12548.blgframework.BasicScreen;
import lostland.gumd.platinum12548.blgframework.IFileIO;
import lostland.gumd.platinum12548.data.Item;
import lostland.gumd.platinum12548.ui.EventScreen;
import lostland.gumd.platinum12548.ui.NotificationScreen;
import lostland.gumd.platinum12548.ui.RopeScreen;
import lostland.gumd.platinum12548.ui.SignScreen;
import lostland.gumd.platinum12548.ui.TalkingScreen;
import lostland.gumd.platinum12548.ui.WateringScreen;
import lostland.gumd.platinum12548.ui.core.YesNoScreen;

/**
 * ������GameEvent <p>
 * ˵�����¼�������
 * @author 12548
 */
public class GameEvent {
	public static final int DRINK=1;
	public static final int SIGN = 5;
	public static final int ROPE = 0;
	
	public static void callEvent(int eventid)
	{
		switch(eventid)
		{
		case ROPE:
			if(!GmudWorld.mc.have(Item.ROPE_INDEX))
				GmudWorld.game.setScreen(new RopeScreen(GmudWorld.game));
			break;
		case DRINK:
			GmudWorld.game.setScreen(new WateringScreen(GmudWorld.game));
			break;
		case SIGN:
			GmudWorld.game.setScreen(new SignScreen(GmudWorld.game));
			break;
		case 2:
		case 3:
		case 4:
			if(TalkingScreen.mpp != eventid)return;
			int cost[] = {0,0,50,60,40};
			if(GmudWorld.mc.sp < cost[eventid]){
				GmudWorld.game.setScreen(new TalkingScreen(GmudWorld.game,"���Ű����ֶ����ˣ������ϰ嶼û��ݣ�",false));
				TalkingScreen.mpp = 0;
				return;
			}
			GmudWorld.mc.sp-=cost[eventid];
			GmudWorld.mc.setExp(GmudWorld.mc.exp + 20);
			GmudWorld.mc.setPotential(GmudWorld.mc.potential + 10);
			GmudWorld.mc.gold += 50;
			String s[] = {"","","","",
					"��ˮ��ˮ����ˮ\n��ˮ����ˮ����","һͰ��Ͱ����Ͱ\n�������ý�ˮ��",
					"��������������\n������������","������ľ������\n����û�±�����",
					"ɨ��ɨ����ɨ��\n���ϻ�������Ƥ","���ż���Ƿ��ɨ\n���������Ѻ���"};
			
			ArrayList<String> a = new ArrayList<String>();
			
			a.add(s[2*eventid]);
			a.add(s[2*eventid+1]);
			
			a.add("���˺ô����������������");
			a.add("�㱻�����ˣ�\n20ʵս����10Ǳ��50��Ǯ");
			TalkingScreen.mpp = 0;
			GmudWorld.game.setScreen(new EventScreen(GmudWorld.game,a,true));
			
			break;
			
		case 6:
			a = new ArrayList<String>();

			if(!GmudWorld.mc.have(73)){
				a.add("���ų�������㣬����������Ƥ�����룺Ҫ���и����Ͷ�ð���");
			}
			else if(GmudWorld.mc.sp<50){
				a.add("������ͷ��ô������������ʣ�����û��������Ѿ�����");
			}
			else{
				a.add("�������������٣�ץ��ֻС��򾣬���ڵ����ϣ�һ���֣����߻���һ�������Ļ���������ˮ���������");
				a.add("һ�ף���ʼ���㡣");
				GmudWorld.mc.dmg(50, -50);
				if(GmudWorld.rand.nextBoolean())
				{
					a.add("������Ȼ������ȥ�����ּ��ۿ죬һ����ͣ����ˣ�");
					if(GmudWorld.mc.have(76))
					{
						a.add("�����Ž���¨�������˿��˻���������㻨Ǯ����" +
								"���ˣ�");
						GmudWorld.mc.give(74);
					}
					else
					{
						a.add("�����ӹ���ժ��������Ȼ���𣺻��ˣ�û����¨��һ" +
								"������һ���ӻ�����ˮ����ֵ������ˣ�");
					}
				}
				else
				{
					a.add("���˺ܾ�Ҳû�����Ϲ�����һ�յ��ͣ������³���ȥ�ˡ�");
				}
			}
			GmudWorld.game.setScreen(new EventScreen(GmudWorld.game,a,false));
			break;
			
		case 7:

			GmudWorld.game.setScreen(new TalkingScreen(GmudWorld.game,"������û��˼�������Ҹ������ϵ���ɱ",false));
			if(GmudWorld.mc.have(Item.ROPE_INDEX))
			{
				TalkingScreen.ts = new YesNoScreen(GmudWorld.game,"�������ɱ�����Ͼ�ɾ���ˣ��뿼�������"){

					@Override
					protected void onYes() {
						IFileIO f = GmudWorld.game.getFileIO();
						while(!f.getPreferences().edit().putBoolean("newgame", true).commit())
							;
						GmudWorld.game.oo();
					}

					@Override
					protected void onNo() {
						GmudWorld.game.setScreen(GmudWorld.ms);
					}
					
				};
			}
			
			break;
		case 8:
			if(GmudWorld.mc.sex == 0 && GmudWorld.mc.equips(40) && GmudWorld.mc.age == 14 && GmudWorld.mc.fame < 128)
			{
				GmudWorld.mc.give(81);
				GmudWorld.game.setScreen(new TalkingScreen(GmudWorld.game,"���ֲ˻�����",false));
			}
			
			break;
			
		case 9:
			if(GmudWorld.mc.inventory[77] >=6)
			{
				ArrayList<String> ts = new ArrayList<String>();
				int t;
				if(GmudWorld.mc.fame >= 160)
				{
					t = 125;
					ts.add("������ܣ�����----------��û�뵽�ɡ�");
					ts.add(GmudWorld.mc.name+"���ѵ��������ǡ���");
					ts.add("������ܣ�����ʮ��ǰ����ڼΪ�������ɵ��������ɺ���͵Ϯ�����ҹ��������");
					ts.add(GmudWorld.mc.name+"���һ�����ٴη�ӡ��");
					ts.add("������ܣ����ΰɣ������ʵ����ʮ���껹�磡");
				}
				else if(GmudWorld.mc.fame < 128 && GmudWorld.npc[11].dead)
				{
					t = 126;
					ts.add("���º��У��ຣ�ޱߣ���ͷ�ǰ���");
					ts.add(GmudWorld.mc.name+"�������ܣ��ѵ���û������");
					ts.add("���º��У�ʩ���������أ������ǲ�������ص�ԭ���������ٴ�Σ�����µġ�");
				}
				else
				{
					t = 124;
					ts.add("����˭:��ÿ�����µĽ�β,ͨ��������һ������BOSS�������ң�����Ĳ��ң�Ҫ�־͹��Ǹ�Ļ��ĵ��ݰɣ�");
				}
				
				GmudWorld.bs.enemyid = t;
				GmudWorld.bs.setStatus(new BattleStart());
				GmudWorld.bs.eob = false;
				EventScreen.ts = GmudWorld.bs;
				GmudWorld.game.setScreen(new EventScreen(GmudWorld.game,ts,false));
			}
			
			break;
			
		case 10:

			GmudWorld.game.setScreen(new YesNoScreen(GmudWorld.game, "һ����ɽ��ɽ�������ѩ���ഫɽ�������ɾ�ס������ȥ������"){

				@Override
				protected void onYes() {
					game.setScreen(new NotificationScreen(game,GmudWorld.ms,"��Ϸ����δ������"));
				}

				@Override
				protected void onNo() {
					GmudWorld.game.setScreen(GmudWorld.ms);
				}});
			
			
			break;
			
		case 11:
			
			break;
			
		case 13:
			if(GmudWorld.mc.have(78)){
				GmudWorld.game.setScreen(new TalkingScreen(GmudWorld.game,"zzz,������~",false));
				GmudWorld.mc.drop(78,1);
				BasicScreen.timeFlow(900);
			}
			
			break;
		}
		
			
	}
}
