/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����PracticingScreen.java <p>
 * ����ʱ�䣺2013-8-31 ����10:41:44 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.core.ProgressScreen;

/**
 * ������PracticingScreen <p>
 * ˵����
 * @author 12548
 */
public class PracticingScreen extends ProgressScreen {

	int skild;
	/**
	 * @param game
	 * @param bg
	 * @param ticktime
	 * @param speed
	 * @param max
	 */
	public PracticingScreen(IGame game, CScreen bg, int sklid) {
		super(game, bg, GameConstants.TICK_TIME, 1+GmudWorld.mc.skills[GmudWorld.skill[sklid].getBasicSkill().id], (GmudWorld.mc.skills[sklid]+1)*(GmudWorld.mc.skills[sklid]+1),GmudWorld.mc.learning[sklid],GmudWorld.mc.skills[sklid]);
		this.skild = sklid;
	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#onComplete()
	 */
	@Override
	public void onComplete() { 
		GmudWorld.mc.skills[skild]++;
		GmudWorld.mc.learning[skild] = 0;

		if(GmudWorld.mc.skills[skild] > GmudWorld.mc.skills[GmudWorld.skill[skild].getBasicSkill().id])
			game.setScreen(new NotificationScreen(game,bg,"��Ĺ����������������ˣ�������ʦ������°�"));
		else if(!GmudWorld.mc.expcanlearn(GmudWorld.mc.skills[skild]+1))
			game.setScreen(new NotificationScreen(game,bg,"�����ѧ���鲻�㣬�޷�������Ĺ���"));
		else if(GmudWorld.mc.maxfp < GmudWorld.mc.skills[skild]+1)
			game.setScreen(new NotificationScreen(game,bg,"���������Ϊ���㣬Ҫ�����ڹ���"));
		else
			game.setScreen(new PracticingScreen(game,bg,skild));

	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#binding(int)
	 */
	@Override
	protected void binding(int now) {
		GmudWorld.mc.learning[skild] = now;
	}


}
