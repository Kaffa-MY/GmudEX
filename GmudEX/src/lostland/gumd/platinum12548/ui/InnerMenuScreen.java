/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SysMenuScreen.java <p>
 * ����ʱ�䣺2013-7-22 ����11:33:22 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.SingleTouchHandler;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.core.MenuScreen;
import lostland.gumd.platinum12548.ui.core.NewButton;

/**
 * ������SysMenuScreen <p>
 * ˵����ϵͳ�˵�
 * @author 12548
 */
public class InnerMenuScreen extends MenuScreen {


	/**
	 * @param game
	 */
	public InnerMenuScreen(IGame game) {
		super(game, new InnerMenuButton[]{
				new InnerMenuButton((GmudGame) game,0),
				new InnerMenuButton((GmudGame) game,1),
				new InnerMenuButton((GmudGame) game,2),
				new InnerMenuButton((GmudGame) game,3)
		});
		dummyBorder = new InnerMenuBorder((GmudGame) game);

		GmudWorld.ims = this;
	}




	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		if(GmudWorld.mc.skillsckd[3] == -1)
			game.setScreen(new NotificationScreen(game,this,"����ѡ����Ҫ�õ��ڹ��ķ���"));
		else switch(index){
		case 0:
			game.setScreen(new SittingScreen(game,GmudWorld.ms));
			break;
		case 1:

			break;
		case 2:
			if(GmudWorld.mc.sp >= GmudWorld.mc.hp)
			{
				game.setScreen(new NotificationScreen(game,this,"�������������档"));
			}
			else if(GmudWorld.mc.fp == 0)
			{
				game.setScreen(new NotificationScreen(game,this,"�������������"));
			}
			else
			{
				GmudWorld.mc.xiqi();
				game.setScreen(new NotificationScreen(game,this,"���������˿�������ɫ�������ö��ˡ�"));
			}
			break;
		case 3:
			if(GmudWorld.mc.fp<60)
			{
				game.setScreen(new NotificationScreen(game,this,"��������������������ˡ�"));
			}
			else if(GmudWorld.mc.hp==GmudWorld.mc.maxhp)
			{
				game.setScreen(new NotificationScreen(game,this,"�����ڲ�û������!"));
			}
			else if(GmudWorld.mc.hp < GmudWorld.mc.maxhp * 0.3)
			{
				game.setScreen(new NotificationScreen(game,this,"�������˹��أ�ֻ��һ��������������Σ�ա�"));
			}
			else if(GmudWorld.mc.skills[Skill.KIND_NEIGONG] < 30 || GmudWorld.mc.skills[GmudWorld.mc.skillsckd[3]] < 30)
			{
				game.setScreen(new NotificationScreen(game,this,"���˹����ã�һ�����䣬��̾һ��վ��������"));
			}
			else
			{
				GmudWorld.mc.fp-=60;
				GmudWorld.mc.hp += GmudWorld.mc.maxhp * 0.05;
				if(GmudWorld.mc.hp>GmudWorld.mc.maxhp)GmudWorld.mc.hp=GmudWorld.mc.maxhp;
				game.setScreen(new NotificationScreen(game,new NotificationScreen(game,this,"��߶�����������һ���һ��죬�۵�һ�����³�һ����Ѫ����ɫ�������ö��ˡ�"),"��ȫ����ɣ���������ʼ�˹����ˡ�"));
			}
			break;
		}
		
		
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		game.setScreen(GmudWorld.mms);
	}



//	/* ���� Javadoc��
//	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onTouchDown(int, int)
//	 */
//	@Override
//	protected void onTouchDown(int tx, int ty) {
//		if(buttons[1].inBound(tx, ty) && GmudWorld.mc.skillsckd[3] != -1)
//			SingleTouchHandler.flag = 1;
//		super.onTouchDown(tx, ty);
//	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		GmudWorld.ms.present(-1);
		dummyBorder.draw();
		for(int i=0;i<4;i++)
		{
			buttons[i].draw();
		}
	}




	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onButtonDown(lostland.gumd.platinum12548.ui.core.NewButton)
	 */
	@Override
	protected void onButtonDown(NewButton b) {
		if(cursor == 1 && b == NewButton.NB_ENTER)
		{
			SingleTouchHandler.flag = 1;
		}
		super.onButtonDown(b);
	}




	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#isStable()
	 */
	@Override
	public boolean isStable() {
		return false;
	}
}
