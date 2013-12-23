/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����IPixmap.java <p>
 * ����ʱ�䣺2013-5-19 ����7:16:16 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework;

import lostland.gumd.platinum12548.blgframework.IGraphics.PixmapFormat;

/**
 * ������IPixmap <p>
 * ˵����
 * @author 12548
 */
public interface IPixmap {
	public int getWidth();
	
	public int getHeight();
	
	public PixmapFormat getFormat();
	
	public void dispose();
}
