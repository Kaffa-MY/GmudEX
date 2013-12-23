/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MainMenuButton.java <p>
 * ����ʱ�䣺2013-6-30 ����11:20:13 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.util.Log;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.ArrowButton;

/**
 * ������MainMenuButton <p>
 * ˵����
 * @author 12548
 */
public class MainMenuButton extends ArrowButton {
	
	static final int MARGIN_TOP = 1;
	static final int MARGIN_LEFT = 2;
	static final int WIDTH = (160 - MARGIN_LEFT*2)/4;
	static final int HEIGHT = 20 - 2 * MARGIN_TOP;
	static final int PADDING_TOP = 3;
	static final int PADDING_LEFT = 9;
	final String S[] = {"�鿴","��Ʒ","����","����"};

	int index;
	
	public MainMenuButton(GmudGame game,int index)
	{
		super(game, MARGIN_LEFT + index*WIDTH, MARGIN_TOP, WIDTH, HEIGHT);
		Log.w("MainMenuButton", "creating");
		this.index = index;
		this.bordered=false;
		this.padding_top = PADDING_TOP;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.GmudWindow#draw()
	 */
	@Override
	public void draw() {
		drawBackground();
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		g.drawText(S[index], x+PADDING_LEFT, y+PADDING_TOP,FontSize.FT_12PX);

	}

}
