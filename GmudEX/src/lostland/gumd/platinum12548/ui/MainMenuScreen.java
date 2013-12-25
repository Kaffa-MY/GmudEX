/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MainMenuScreen.java <p>
 * ����ʱ�䣺2013-7-9 ����7:49:41 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.util.Log;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.core.MenuScreen;
import lostland.gumd.platinum12548.ui.core.NewButton;

/**
 * ������MainMenuScreen <p>
 * ˵�������˵����氡����a
 * @author 12548
 */
public class MainMenuScreen extends MenuScreen {


	boolean td,pretd;
	int downx,downy;
	
	/**
	 * @param game
	 */
	public MainMenuScreen(IGame game) {
		super(game,new MainMenuButton[]{
				new MainMenuButton((GmudGame) game,0),
				new MainMenuButton((GmudGame) game,1),
				new MainMenuButton((GmudGame) game,2),
				new MainMenuButton((GmudGame) game,3)
		});
		Log.w("MainMenuScreen", "creating");
		dummyBorder = new MainMenuBorder((GmudGame) game);

	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		switch(index)
		{
		case 0:
			game.setScreen(new StatusScreen(game));
			break;
		case 1:
			game.setScreen(new InventoryScreen(game,false,this));
			break;
		case 2:
			game.setScreen(new SkillScreen(game,this));
			break;
		case 3:
			game.setScreen(new SysMenuScreen(game));
			break;
		}
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		game.setScreen(GmudWorld.ms);
	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		dummyBorder.draw();
		for(int i=0;i<4;i++)
			buttons[i].draw();
	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onButtonDown(lostland.gumd.platinum12548.ui.core.NewButton)
	 */
	@Override
	protected void onButtonDown(NewButton b) {
		if(b == NewButton.NB_ENTER)
			if(cursor == 1)
				;
//				SingleTouchHandler.flag = 6;
			else if(cursor == 2)
				;
//				SingleTouchHandler.flag = 5;
		super.onButtonDown(b);
	}
	
}
