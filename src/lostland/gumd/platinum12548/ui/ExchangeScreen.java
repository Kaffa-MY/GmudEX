/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ExchangeScreen.java <p>
 * ����ʱ�䣺2013-8-24 ����5:19:22 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.util.Log;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.ui.core.YesNoScreen;

/**
 * ������ExchangeScreen <p>
 * ˵����
 * @author 12548
 */
public class ExchangeScreen extends YesNoScreen {
	boolean fail = true;
	int change ,count ,forwp;
	String s2;
	
	/**
	 * @param game
	 * @param s
	 */
	public ExchangeScreen(IGame game, String s,String s2,int change ,int count ,int forwp) {
		super(game, s);
		fail = false;
		this.change = change;
		this.count = count;
		this.forwp = forwp;
		this.s2 = s2;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		if(deltaTime == 0 && GmudWorld.mc.inventory[change]<count){
			Log.w("Exchanging", "fail");
			fail = true;
			GmudWorld.game.setScreen(GmudWorld.ms);
			return;
		}
		if(fail){
			GmudWorld.game.setScreen(GmudWorld.ms);
			return;
		}
		super.update(deltaTime);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.YesNoScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		if(fail){
			GmudWorld.game.setScreen(GmudWorld.ms);
			return;
		}
		super.present(deltaTime);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.YesNoScreen#onYes()
	 */
	@Override
	protected void onYes() {
		GmudWorld.mc.drop(change, count);
		GmudWorld.mc.give(forwp);
		GmudWorld.game.setScreen(new TalkingScreen(game,s2, false));
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.YesNoScreen#onNo()
	 */
	@Override
	protected void onNo() {
		GmudWorld.game.setScreen(GmudWorld.ms);
	}

}
