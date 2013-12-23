/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BLGInput.java <p>
 * ����ʱ�䣺2013-5-19 ����9:36:38 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework.impl;

import java.util.List;

import lostland.gumd.platinum12548.blgframework.IInput;
import android.content.Context;
import android.view.View;

/**
 * ������BLGInput <p>
 * ˵����
 * @author 12548
 */
public class BLGInput implements IInput {
	AccelerometerHandler accelHandler;
	KeyboardHandler keyHandler;
	TouchHandler touchHandler;
	
	public BLGInput(Context context,View view,float scaleX,float scaleY,float sc2x,float sc2y)
	{
		accelHandler = new AccelerometerHandler(context);
		keyHandler=new KeyboardHandler(view);
		touchHandler=new SingleTouchHandler(view,scaleX,scaleY,sc2x,sc2y);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#isKeyPressed(int)
	 */
	@Override
	public boolean isKeyPressed(int keyCode) {
		return keyHandler.isKeyPressed(keyCode);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#isTouchDown(int)
	 */
	@Override
	public boolean isTouchDown(int pointer) {
		return touchHandler.isTouchDown(pointer);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getTouchX(int)
	 */
	@Override
	public int getTouchX(int pointer) {
		return touchHandler.getTouchX(pointer);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getTouchY(int)
	 */
	@Override
	public int getTouchY(int pointer) {
		return touchHandler.getTouchX(pointer);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getKeyEvents()
	 */
	@Override
	public List<KeyEvent> getKeyEvents() {
		return keyHandler.getKeyEvents();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getTouchEvents()
	 */
	@Override
	public List<TouchEvent> getTouchEvents() {
		return touchHandler.getTouchEvents();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getAccelX()
	 */
	@Override
	public float getAccelX() {
		return accelHandler.getAccelX();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getAccelY()
	 */
	@Override
	public float getAccelY() {
		return accelHandler.getAccelY();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IInput#getAccelZ()
	 */
	@Override
	public float getAccelZ() {
		return accelHandler.getAccelZ();
	}


	
}
