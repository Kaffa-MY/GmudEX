/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����YesNoScreen.java <p>
 * ����ʱ�䣺2013-8-24 ����4:52:40 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.TalkingWindow;

/**
 * ������YesNoScreen <p>
 * ˵����
 * @author 12548
 */
public abstract class YesNoScreen extends MenuScreen {

	String s;
	TalkingWindow window;
	
	
	/**
	 * @param game
	 */
	public YesNoScreen(IGame game,String s) {
		super(game,new YesNoButton[]{
				new YesNoButton((GmudGame) game,0),
				new YesNoButton((GmudGame) game,1)
		});
		this.s = s;
		window = new TalkingWindow((GmudGame) game,s, false);
		this.dummyBorder = new GmudWindow((GmudGame) game, 25, 25, 27, 27){

			@Override
			public void draw() {
				this.drawBackground();
			}
		};
//		this.buttons = new YesNoButton[2];
//		this.buttons[0] = new YesNoButton((GmudGame) game,0);
//		this.buttons[1] = new YesNoButton((GmudGame) game,1);
	}
 
	protected abstract void onYes();
	protected abstract void onNo();
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		if(index==0)
			onYes();
		else
			onNo();
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		window.draw();
		dummyBorder.draw();
		for(int i=0;i<2;i++)
		{
			buttons[i].draw();
		}
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#isStable()
	 */
	@Override
	public boolean isStable() {
		return false;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		onNo();
	}

}
