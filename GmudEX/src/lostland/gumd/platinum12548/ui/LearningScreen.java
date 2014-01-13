/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����LearningScreen.java <p>
 * ����ʱ�䣺2013-9-3 ����12:51:49 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.core.ProgressScreen;
import lostland.gumd.platinum12548.ui.core.YesNoScreen;

/**
 * ������LearningScreen <p>
 * ˵����
 * @author 12548
 */
public class LearningScreen extends ProgressScreen {

	int sklid;
	int limit;

	
	
	/**
	 * @param game
	 * @param bg
	 * @param ticktime
	 * @param speed
	 * @param max
	 * @param now
	 */
	public LearningScreen(IGame game, CScreen bg, int sklid, int limit) {
		super(game, bg, GameConstants.TICK_TIME, GmudWorld.mc.getWxg()/2+GmudWorld.mc.skills[sklid], (GmudWorld.mc.skills[sklid]+1)*(GmudWorld.mc.skills[sklid]+1), GmudWorld.mc.learning[sklid],GmudWorld.mc.skills[sklid]);
		this.sklid =sklid;
		this.limit = limit;
	}

	
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#onComplete()
	 */
	@Override
	public void onComplete() {
		GmudWorld.mc.skills[sklid]++;
		GmudWorld.mc.learning[sklid] = 0;
		bg.resume();
		game.setScreen(new YesNoScreen(game,"����ѧϰ��"){
			
			@Override
			protected void onYes() {
				
				if(!GmudWorld.mc.expcanlearn(GmudWorld.mc.skills[sklid]+1))
					game.setScreen(new NotificationScreen(game,bg,"�����ѧ���鲻�㣬�޷�������Ĺ���"));
				else if(GmudWorld.mc.skills[sklid] > limit)
					game.setScreen(new NotificationScreen(game,bg,"��Ĺ����Ѿ�����Ϊʦ�ˣ����ǿ�ϲ�ɺ�ѽ��"));
				else
					game.setScreen(new LearningScreen(game,bg,sklid,limit));
			}

			@Override
			protected void onNo() {
				game.setScreen(bg);
			}
			
		});

	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#tick()
	 */
	@Override
	public void tick() {
		if(sklid == Skill.KIND_ZHISHI)
		{
			int cost;
			if(GmudWorld.mc.skills[sklid] < 20)
				cost = 5;
			else if(GmudWorld.mc.skills[sklid] < 30)
				cost = 10;
			else if(GmudWorld.mc.skills[sklid] < 50)
				cost = 50;
			else if(GmudWorld.mc.skills[sklid] < 60)
				cost = 100;
			else if(GmudWorld.mc.skills[sklid] < 80)
				cost = 150;
			else if(GmudWorld.mc.skills[sklid] < 100)
				cost = 300;
			else if(GmudWorld.mc.skills[sklid] < 120)
				cost = 500;
			else
				cost = 1000;
			
			if(GmudWorld.mc.gold < cost)
			{
				game.setScreen(new NotificationScreen(game,bg,"ûǮ��ʲô�鰡����ȥ�ܹ�ѧ�������ɣ�"));
				ok = false;
				return;
			}
			else
			{
				GmudWorld.mc.gold -= cost;
			}
		}
		
	
		
		GmudWorld.mc.setPotential(GmudWorld.mc.potential-1);
		if(GmudWorld.mc.potential == 0)
		{
			game.setScreen(new NotificationScreen(game,bg,"���Ǳ���Ѿ����ӵ�������"));
			ok = false;
			return;
		}
		
		
		
		super.tick();
	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#binding(int)
	 */
	@Override
	protected void binding(int now) {
		GmudWorld.mc.learning[sklid] = now;
	}






}
