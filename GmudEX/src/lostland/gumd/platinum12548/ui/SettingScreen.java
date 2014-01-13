/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����SettingScreen.java <p>
 * ����ʱ�䣺2014-1-11 ����5:20:21 <p>
 * ������Ŀ��GmudEX <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.MapScreen;
import lostland.gumd.platinum12548.SavingScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.core.MenuScreen;
import lostland.gumd.platinum12548.ui.core.NewButton;

/**
 * ������SettingScreen <p>
 * ˵����
 * @author 12548
 */
public class SettingScreen extends MenuScreen {


	static StatusBorder nborder;
	
	static final String s[][] = new String[][] {
		{"��λ����ͳ��λ","��λ����׼��λ"},
		{"��ʾ�˵�������","��ʾ�˵�������"},
		{"���ؼ��˳�����","���ؼ��˳�����"},
		{"������Ӧ���ߣ���","������Ӧ���ߣ���"}
	};

	static int pointer[];


	/**
	 * @param game
	 * @param buttons
	 */
	public SettingScreen(IGame game) {
		super(game, getButtons());
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		pointer[index]++;
		if(pointer[index] >= s[index].length)
			pointer[index] = 0;


		GmudGame.classickeymap = GmudWorld.int2bool(pointer[0]);
		NewButton.menubutton = GmudWorld.int2bool(pointer[1]);
		GmudGame.backkeyquit = GmudWorld.int2bool(pointer[2]);
		MapScreen.zlEnabled = GmudWorld.int2bool(pointer[3]);
		
		AutoButton ab = (AutoButton) buttons[index];
		ab.setS(s[index][pointer[index]]);
		
		SavingScreen.savePerf();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onCancel()
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
		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		nborder.draw();
		
		for(int i=0;i<buttons.length;i++)
			buttons[i].draw();
	}

	static AutoButton[] getButtons()
	{
		pointer = new int[s.length];
		pointer[0] = GmudWorld.bool2int(GmudGame.classickeymap);
		pointer[1] = GmudWorld.bool2int(NewButton.menubutton);
		pointer[2] = GmudWorld.bool2int(GmudGame.backkeyquit);
		pointer[3] = GmudWorld.bool2int(MapScreen.zlEnabled);

		nborder = new StatusBorder(GmudWorld.game);
		
		AutoButton t[];
		t = new AutoButton[s.length];
		for(int i = 0; i < s.length; i++)
		{
			t[i] = new AutoButton(GmudWorld.game,nborder.x + 1, nborder.y + 1 + i * 12, s[i][pointer[i]]);
		}
		
		return t;
	}


}
