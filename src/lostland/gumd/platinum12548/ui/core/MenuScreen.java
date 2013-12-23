/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MenuScreen.java <p>
 * ����ʱ�䣺2013-7-23 ����9:15:15 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.core;

import android.util.Log;
import lostland.gumd.platinum12548.blgframework.IGame;

/**
 * ������MenuScreen <p>
 * ˵����
 * @author 12548
 */
public abstract class MenuScreen extends ButtonControlledScreen {
	
	protected int cursor = 0;
	

	protected GmudWindow buttons[];
	
	
//	/* ���� Javadoc��
//	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchDown(int, int)
//	 */
//	@Override
//	protected void onTouchDown(int tx, int ty) {
//		int itmcount = buttons.length;
//		for(int j=0;j<itmcount;j++){
//			if(buttons[j].inBound(tx, ty))
//			{
//				buttons[j].setBordered(true);
//			}
//		}
//	}
//	
//	/* ���� Javadoc��
//	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchMove(int, int)
//	 */
//	@Override
//	protected void onTouchMove(int tx, int ty) {
//		int itmcount = buttons.length;
//		for(int j=0;j<itmcount;j++){
//			if(!buttons[j].inBound(tx, ty))
//			{
//				buttons[j].setBordered(false);
//			}
//		}
//	}
//
//	/* ���� Javadoc��
//	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onClick(int, int)
//	 */
//	@Override
//	protected void onClick(int tx, int ty) {
//		int itmcount = buttons.length;
//		for(int j=0;j<itmcount;j++)
//			if(buttons[j].inBound(tx, ty) && buttons[j].inBound(downx, downy))
//			{
//				buttons[j].setBordered(false);
//				this.onClick(j);
//			}
//	}

	boolean bb=false;
	/**
	 * @param game
	 */
	public MenuScreen(IGame game, GmudWindow[] buttons) {
		super(game);
		this.buttons = buttons;
		refresh();
	}

	protected abstract void onClick(int index);

	public abstract void onCancel();
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#pause()
	 */
	@Override
	public void pause() {
		bb = false;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#resume()
	 */
	@Override
	public void resume() {
		bb = true;
		refresh();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#onButtonDown(lostland.gumd.platinum12548.ui.core.NewButton)
	 */
	@Override
	protected void onButtonDown(NewButton b) {

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#onButtonClick(lostland.gumd.platinum12548.ui.core.NewButton)
	 */
	@Override
	public void onButtonClick(NewButton b) {
		switch(b)
		{
		case NB_BACK:
			onCancel();
			break;
		case NB_ENTER:
			onClick(cursor);
			break;
		case NB_NULL:
			break;
		case NB_RIGHT:
		case NB_DOWN:
			cursor++;
			if(cursor >= buttons.length)
				cursor = 0;
			refresh();
			break;
		case NB_UP:
		case NB_LEFT:
			cursor--;
			if(cursor<0)
				cursor = buttons.length-1;
			refresh();
			break;
		default:
			break;
		
		}
	}

	void refresh()
	{
		Log.w("MenuScreen", "refreshing" + buttons.length + "buttons");
		for(int i=0;i<buttons.length;i++)
		{
			if(cursor == i)
				buttons[i].setBordered(true);
			else
				buttons[i].setBordered(false);
		}
	}
	
}
