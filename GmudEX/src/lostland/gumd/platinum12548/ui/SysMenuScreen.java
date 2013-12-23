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
import lostland.gumd.platinum12548.SavingScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.SingleTouchHandler;
import lostland.gumd.platinum12548.ui.core.MenuScreen;
import lostland.gumd.platinum12548.ui.core.NewButton;

/**
 * ������SysMenuScreen <p>
 * ˵����ϵͳ�˵�
 * @author 12548
 */
public class SysMenuScreen extends MenuScreen {

	
	/**
	 * @param game
	 */
	public SysMenuScreen(IGame game) {
		super(game,new SysMenuButton[]{
				new SysMenuButton((GmudGame) game,0),
				new SysMenuButton((GmudGame) game,1),
				new SysMenuButton((GmudGame) game,2),
				new SysMenuButton((GmudGame) game,3)
		});
		dummyBorder = new SysMenuBorder((GmudGame) game);

	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		switch(index){
		case 0:
			game.setScreen(new InnerMenuScreen(game));
			break;
		case 1:
			if(GmudWorld.mc.hp < GmudWorld.mc.maxhp)
				game.setScreen(new NotificationScreen(game,this,"�������ˣ�����������Ҫ����"));
			else
				game.setScreen(new PracticeMenuScreen(game));
			break;
		case 2:
			game.setScreen(new SavingScreen(game));
			break;
		case 3:
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




	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		GmudWorld.mms.present(0);
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
		if(b == NewButton.NB_ENTER)
		{
			if(cursor == 3)
				SingleTouchHandler.flag = 10;
		}
		super.onButtonDown(b);
	}
	
	
}
