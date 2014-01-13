/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����NpcMenuScreen.java <p>
 * ����ʱ�䣺2013-7-23 ����6:00:40 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.battle.proc.BattleStart;
import lostland.gumd.platinum12548.blgframework.BasicScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.data.Npc;
import lostland.gumd.platinum12548.ui.core.GmudWindow;
import lostland.gumd.platinum12548.ui.core.MenuScreen;

/**
 * ������NpcMenuScreen <p>
 * ˵����
 * @author 12548
 */
public class NpcMenuScreen extends MenuScreen {


	public static int npcid;
	static int fourth;
	static boolean havefourth=true;


	public NpcMenuScreen(IGame game,int npcid) {
		super(game,getWindows(npcid));
		NpcMenuScreen.npcid = npcid;


		this.dummyBorder = new NpcMenuBorder((GmudGame) game, havefourth);



	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {

		if(index == 0){
			game.setScreen(new TalkingScreen(game,npcid));
		}
		else if(index == 1){
			game.setScreen(new LookScreen(game,npcid));
		}
		else if(index == 2)
		{
			GmudWorld.bs.setStatus(new BattleStart());
			GmudWorld.bs.enemyid = npcid;
			GmudWorld.bs.eob = false;
			game.setScreen(GmudWorld.bs);
		}
		else if(index == 3 && GmudWorld.npc[npcid].trading == 101)
		{
			if(npcid == 6 && GmudWorld.mc.exp<50000)
				game.setScreen(new TalkingScreen(game,"ȥȥȥ���ܹ����������ɣ�",false));
			else if(!GmudWorld.npc[npcid].qingjiaoable)
			{
				if(masterTest())
				{
					TalkingScreen.ts = new TalkingScreen(game,"�������������"+GmudWorld.npc[npcid].name+"���������ؿ����ĸ���ͷ���е�����ʦ������",false);
					for(int i:GmudWorld.teachers)
						GmudWorld.npc[i].qingjiaoable = false;
					GmudWorld.npc[npcid].qingjiaoable = true;
				}
			}
			else
			{
				game.setScreen(new TradeScreen(game,npcid,this));
			}
		}
		else
		{
			game.setScreen(new TradeScreen(game,npcid,this));
		}
		
		BasicScreen.recheck();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		game.setScreen(GmudWorld.ms);
	}


	boolean facTest(int fac)
	{
		if(GmudWorld.mc.faction != fac && GmudWorld.mc.faction>0)
			if(GmudWorld.mc.faction == 7)
			{
				game.setScreen(new TalkingScreen(game,"�����Դ����ɣ������ʦ�ɣ�",false));
				return false;
			}
			else
			{
				game.setScreen(new TalkingScreen(game,"����������ʦ����Ҫ��͵ʦѧ����",false));
				return false;
			}
		return true;
	}

	boolean masterTest()
	{
		if(facTest(GmudWorld.npc[npcid].faction))
			switch(npcid)
			{
			case 38:
				if(GmudWorld.mc.sex == 0){
					game.setScreen(new TalkingScreen(game,"�ðɣ������������㣬�����ҵ��Ĺ�����ֻѧ�����ɣ��л��������������˼���̰ɡ�",false));
					GmudWorld.mc.faction=1;
					return true;
				}
				else{
					game.setScreen(new TalkingScreen(game,"�Ұ����Ź���һ���в���Ů���㻹��������ʦ�ɡ�",false));
					return false;
				}
			case 43:
				if(GmudWorld.mc.maxfp < 500)
				{
					game.setScreen(new TalkingScreen(game,"���������㣬�޷���ϰ�����Ÿ����书��",false));
					return false;
				}
				else if(GmudWorld.mc.skills[14]<50)
				{
					game.setScreen(new TalkingScreen(game,"���Ԫһ������򲻹����޷���ϰ�����Ÿ����书��",false));
					return false;
				}
				else if(GmudWorld.mc.skills[11]<50)
				{
					game.setScreen(new TalkingScreen(game,"�㻹���Ƚ�����������˵�ɡ�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ðɣ��ӽ������������㹦����ͱ������ʦ�ֵ��ˡ�",false));
					GmudWorld.mc.faction=1;
					return true;
				}
			case 47:
				if(GmudWorld.mc.maxfp < 800)
				{
					game.setScreen(new TalkingScreen(game,"���������㣬�޷���ϰ�����Ÿ����书��",false));
					return false;
				}
				else if(GmudWorld.mc.skills[14]<100)
				{
					game.setScreen(new TalkingScreen(game,"���Ԫһ������򲻹����޷���ϰ�����Ÿ����书��",false));
					return false;
				}
				else if(GmudWorld.mc.skills[11]<100)
				{
					game.setScreen(new TalkingScreen(game,"���Ե������ɾ�ѧ���뵱���Ϸ��ƾһ�Ѱ����Ͻ𵶴������£��㻹���Ƚ�����������˵�ɡ�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ܺã�û�뵽�Ϸ���������������ŵ��ӡ�",false));
					GmudWorld.mc.faction=1;
					return true;
				}
			case 56:
				if(GmudWorld.mc.sex == 1){
					game.setScreen(new TalkingScreen(game,"�һ���������˫�ޣ����Ŭ���ɡ�",false));
					GmudWorld.mc.faction=3;
					return true;
				}
				else{
					game.setScreen(new TalkingScreen(game,"�һ���������ֻ��Ů���ӣ��㻹��������ʦ�ɡ�",false));
					return false;
				}
			case 57:
				if(GmudWorld.mc.skills[19] < 60){
					game.setScreen(new TalkingScreen(game,"��һ��÷���ֹ�����δ���죬���й�������ѧ�ã�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"������Ҫ��ֻ�տ���Ů�ӡ������������ðɣ��Ҿ��������ˡ�",false));
					GmudWorld.mc.faction=3;
					return true;
				}
			case 66:
				if(GmudWorld.mc.skills[19] < 50){
					game.setScreen(new TalkingScreen(game,"��һ��÷���ֹ�����δ���죬���й�������ѧ�ã�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"������Ҫ��ֻ�տ���Ů�ӡ������������ðɣ��Ҿ��������ˡ�",false));
					GmudWorld.mc.faction=3;
					return true;
				}
			case 58:
				if(GmudWorld.mc.maxfp < 1000)
				{
					game.setScreen(new TalkingScreen(game,"��������Ϊ���㣬������ȥ���޺��������ɣ�",false));
					return false;
				}
				else if(GmudWorld.mc.skills[9]<100)
				{
					game.setScreen(new TalkingScreen(game,"�һ����ɸ�·�书���������⣬�����ʶ�ֻ��������������������书��",false));
					return false;
				}
				else if(GmudWorld.mc.getface() < 28)
				{
					game.setScreen(new TalkingScreen(game,"�ҵĵմ�����Ī���Ǵ�����������ò�绨�����������������һ����ɵ���ͷ��",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"����������������ĵ����������Ҳ�����£�Ϊʦһ���úõ㲦���㡣",false));
					GmudWorld.mc.faction=3;
					return true;
				}
			case 73:
				game.setScreen(new TalkingScreen(game,"�ܺã��μǺ������壬���������书�ɡ�",false));
				GmudWorld.mc.faction=5;
				return true;
			case 80:
				if(GmudWorld.mc.skills[25]<90)
				{
					game.setScreen(new TalkingScreen(game,"������ͬ���ķ���򲻹����޷���ϰ��������ѧ��",false));
					return false;
				}
				else if(GmudWorld.mc.getStr() < 30)
				{
					game.setScreen(new TalkingScreen(game,"���������㣬�޷�����������ȷ��ľ��衣",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ܺã��μǺ������壬���������书�ɡ�",false));
					GmudWorld.mc.faction=5;
					return true;
				}
			case 90:
				game.setScreen(new TalkingScreen(game,"�����Һú����ɣ������Ժ�ɻ��ڴ",false));
				GmudWorld.mc.faction=4;
				return true;
			case 87:
				if(GmudWorld.mc.skills[27]<60)
				{
					game.setScreen(new TalkingScreen(game,"һ�����������������ֺ��������޷�ȭ��Ϊ���Ҳ�����������������书��",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�����Һú����ɣ������Ժ�ɻ��ڴ",false));
					GmudWorld.mc.faction=4;
					return true;
				}
			case 94:
				if(GmudWorld.mc.skills[26]<120)
				{
					game.setScreen(new TalkingScreen(game,"��ɣ����ȫ������֧�֣��㻹����ȥ���޺��������ɣ�",false));
					return false;
				}
				else if(GmudWorld.mc.getStr() < 32)
				{
					game.setScreen(new TalkingScreen(game,"����һ�����������������ƣ��������������н����ģ�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"��Ҫ���Ŭ�������ҷ�ɣ����һ�ɾ�ѧ������",false));
					GmudWorld.mc.faction=4;
					return true;
				}
			case 96:
			case 97:
				game.setScreen(new TalkingScreen(game,"�ѵ�����־��ѧ���������Ե�̫�����겻���ˣ�����г���֮�Ĳ�����̫�����г���ͷ�ء�",false));
				GmudWorld.mc.faction=2;
				return true;
			case 101:
				if(GmudWorld.mc.maxfp < 1500)
				{
					game.setScreen(new TalkingScreen(game,"���������㣬�޷���ϰ���Ҹ����书��",false));
					return false;
				}
				else if(GmudWorld.mc.skills[32]<120)
				{
					game.setScreen(new TalkingScreen(game,"��̫���񹦻�򲻹����޷���ϰ���Ҹ����书��",false));
					return false;
				}
				else if(GmudWorld.mc.skills[31]<100)
				{
					game.setScreen(new TalkingScreen(game,"̫��ȭ�����ɾ���������ר�Ľ���������˵�ɡ�",false));
					return false;
				}
				else if(GmudWorld.mc.getWxg() < 28)
				{
					game.setScreen(new TalkingScreen(game,"̫�����������ڽ��ȣ����Բ��������������",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ܺã�û�뵽�Ϸ�����֮�����ٵ�һ����֮�š�",false));
					GmudWorld.mc.faction=2;
					return true;
				}
			case 122:
				if(GmudWorld.mc.getAgi() < 22)
				{
					game.setScreen(new TalkingScreen(game,"��ѩɽ����ѧ��ּΪ����������ҿ���������ƺ����ˣ�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ܺ�,��������ڼ���ϰ���պ����ܺͷ�ʦ�ֻ����ү��ѧ�ϼ��У��ǿ��������á�",false));
					GmudWorld.mc.faction=6;
					return true;
				}
			case 118:
				if(GmudWorld.mc.getAgi() < 23)
				{
					game.setScreen(new TalkingScreen(game,"��ѩɽ����ѧ��ּΪ����������ҿ���������ƺ����ˣ�",false));
					return false;
				}
				else if(GmudWorld.mc.skills[36]<40)
				{
					game.setScreen(new TalkingScreen(game,"�����ڵ�ѩɽ�ڹ�̫�������޷���ᾫ���ѩɽ����������ѧ�������ɡ�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ܺã�����Ŭ����������ȡ��ѩɽ�����������з�����",false));
					GmudWorld.mc.faction=6;
					return true;
				}
			case 110:
				if(GmudWorld.mc.maxfp < 1200)
				{
					game.setScreen(new TalkingScreen(game,"��ѩɽ�����书ѩӰ��������Ҫ��������ſ����ã��ҿ��㻹����ȥ���޺��������ɣ�",false));
					return false;
				}
				else if(GmudWorld.mc.getBon() < 32)
				{
					game.setScreen(new TalkingScreen(game,"��������ǿ������������̫������������㻹���ȴ�û�������˵�ɣ�",false));
					return false;
				}
				else
				{
					game.setScreen(new TalkingScreen(game,"�ܺã�����Ŭ�������ձ������ɡ�",false));
					GmudWorld.mc.faction=6;
					return true;
				}
			default:
				return false;
			}
		else
			return false;
		
		
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		BLGGraphics g=(BLGGraphics) game.getGraphics();
		Npc t = GmudWorld.npc[npcid];
		final int TOP = 2;
		final int LEFT = 8;

		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		g.drawRect(LEFT, TOP, t.name.length() * 12, 12,GameConstants.BG_COLOR);
		g.drawText(t.name, LEFT, TOP, FontSize.FT_12PX);
		dummyBorder.draw();
		for(int i=0;i<3;i++)
		{
			buttons[i].draw();
		}
		if(havefourth)
			buttons[3].draw();
	}

	static GmudWindow[] getWindows(int npcid)
	{

		Npc t = GmudWorld.npc[npcid];
		havefourth = true;
		
		if(t.trading>100)
			if(t.qingjiaoable)
				fourth = 5;
			else
				fourth = 4;
		else if (t.trading>0)
			fourth = 3;
		else
			havefourth = false;

		NpcMenuButton[] tw = new NpcMenuButton[(havefourth?4:3)];

		for(int i = 0; i<3;i++)
		{
			tw[i] = new NpcMenuButton(GmudWorld.game, i);
		}
		if(havefourth)
			tw[3] = new NpcMenuButton(GmudWorld.game,fourth);



		return tw;

	}



}
