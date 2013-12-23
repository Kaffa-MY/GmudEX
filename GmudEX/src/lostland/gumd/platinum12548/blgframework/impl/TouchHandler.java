/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����TouchHandler.java <p>
 * ����ʱ�䣺2013-5-19 ����8:22:29 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework.impl;

import java.util.List;

import lostland.gumd.platinum12548.blgframework.IInput.TouchEvent;

import android.view.View.OnTouchListener;


/**
 * ������TouchHandler <p>
 * ˵����ûʲô�á���
 * @author 12548
 */
public interface TouchHandler extends OnTouchListener{
	public boolean isTouchDown(int pointer);
	
	public int getTouchX(int pointer);
	
	public int getTouchY(int pointer);
	
	public List<TouchEvent> getTouchEvents();
	
}
