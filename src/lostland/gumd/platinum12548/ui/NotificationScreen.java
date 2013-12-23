/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����NotificationScreen.java <p>
 * ����ʱ�䣺2013-8-5 ����1:43:22 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.util.Log;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.SlowScreen;

/**
 * ������NotificationScreen <p>
 * ˵����
 * @author 12548
 */
public class NotificationScreen extends SlowScreen {

	private String text = "��˸£�";
	
	
	static float time = 0;
	
	/**
	 * @param game
	 */
	public NotificationScreen(IGame game,CScreen bg,String s) {
		super(game,bg,0.8f);
		Log.w("��ʾ���֣�",text);
		time = 0;
		this.text = s;
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.SlowScreen#tick()
	 */
	@Override
	public void tick() {
		game.setScreen(bg);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.FixedScreen#draw()
	 */
	@Override
	public void draw() {
		BLGGraphics g=(BLGGraphics) game.getGraphics();
		g.drawRect(GameConstants.FBWIDTH/2-80, GameConstants.FBHEIGHT/2-25, 160, 50, GameConstants.BG_COLOR);
		g.drawText(text, GameConstants.FBWIDTH/2-80, GameConstants.FBHEIGHT/2-25, FontSize.FT_12PX, 150);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DialogScreen#onClick(int, int)
	 */
	@Override
	protected void onClick(int tx, int ty) {
		// Do nothing
	}




}
