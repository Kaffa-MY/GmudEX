/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ViewScreen.java <p>
 * ����ʱ�䣺2013-8-5 ����1:43:22 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle;

import android.util.Log;
import lostland.gumd.platinum12548.Assets;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.BasicScreen;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;

/**
 * ������ViewScreen <p>
 * ˵����
 * @author 12548
 */
public class ViewScreen extends CScreen {

	private static String text = "��˸£�";
	public static boolean hit = false;
	
	public static void setText(String s)
	{
		Log.w("�趨���֣�",s);
		text = s;
	}
	
	
	public static float LAST_TIME = 1.4f;
	static float time = 0;
	
	/**
	 * @param game
	 */
	public ViewScreen(IGame game) {
		super(game);
		Log.w("��ʾ���֣�",text);
		time = 0;
		BasicScreen.recheck();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		time += deltaTime;
		if(time>=LAST_TIME)
		{
			Log.w("������ʾʱ�䣺",time+"");
			time = 0;
			game.setScreen(GmudWorld.bs);
		}
		
		if(text.endsWith("#hit#")) {
			text = text.substring(0, text.length()-5);
			hit = true;
		}
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		GmudWorld.bs.present(deltaTime);
		BLGGraphics g=(BLGGraphics) game.getGraphics();
		g.drawRect(64,96, 192, 96, GameConstants.BG_COLOR);
		g.drawText(text,64,96, FontSize.FT_16PX, 190);
		if(hit)
			if(GmudWorld.bs.zdp == GmudWorld.mc)
				g.drawPixmap(Assets.boom, 32*7+10, 42);
			else
				g.drawPixmap(Assets.boom, 74, 42);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#pause()
	 */
	@Override
	public void pause() {
		hit = false;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#resume()
	 */
	@Override
	public void resume() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#dispose()
	 */
	@Override
	public void dispose() {
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#isStable()
	 */
	@Override
	public boolean isStable() {

		return true;
	}

}
