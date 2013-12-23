/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����StartScreen.java <p>
 * ����ʱ�䣺2013-9-5 ����8:18:55 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
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
public class FinishScreen extends CScreen {

	public static boolean flag = false;

	String s = "";

	int x =172;

	public FinishScreen(IGame game) {
		super(game);

		switch(GmudWorld.bs.enemyid)
		{
		case 124:
			s="����˭����Ҫ��Ϊ����Ĵ�����ң���ֻ�Ǿ���İ��š���ʵ�������������ɵĽᡭ��" +
					"                        �����������³������Ѿ�˵�Ĺ����ˡ�                " +
					"���ߵ���â�������룬������ʱ��ת���İ�ť��     " +
					"   ������������                    _END_";
			break;
		case 125:
			s="������ܣ�Ϊ����ν�����壬���Բ����ֶ�����ֻ�������Լ��������£��Ҵ�����" +
					"�����㣬һֱ�������������Ӱ�£�ʧȥ�����ң��ǲ��ǿɱ��ء�" +
					"                ס�ڣ�����������Ҳ��̸������" +
					"                    ������ܣ���ɱ������𣿿�ϧ�һ����������ټ��ˡ�" +
					"  ��֪ʲôʱ�򶫷���ܴ���ʱ��ת��װ�á�" +
					"������������С�ı�Ӱ���Һ�����ԥ�س�����ȥ��" +
					"                 ������������                    _END_";
			break;
		case 126:
			s = "���º��У���Ӯ�ˡ�������ʩ����ס�������ս�սʤа��ֻ��ϧ��ȴ��������һ���ˡ�" +
					"�������߽���һ��������ȥ��" +
					"���󿳽��޻��û���κ����������º�����һ˲����ʧ�ˡ��ѵ�˵������              " +
					"�䣭��                        �Ҿ���ط��֣���һ��ն����ʱ��ת��װ���ϡ�          " +
					"��Χ�ľ�����Ѹ�ٵı�����о���ͬ�������޾�����Ԩ��     ������������                     _END_";
			break;
		}

	}

	boolean b=false;

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#update(float)
	 */
	@Override
	public void update(float deltaTime) {
		x-=2;
		if(flag){
			new SavingScreen(GmudWorld.game).save();
			GmudWorld.ms.X = 2;
			GmudWorld.ms.Y = 3;
			GmudWorld.game.setScreen(GmudWorld.ms);
		}
		game.getInput().getKeyEvents();
		game.getInput().getTouchEvents();
		IInput i= game.getInput();
		if(i.isTouchDown(0))
			SingleTouchHandler.flag = 9;

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
		g.drawText("==================���==================", 0, 0, FontSize.FT_16PX,999);
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
