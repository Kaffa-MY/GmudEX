/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ProgressScreen.java <p>
 * ����ʱ�䣺2013-8-30 ����11:45:23 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;

/**
 * ������ProgressScreen <p>
 * ˵����
 * @author 12548
 */
public abstract class ProgressScreen extends SlowScreen {

	protected volatile boolean ok = true;
	
	int speed;
	protected int max;
	protected int now = 0;
	protected int smax;
	
	public ProgressScreen(IGame game, CScreen bg, float ticktime,int speed,int max,int smax) {
		super(game, bg, ticktime);
		this.speed = speed;
		this.max = max;
		this.smax = smax;
		ok = true;
	}

	public ProgressScreen(IGame game, CScreen bg, float ticktime,int speed,int max,int now,int smax) {
		super(game, bg, ticktime);
		this.speed = speed;
		this.max = max;
		this.now = now;
		this.smax = smax;
		ok = true;
	}
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.SlowScreen#tick()
	 */
	@Override
	public void tick() {
//		if(!ok)return;
		now+=speed;
		binding(now);
		if(now>=max)
		{
			onComplete();
		}
	}

	
	
	public abstract void onComplete();
	
	protected abstract void binding(int now);
	
	
	@Override
	public void draw() {
		BLGGraphics g = (BLGGraphics) game.getGraphics();
		if(max<=0){
			return;
		}
		g.drawRect(0, 2, 320, 16, GameConstants.BG_COLOR);
		g.drawRectOutline(30, 2, 200, 16, 0);
		g.drawText(now+"/"+smax, 236, 3, FontSize.FT_12PX);
		for(int i = 30;i<now*1.0/max*200+30;i++)
		{
			for(int j = 2;j<=16;j++)
			{
				g.drawPixel(i, j, 0);
			}
		}
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.SlowScreen#onClick(int, int)
	 */
	@Override
	protected void onClick(int tx, int ty) {
		game.setScreen(bg);
	}


}
