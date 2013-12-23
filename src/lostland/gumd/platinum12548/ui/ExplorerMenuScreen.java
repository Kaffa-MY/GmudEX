/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ExplorerMenuScreen.java <p>
 * ����ʱ�䣺2013-8-21 ����10:23:44 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import android.graphics.Color;
import android.graphics.Rect;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.DialogScreen;

/**
 * ������ExplorerMenuScreen <p>
 * ˵����
 * @author 12548
 */
public class ExplorerMenuScreen extends DialogScreen {

	public String HighLightBtnNames[] = null;//
	public String ListViewBtnName[] = null;//
	
	public int selectedButtonIndex = -1;
	public int selectedSubitemIndexes[] = null;
	
	protected Rect boundRect;
	
	protected int hilightBtnDrawX, hilightBtnDrawY;
	protected int subitemDrawX, subitemDrawY;
	
	protected int itemstartY, subitemstartY;
	protected int topitemindex = 0, topsubitemindex = 0;
	
	protected int maxLines = 1;
	
	// ------------- Animation stuff -----------------------------
	public double v_y_hilightBtn = 0;// ������ť��y�����ٶ�
	public double v_y_subitem = 0;// �嵥��y�����ٶ�
	protected double a_y = 0.05;//y���������������"���ٶ�"(��ֵ��Ϊ�˼���)
	//public final int updateInterval = 2;// 1/0.2
	//protected int updateCntr = 0;
	
	/**
	 * ctor
	 * @param game ��Ϸ����
	 * @param x �˵������Ͻ�
	 * @param y �˵������½�
	 * @param maxLines �����������
	 */
	public ExplorerMenuScreen(IGame game, int x, int y, int width,int maxLines) {
		super(game);
		// TODO �Զ����ɵĹ��캯�����
		hilightBtnDrawX = x + 2;
		subitemDrawX = x + 26 + 4;// OR 3
		hilightBtnDrawY = y + 2;
		subitemDrawY = y + 2;
		this.maxLines = maxLines;
		
		boundRect = new Rect(x, y, x + width,y + 5 * 12);
		
		selectedButtonIndex = 0;
		
		HighLightBtnNames = new String[]
				{
					"��1", "��2", "��3", "��4", "��5", "��6", "��7", "��8", "��9", "��10",
					"��11", "��12", "��13", "��14", "��15", "��16", "��17", "��18", "��19",
					"��20", "��21", "��22", "��23", "��24", "��25", "��26", "��27", "��28",
					"��29", "��30", "��31", "��32", "��33", "��34", "��35", "��36", "��37",
					"��38"
				};
		ListViewBtnName = new String[]{"�������", "һ�δε�"};
		v_y_hilightBtn = -5;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchDown(int, int)
	 */
	@Override
	protected void onTouchDown(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchMove(int, int)
	 */
	@Override
	protected void onTouchMove(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchUp(int, int)
	 */
	@Override
	protected void onTouchUp(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onClick(int, int)
	 */
	@Override
	protected void onClick(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		// TODO �Զ����ɵķ�����
		
		// ���ٶ�
		double valuetoadd = v_y_hilightBtn < 0?Math.abs(a_y) : (-1 * Math.abs(a_y));
		
		// �ٶȼ�Ϊ0 ���� ����Խ�� - ��ʱֻ���ж� ������ť��,�嵥�Ļ�ûд...
		if(v_y_hilightBtn * (v_y_hilightBtn + valuetoadd) <= 0
				|| hilightBtnDrawY + v_y_hilightBtn < boundRect.bottom - HighLightBtnNames.length * 12
				|| hilightBtnDrawY + v_y_hilightBtn > boundRect.top + 2)
		{
			if(hilightBtnDrawY + v_y_hilightBtn < boundRect.bottom - HighLightBtnNames.length * 12)
			{
				hilightBtnDrawY = boundRect.bottom - HighLightBtnNames.length * 12;
			}
			else if(hilightBtnDrawY + v_y_hilightBtn > boundRect.top + 2)
			{
				hilightBtnDrawY = boundRect.top + 2;
			}
			
			if(hilightBtnDrawY > boundRect.bottom - HighLightBtnNames.length * 12)
				v_y_hilightBtn = -5;
			else
				v_y_hilightBtn = 5;
		}
		else
		{
			hilightBtnDrawY += v_y_hilightBtn;
			v_y_hilightBtn += valuetoadd;
		}
		
		/*if(v_y_item > 0)
		{
			itemdrawY += v_y_item;
			v_y_item -= a_y;
		}*/
		
		BLGGraphics g = (BLGGraphics)game.getGraphics();
		g.SetClipRect(boundRect);
		
		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		
		DrawBackground(g);
		DrawOutline(g);
		DrawHilgtBtns(g);
		DrawListView(g);
		
		g.ResetClipRect();
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
	
	//-------------------- internal stuff -------------------------------
	protected void DrawBackground(BLGGraphics g)
	{
		g.drawRect(boundRect.left, boundRect.top,
				boundRect.width(), boundRect.height(),GameConstants.BG_COLOR);
	}
	
	protected void DrawOutline(BLGGraphics g)
	{
		g.drawRectOutline(boundRect.left, boundRect.top,
				boundRect.width(), boundRect.height(),Color.BLACK);
		g.drawLine(boundRect.left + 26, boundRect.top, boundRect.left + 26,
				boundRect.bottom, Color.BLACK);
	}
	
	// ������ߵĸ�����ť
	protected void DrawHilgtBtns(BLGGraphics g)
	{
		if(HighLightBtnNames == null)
			return;
		
		int _currentY = hilightBtnDrawY;
		int _font_color = Color.BLACK;
		int _line_cnt = 0;
		for (int i = 0; i < HighLightBtnNames.length; i++)
		{
			if(i < topitemindex)
				continue;
			
			if(++_line_cnt > maxLines)
				break;
			
			_font_color = Color.BLACK;
			
			if(selectedButtonIndex == i)
			{
				g.drawRect(hilightBtnDrawX, _currentY,
					HighLightBtnNames[i].length() * 12, 12, _font_color);
				_font_color = GameConstants.BG_COLOR;
			}
			
			g.drawSplitedText(HighLightBtnNames[i], hilightBtnDrawX,
					_currentY, FontSize.FT_12PX, _font_color);
			
			_currentY += 12;
		}
	}
	
	// �����ұߵ��嵥
	protected void DrawListView(BLGGraphics g)
	{
		if(ListViewBtnName == null)
			return;
		
		int _currentY = subitemDrawY;
		int _line_cnt = 0;
		
		for (int i = 0; i < ListViewBtnName.length; i++)
		{
			if(i < topsubitemindex)
				continue;
			
			if(++_line_cnt > maxLines)
				break;
			
			g.drawRectOutline(subitemDrawX + 5, _currentY + 3, 5, 5, Color.BLACK);
			
			if(contains(ListViewBtnName, i))
			{
				// ��δʵ�֣���������
				//��DrawPixel�����Թ�
			}
			
			g.drawSplitedText(ListViewBtnName[i], subitemDrawX + 15, _currentY, FontSize.FT_12PX);
			
			_currentY += 12;
		}
	}
	
	public static<T> boolean contains( final T[] array, final T val)
	{
		if(array == null)
			return false;
		for( final T e : array)
			if( e == val || e != null && e.equals(val))
				return true;
		return false;
	}
}
