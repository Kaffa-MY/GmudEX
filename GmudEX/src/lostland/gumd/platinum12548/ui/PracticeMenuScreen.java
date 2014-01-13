/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SysMenuScreen.java <p>
 * ����ʱ�䣺2013-7-22 ����11:33:22 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.util.Log;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.core.GmudWindow;
import lostland.gumd.platinum12548.ui.core.MenuScreen;

/**
 * ������SysMenuScreen <p>
 * ˵����ϵͳ�˵�
 * @author 12548
 */
public class PracticeMenuScreen extends MenuScreen {

	
	/**
	 * @param game
	 */
	public PracticeMenuScreen(IGame game) {
		super(game,getWindows());
		int n=0;
		dummyBorder = new PracticeMenuBorder((GmudGame) game);
		if(GmudWorld.mc.skillsckd[0]>10)n++;
		if(GmudWorld.mc.skillsckd[1]>10)n++;
		if(GmudWorld.mc.skillsckd[2]>10)n++;
		
		if(n==0)
		{
			game.setScreen(GmudWorld.mms);
			return;
		}
		
	}




	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		if(GmudWorld.mc.skillsckd[3] == -1)
			game.setScreen(new NotificationScreen(game,this,"����ѡ����Ҫ�õ��ڹ��ķ���"));
		else switch(((PracticeMenuButton)buttons[index]).item)
		{
		case 0:
			if(GmudWorld.mc.skills[GmudWorld.mc.skillsckd[0]]> GmudWorld.mc.skills[GmudWorld.skill[GmudWorld.mc.skillsckd[0]].getBasicSkill().id])
				game.setScreen(new NotificationScreen(game,this,"��Ĺ����������������ˣ�������ʦ������°�"));
			else if(!GmudWorld.mc.expcanlearn(GmudWorld.mc.skills[GmudWorld.mc.skillsckd[0]]+1))
				game.setScreen(new NotificationScreen(game,this,"�����ѧ���鲻�㣬�޷�������Ĺ���"));
			else if(GmudWorld.mc.maxfp < GmudWorld.mc.skills[GmudWorld.mc.skillsckd[0]]+1)
				game.setScreen(new NotificationScreen(game,this,"���������Ϊ���㣬Ҫ�����ڹ���"));
			else
				game.setScreen(new PracticingScreen(game,this,GmudWorld.mc.skillsckd[0]));
			break;
		case 1:
			if(GmudWorld.mc.skills[GmudWorld.mc.skillsckd[1]]> GmudWorld.mc.skills[GmudWorld.skill[GmudWorld.mc.skillsckd[1]].getBasicSkill().id])
				game.setScreen(new NotificationScreen(game,this,"��Ĺ����������������ˣ�������ʦ������°�"));
			else if(GmudWorld.skill[Skill.eqpbias2[GmudWorld.wp[GmudWorld.mc.itemsckd[0]].subkind]].subkind != GmudWorld.skill[GmudWorld.mc.skillsckd[1]].subkind)
				game.setScreen(new NotificationScreen(game,this,"���ֵı�����û��һ�ѣ�Ϲ�Ȼ�ʲô��"));
			else if(!GmudWorld.mc.expcanlearn(GmudWorld.mc.skills[GmudWorld.mc.skillsckd[1]]+1))
				game.setScreen(new NotificationScreen(game,this,"�����ѧ���鲻�㣬�޷�������Ĺ���"));
			else if(GmudWorld.mc.maxfp < GmudWorld.mc.skills[GmudWorld.mc.skillsckd[1]]+1)
				game.setScreen(new NotificationScreen(game,this,"���������Ϊ���㣬Ҫ�����ڹ���"));
			else
				game.setScreen(new PracticingScreen(game,this,GmudWorld.mc.skillsckd[1]));
			break;
		case 2:
			boolean  d1,d2,d3;
			
			d1 = GmudWorld.mc.skills[GmudWorld.mc.skillsckd[2]] > GmudWorld.mc.skills[GmudWorld.skill[GmudWorld.mc.skillsckd[2]].getBasicSkill().id];
			Log.w("Practicemenu", "d1");
			d2 = !GmudWorld.mc.expcanlearn(GmudWorld.mc.skills[GmudWorld.mc.skillsckd[2]]+1);
			Log.w("Practicemenu", "d2");
			d3 = GmudWorld.mc.maxfp < GmudWorld.mc.skills[GmudWorld.mc.skillsckd[2]]+1;
			Log.w("Practicemenu", "d3");
			if(d1)
				game.setScreen(new NotificationScreen(game,this,"��Ĺ����������������ˣ�������ʦ������°�"));
			else if(d2)
				game.setScreen(new NotificationScreen(game,this,"�����ѧ���鲻�㣬�޷�������Ĺ���"));
			else if(d3)
				game.setScreen(new NotificationScreen(game,this,"���������Ϊ���㣬Ҫ�����ڹ���"));
			else
				game.setScreen(new PracticingScreen(game,this,GmudWorld.mc.skillsckd[2]));
			break;
		}
		
		
	}

	
	static GmudWindow[] getWindows()
	{
		int n=0,i=0;
		if(GmudWorld.mc.skillsckd[0]>10)n++;
		if(GmudWorld.mc.skillsckd[1]>10)n++;
		if(GmudWorld.mc.skillsckd[2]>10)n++;
		PracticeMenuButton[] tw = new PracticeMenuButton[n];
		
		if(n==0)
		{
			GmudWorld.game.setScreen(GmudWorld.mms);
			return tw;
		}
		
		if(GmudWorld.mc.skillsckd[0]>10)tw[i] = new PracticeMenuButton(GmudWorld.game,i++,0);
		if(GmudWorld.mc.skillsckd[1]>10)tw[i] = new PracticeMenuButton(GmudWorld.game,i++,1);
		if(GmudWorld.mc.skillsckd[2]>10)tw[i] = new PracticeMenuButton(GmudWorld.game,i++,2);

		return tw;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		game.setScreen(GmudWorld.mms);
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		if(buttons.length==0)
		{
			game.setScreen(GmudWorld.mms);
			return;
		}
		
		GmudWorld.ms.present(-1);
		dummyBorder.draw();
		for(GmudWindow i:buttons)
		{
			i.draw();
		}
	}
}
