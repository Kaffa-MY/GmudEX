/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����IInput.java <p>
 * ����ʱ�䣺2013-5-19 ����6:58:39 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework;

import java.util.List;

/**
 * ������IInput <p>
 * ˵����
 * @author 12548
 */
public interface IInput {
	
	public static class KeyEvent
	{
		public static final int KEY_DOWN = 0;
		public static final int KEY_UP = 1;
		
		public int type;
		public int keyCode;
		public char keyChar;
	}

	public static class TouchEvent
	{
		public static final int TOUCH_DOWN = 0;
		public static final int TOUCH_UP = 1;
		public static final int TOUCH_DRAGGED = 2;
		
		public int type;
		public int x, y;
		public int pointer;
	}
	
	public boolean isKeyPressed(int keyCode);
	
	public boolean isTouchDown(int pointer);
	
	public int getTouchX(int pointer);
	
	public int getTouchY(int pointer);
	
	public float getAccelX();
	
	public float getAccelY();
	
	public float getAccelZ();
	
	
	public List<KeyEvent> getKeyEvents();
	
	public List<TouchEvent> getTouchEvents();
}
