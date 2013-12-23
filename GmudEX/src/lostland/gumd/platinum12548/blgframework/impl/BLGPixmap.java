/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BLGPixmap.java <p>
 * ����ʱ�䣺2013-5-19 ����9:47:56 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework.impl;

import lostland.gumd.platinum12548.blgframework.IPixmap;
import lostland.gumd.platinum12548.blgframework.IGraphics.PixmapFormat;
import android.graphics.Bitmap;


/**
 * ������BLGPixmap <p>
 * ˵����
 * @author 12548
 */
public class BLGPixmap implements IPixmap
{
	Bitmap bitmap;
	PixmapFormat format;
	
	public BLGPixmap(Bitmap bitmap, PixmapFormat format)
	{
		this.bitmap= bitmap;
		this.format= format;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IPixmap#getWidth()
	 */
	@Override
	public int getWidth() {
		return bitmap.getWidth();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IPixmap#getHeight()
	 */
	@Override
	public int getHeight() {
		return bitmap.getHeight();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IPixmap#getFormat()
	 */
	@Override
	public PixmapFormat getFormat() {
		return format;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IPixmap#dispose()
	 */
	@Override
	public void dispose() {
		bitmap.recycle();
	}
	
}
