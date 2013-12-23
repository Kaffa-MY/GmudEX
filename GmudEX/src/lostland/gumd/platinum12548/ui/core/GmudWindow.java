/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����GmudWindow.java <p>
 * ����ʱ�䣺2013-6-30 ����7:52:01 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.blgframework.IGraphics;
import android.graphics.Rect;

/**
 * ������GmudWindow <p>
 * ˵��������Ļ��ʾ�Ĵ�����Ļ��ࡣ
 * @author 12548
 */
public abstract class GmudWindow {

	protected Rect rect;
	public int x;
	public int y;
	protected int width;
	public int height;
	protected GmudGame game;
	
	protected boolean bordered = true;
	

	/**
	 * @return bordered
	 */
	public boolean isBordered() {
		return bordered;
	}


	/**
	 * @param bordered Ҫ���õ� bordered
	 */
	public void setBordered(boolean bordered) {
		this.bordered = bordered;
	}


	/**
	 * @param game ��Ϸ����
	 * @param x ���ϽǶ���x����
	 * @param y ���ϽǶ���y����
	 * @param width ���
	 * @param height �߶�
	 */
	public GmudWindow(GmudGame game,int x,int y,int width,int height)
	{
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		this.rect= new Rect(x,y,x+width,y+height);
	}
	
	
	public boolean inBound(int x,int y)
	{
		return rect.contains(x, y);
	}
	
	protected void drawBackground()
	{
		IGraphics g = game.getGraphics();
		if(this.bordered)
		{
			g.drawRect(x, y, width, height, 0);
			g.drawRect(x+1, y+1, width-2, height-2, GameConstants.BG_COLOR);
		}
		else
		{
			g.drawRect(x, y, width, height, GameConstants.BG_COLOR);
		}
	}
	
	public void resize()
	{
		this.rect= new Rect(x,y,x+width,y+height);
	}
	
	abstract public void draw();
	
}
