/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SittingScreen.java <p>
 * ����ʱ�䣺2013-8-30 ����2:54:19 <p>
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

/**
 * ������SittingScreen <p>
 * ˵����
 * @author 12548
 */
public class SittingScreen extends ProgressScreen {

	public static int s_now,s_max,s_smax;
	
	

	public SittingScreen(IGame game, CScreen bg) {
		super(game, bg, GameConstants.TICK_TIME, 
				GmudWorld.mc.getBon()/5 + GmudWorld.mc.skills[Skill.KIND_NEIGONG]/20 +GmudWorld.mc.skillsckd[3]/10 + Math.max(0, (GmudWorld.mc.getMaxmaxfp() - GmudWorld.mc.maxfp) / 20 ), 
				GmudWorld.mc.maxfp*2,GmudWorld.mc.fp,GmudWorld.mc.maxfp);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.ProgressScreen#onComplete()
	 */
	@Override
	public void onComplete() {
		if(GmudWorld.mc.maxfp<GmudWorld.mc.getMaxmaxfp())
		{
			GmudWorld.mc.maxfp++;
			GmudWorld.mc.fp = 0;
			game.setScreen(new SittingScreen(game,bg));
		}
		else
		{
			ok = false;
			GmudWorld.mc.fp = GmudWorld.mc.maxfp;
			game.setScreen(new NotificationScreen(game,GmudWorld.ms,"����ڹ��ȼ�������"));
		}
	}

	

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#binding(int)
	 */
	@Override
	protected void binding(int now) {
		GmudWorld.mc.fp = now;
		s_now = now;
		s_max = max;
		s_smax = smax;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ProgressScreen#draw()
	 */
	@Override
	public void draw() {
		super.draw();
//		BLGGraphics g=(BLGGraphics) game.getGraphics();
//		g.drawRect(0, 50, 144, 12, GameConstants.BG_COLOR);
//		g.drawText("���ֻ����ؼ�תΪ��̨����", 0, 51, FontSize.FT_12PX);
		
	}



}
