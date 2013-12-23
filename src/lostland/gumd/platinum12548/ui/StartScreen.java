/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����StartScreen.java <p>
 * ����ʱ�䣺2013-9-5 ����8:18:55 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.util.Log;
import lostland.gumd.platinum12548.Direction;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.MapScreen;
import lostland.gumd.platinum12548.SavingScreen;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.IInput;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.blgframework.impl.SingleTouchHandler;

/**
 * ������StartScreen <p>
 * ˵����
 * @author 12548
 */
public class StartScreen extends CScreen {

	public static boolean flag = false;
	
	String s = "�������û����֮ǰ����һֱ��ƽ" +
			"��������������������û�з�������" +
			"ô�һ���Ȼ����ƽ�������е㵥���ؼ���" +
			"������ȥ���������������Ƿ����ˣ���" +
			"�����ڣ����Ұ��°�ť��ʱ��������" +
			"��Զ�Ŵ�½Ӣ��̳��ʱ��ת��װ�á���" +
			"�Ҵ�ʱ��Ť����ǿ�������лָ�֪����" +
			"ʱ�����Ѿ���������Ƭ��˵�����ص�" +
			"���ء������޷���֤���������������" +
			"�ط���������ԭƫ����λ�ã�һ������" +
			"��С��С���������˻��ӣ���������" +
			"�������ǵĽ�̸���ҵ�֪����У�ƽ��" +
			"С�򣢡�������ע���Լ���ʱ��ŷ���" +
			"���ұ����һ��ʮ��������꣡������" +
			"ʲô���ܣ��������Ӣ�۵���¯����а" +
			"���ԨԴ���Ҳ�֪������ֻ֪�����ӽ�" +
			"�Ժ��ҵ������ȫ�ı䣮����";
	
	int x =170;
	
	public StartScreen(IGame game) {
		super(game);
	}

	boolean b=false;
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		
		if(GmudWorld.ms == null)
			GmudWorld.ms = new MapScreen(game);
		
		GmudWorld.ms.X = 0;
		GmudWorld.ms.Y = 1;
		MainCharTile.X=4;
		MainCharTile.Y=3;
		MainCharTile.currentDirection= Direction.DOWN;
		
		GmudWorld.ms.map = GmudWorld.map[0];
		
		x-=5;
		if(flag){
			new SavingScreen(GmudWorld.game).save();
			Log.w("SS", "1");

			GmudWorld.game.setScreen(GmudWorld.ms);
			Log.w("SS", "2");
		}
		else {
			game.getInput().getKeyEvents();
			game.getInput().getTouchEvents();
			IInput i= game.getInput();
			if(i.isTouchDown(0))
				SingleTouchHandler.flag = 4;
		}
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		BLGGraphics g=(BLGGraphics) game.getGraphics();
		g.clear(GameConstants.BG_COLOR);
		
		g.drawText(s, 0, x/10, FontSize.FT_16PX, 320);
		
		g.drawRect(0, 0, 320, 16, GameConstants.BG_COLOR);
		g.drawText("==============�׽�Ӣ��̳==============", 0, 0, FontSize.FT_16PX,999);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#pause()
	 */
	@Override
	public void pause() {
		// TODO �Զ����ɵķ������

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
		// TODO �Զ����ɵķ������

	}

}
