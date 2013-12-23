/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BLGGraphics.java <p>
 * ����ʱ�䣺2013-5-19 ����9:58:04 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import lostland.gumd.platinum12548.Assets;
import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.blgframework.IGraphics;
import lostland.gumd.platinum12548.blgframework.IPixmap;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.Log;


/**
 * ������BLGGraphics <p>
 * ˵����
 * @author 12548
 */
public class BLGGraphics implements IGraphics {
	AssetManager assets;
	Bitmap frameBuffer;
	Canvas canvas,SecondCanvas;
	Paint paint;
	Rect srcRect=new Rect();
	Rect dstRect=new Rect();
	
	static final int TEXT_LINE_PX_LIMIT = 148;
	
	public BLGGraphics(AssetManager assets,Bitmap frameBuffer,Bitmap fb2)
	{
		this.assets= assets;
		this.frameBuffer= frameBuffer;
		this.canvas=new Canvas(frameBuffer);
		this.SecondCanvas = new Canvas(fb2);
		this.paint=new Paint();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#newPixmap(java.lang.String, lostland.gumd.platinum12548.blgframework.IGraphics.PixmapFormat)
	 */
	@Override
	public IPixmap newPixmap(String fileName, PixmapFormat format) {
		Config config = null;
		if(format== PixmapFormat.RGB565)
			config= Config.RGB_565;
		else if(format== PixmapFormat.ARGB4444)
			config= Config.ARGB_4444;
		else
			config= Config.ARGB_8888;
		
		Options options=new Options();
		options.inPreferredConfig=config;
		InputStream in=null;
		Bitmap bitmap=null;
		try
		{
			in=assets.open(fileName);
			bitmap=BitmapFactory.decodeStream(in);
			if(bitmap==null)
				throw new RuntimeException("�޷���λͼ�ļ�"+ fileName);
		}
		catch( IOException e)
		{
			throw new RuntimeException("�޷���λͼ�ļ�"+ fileName);
		}
		finally
		{
			if(in!=null)
				try{
					in.close();
				}catch( IOException e)
				{
					
				}
		}
		
		if(bitmap.getConfig()==Config.RGB_565)
			format= PixmapFormat.RGB565;
		else if( bitmap.getConfig()==Config.ARGB_4444)
			format= PixmapFormat.ARGB4444;
		else
			format= PixmapFormat.ARGB8888;
		Log.i("BLGGraphics", "Pixmap Created:"+ fileName);
		return new BLGPixmap( bitmap, format);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#clear(int)
	 */
	@Override
	public void clear(int color) {
		canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, (color & 0xff));
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#drawPixel(int, int, int)
	 */
	@Override
	public void drawPixel(int x, int y, int color) {
//		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawPoint(x, y, paint);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#drawLine(int, int, int, int, int)
	 */
	@Override
	public void drawLine(int x, int y, int x2, int y2, int color) {
		paint.setStyle(Style.FILL);
		paint.setColor(color);
		canvas.drawLine(x, y, x2, y2, paint);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#drawRect(int, int, int, int, int)
	 */
	@Override
	public void drawRect(int x, int y, int width, int height, int color) {
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		paint.setAlpha(255);
		canvas.drawRect(x, y, x+width-1, y+height-1, paint);
	}

	
	public void drawText(String text,int x,int y,int size)
	{
		paint.setColor(0);
		paint.setStyle(Style.FILL);
		paint.setAlpha(255);
		paint.setTextAlign(Align.LEFT);
		paint.setTextSize(size);
//		paint.setAntiAlias(true);
//		paint.setTypeface(Assets.songti);
//		paint.setFakeBoldText(true);

		FontMetrics f= paint.getFontMetrics();

		canvas.drawText(text, x, y-f.ascent, paint);
	}
	
	// ��д by ��ͷ���β�δ��
	public void drawText(String text,int x,int y,FontSize size)
	{
		drawSplitedText(splitString(text, size, TEXT_LINE_PX_LIMIT), x, y, size);
	}
	
	
	public void draw2Text(String text,int x,int y,FontSize size)
	{
		paint.setColor(0xffffffff);
		drawSplitedText(splitString(text, size, TEXT_LINE_PX_LIMIT), x, y, size);
		paint.setColor(0);
	}
	
	
	// ���� by ��ͷ,pxLimit��ʾ�����������ƣ��������㻻��
	public void drawText(String text,int x,int y,FontSize size,int pxLimit)
	{
		drawSplitedText(splitString(text, size, pxLimit), x, y, size);
	}
	
	// !!! ��������Զ���⻻�У�ֻ�ܻ����Ѿ��ָ�õ�String!!!
	public void drawSplitedText(String text,int x,int y,FontSize size)
	{
		byte[] buffer;
		try {
			buffer = text.getBytes("GBK");
			//buffer = splitString(text, size, pxPerLine).getBytes("GBK");



			// �ַ����п��ܻ���ascii�ַ������ǵĿ���Ǻ��ֵ�һ��.(��"�㻹���ұ���CHATȥ��")
			int char_width = 0;

			// �洢һ�����ֵ�����ϢҪ���ֽ���
			// 12px�ģ�ÿ�������ֽڣ�12��, ��Ϊ24
			// 16px�ģ�ÿ�������ֽڣ�16�У���Ϊ32
			int char_dataSize = 0;

			switch (size)
			{
			case FT_12PX:
				char_width = 12;
				char_dataSize = 24;
				break;
			case FT_16PX:
				char_width = 16;
				char_dataSize = 32;
				break;
			default:
				break;
			}

			int xx = x;//Nice
			int yy = y;


			paint.setColor(0);
			paint.setStyle(Style.FILL);
			paint.setAlpha(255);



			// �����ַ����桶--- ��Ӣ�Ļ���һ��Ķ���
			for (int i = 0; i < buffer.length; i++)
			{
				byte b = buffer[i];
				// С��0xA0(160)�ģ���ascii�ַ�
				if ((b & 0xFF)< 0xA0)
				{
					// Added by ��ͷ20130729
					
					// ò�� '\n'��Ascii��Ϊ0x0a(10)
					if(b == 0x0A)
					{
						xx = x;
						yy += char_width;// ��Ϊ���ǿ�=�ߵ�������...
						continue;
					}
					
					int asciiCharWidth = char_width / 2;
					int asciiCharDataSize = 12;//12 * 1
					int offset= b * asciiCharDataSize;
					
					byte[] char_lattice_info = new byte[char_dataSize];
					for (int tmp = 0; tmp < asciiCharDataSize; tmp++)
					{
						char_lattice_info[tmp] = Assets.ascii12[tmp + offset];
					}
					
					int height = size.size();//�߶ȷ�����ֽ���
					int width = 1;//ˮƽ�������ֽ�

					int ptr_byte = 0;// ��¼�õ��˵ڼ����ֽ�
					
					for (int ht = 0; ht < height; ht++)
					{
						for (int wd = 0; wd < width; wd++)
						{
							for (int bit = 0; bit < 8; bit++)
							{
								// ����������Ϣ
								boolean draw = (char_lattice_info[ptr_byte] & (1 << bit)) == 0 ? false : true;

								if (draw)
								{
									// C# û�л��㺯��..
									drawPixel(
											xx + (wd << 3) + 7 - bit,// Xλ�� = һֱ��¼��x + wd * 8 + 7-bit������7-bit��Ϊ���Ǵ��ұ�����ߴ�....
											yy + ht,// Yλ�ã����ǻ����еĺ�����ֻ��Ҫ��ֹ���Ƶ���кžͺ���
											0
											);
								}
							}

							// !! ������һ���ֽ���...ָ����һ���ֽ�
							ptr_byte++;
						}
					}
					
					xx += asciiCharWidth;//+���ֿ��һ��
				}
				// �Ҵ���
				else
				{
					// ��λ�룬���ǹ̶��Ĺ�ʽ, ��������(����Ĭ�ϱ����õ��ֽ�)ת��Ϊ��λ��Ĺ�ʽ
					// area - ����pos - λ 
					// ��λ������ǰ�ƴ����˳�򣬺ܺ�
					int area = (buffer[i] & 0xFF) - 0xA0;//C#��ʵ����û��Ҫ&0xFF.��Ϊbyte������
					int pos = (buffer[i+1] & 0xFF) - 0xA0;

					// Ѱַ��ƫ�� = ((���� - 1 * 94) + λ�� - 1 ) * ��һ�����ֵ���Ҫ���ֽ���
					int offset = ((area - 1) * 94 + pos - 1) * char_dataSize;

					// ��֪������С�����ֵ���Ǳ�㣬�Ҳ�֪��Ϊʲô���ֵ�ƫ�ˣ�����ȴû
					if (offset > char_dataSize * 564)
						offset -= char_dataSize * 564;

					// ����ƫ�������ֿ����һ�����ֵĵ�����Ϣ���Ƴ��� ���� ȷʵҲûɶ��Ҫ...
					byte[] char_lattice_info = new byte[char_dataSize];
					for (int tmp = 0; tmp < char_dataSize; tmp++)
					{
						if (size == FontSize.FT_12PX)
							char_lattice_info[tmp] = Assets.charGBK12[tmp + offset];
						else
							char_lattice_info[tmp] = Assets.charGBK16[tmp + offset];
					}

					int height = size.size();//�߶ȷ�����ֽ���
					int width = 2;//ˮƽ�������ֽ�

					int ptr_byte = 0;// ��¼�õ��˵ڼ����ֽ�

					// ����ȡ����һ�����ֵĵ�����Ϣ(char_lattice_info)�����Ի���
					//      ����������
					//          �����(���)���� ��������
					//          �м��      ���� ������(�������ֽ�)
					//          ���ڲ�      ���� �����ֽڵ����λ�������Ƿ񻭵�
					for (int ht = 0; ht < height; ht++)
					{
						for (int wd = 0; wd < width; wd++)
						{
							for (int bit = 0; bit < 8; bit++)
							{
								// ����������Ϣ
								boolean draw = (char_lattice_info[ptr_byte] & (1 << bit)) == 0 ? false : true;

								if (draw)
								{
									// C# û�л��㺯��..
									drawPixel(
											xx + (wd << 3) + 7 - bit,// Xλ�� = һֱ��¼��x + wd * 8 + 7-bit������7-bit��Ϊ���Ǵ��ұ�����ߴ�....
											yy + ht,// Yλ�ã����ǻ����еĺ�����ֻ��Ҫ��ֹ���Ƶ���кžͺ���
											0
											);
								}
							}

							// !! ������һ���ֽ���...ָ����һ���ֽ�
							ptr_byte++;
						}
					}

					xx += char_width;// ���� ���=�߶�

					i++;//һ�����ֻ��������ֽڣ���һ���Ѿ����õ��ˡ���������һ��
				}
			}

		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}


	}
	
	
	
	
	
	private String splitString(String src,FontSize ftSize,int lenLimit)
	{
		StringBuilder sb = new StringBuilder();
		int HanziWidth = ftSize == FontSize.FT_12PX ? 12 : 16;
		
		int currLen = 0;
		for (int i = 0; i < src.length(); i++) 
		{
			char c = src.charAt(i);
			int wid = -1;
			if( (int)c > 0xA0 )// �ж�char�Ƿ�Ϊascii�ķ���
				wid = HanziWidth;
			else
			{
				if(c == 0x0A)
					wid = currLen * (-1);
				else
					wid = HanziWidth / 2;
			}
			
			if (currLen + wid > lenLimit)
			{
				sb.append('\n');
				currLen = 0;
			}
			sb.append(c);
			currLen += wid;
		}
		
		return sb.toString();
	}
	
	public ArrayList<String> splitString(String src, FontSize ftSize, int lenLimit,int linePerPage)
	{
		ArrayList<String> strs = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int HanziWidth = ftSize == FontSize.FT_12PX ? 12 : 16;
		
		int currLen = 0;
		int reCnt = 0;// �س��ĸ�����̫������Ҫ��ҳ��
		for (int i = 0; i < src.length(); i++) 
		{
			char c = src.charAt(i);
			int wid = -1;
			if( (c & 0xFF) > 0xA0 )// �ж�char�Ƿ�Ϊascii�ķ���
				wid = HanziWidth;
			else
			{
				if(c == 0x0A)
				{
					wid = 0 - currLen;//avoid multiplication
					reCnt++;
				}
				else
					wid = HanziWidth / 2;
			}
			
			if (currLen + wid > lenLimit)
			{
				sb.append('\n');
				reCnt++;
				currLen = 0;
			}
			
			if(reCnt >= linePerPage)
			{
				reCnt = 0;
				strs.add(sb.toString());
				sb.delete(0, sb.length());//length����-1 ��������������������֪Ϊ��
			}
			
			sb.append(c);
			currLen += wid;
		}
		strs.add(sb.toString());
		
		return strs;
	}

	public ArrayList<String> splitString(String src,int linePerPage)
	{
		ArrayList<String> strs = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int reCnt = 0;// �س��ĸ�����̫������Ҫ��ҳ��
		for (int i = 0; i < src.length(); i++) 
		{
			char c = src.charAt(i);
			
			if(c == 0x0A)
			{
				reCnt++;
			}
			
			if(reCnt >= linePerPage)
			{
				reCnt = 0;
				strs.add(sb.toString());
				sb.delete(0, sb.length());//length����-1 ��������������������֪Ϊ��
			}
			
			sb.append(c);
		}
		strs.add(sb.toString());
		
		return strs;
	}

	
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#drawPixmap(lostland.gumd.platinum12548.blgframework.IPixmap, int, int, int, int, int, int)
	 */
	@Override
	public void drawPixmap(IPixmap pixmap, int x, int y, int srcX, int srcY,
			int srcWidth, int srcHeight) {
		srcRect.left=srcX;
		srcRect.top=srcY;
		srcRect.right=srcX+srcWidth-1;
		srcRect.bottom=srcY+srcHeight-1;
		
		dstRect.left=x;
		dstRect.top=y;
		dstRect.right=x+srcWidth-1;
		dstRect.bottom=y+srcHeight-1;
		
		if(pixmap==null)
			Log.e("BLGGraphics", "null pixmap!");
		
		canvas.drawBitmap(((BLGPixmap)pixmap).bitmap, srcRect,dstRect, null);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#drawPixmap(lostland.gumd.platinum12548.blgframework.IPixmap, int, int)
	 */
	@Override
	public void drawPixmap(IPixmap pixmap, int x, int y) {
		canvas.drawBitmap(((BLGPixmap)pixmap).bitmap, x, y, null);
	}

	
	public void draw2ndPixmap(IPixmap pixmap,int x,int y)
	{
		if(pixmap == null)
			return;
		drawPixmap(pixmap, x, y);
//		this.SecondCanvas.drawBitmap(((BLGPixmap)pixmap).bitmap, x, y, null);
	}
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#getWidth()
	 */
	@Override
	public int getWidth() {
		return frameBuffer.getWidth();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.IGraphics#getHeight()
	 */
	@Override
	public int getHeight() {
		return frameBuffer.getHeight();
	}
	
	
	// һ��	��Ա
	Rect orgnClipRect = new Rect();

	// ADDED BY ME - 
	public void drawRectOutline(int x, int y, int width, int height, int color)
	{
		paint.setColor(color);
		paint.setStyle(Style.STROKE);
		paint.setAlpha(255);
		canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);
	}
	public void SetClipRect(Rect rect)
	{
		orgnClipRect = canvas.getClipBounds();
		canvas.clipRect(rect);
	}
	public void ResetClipRect()
	{
		canvas.clipRect(orgnClipRect);
	}

	/**
	 * @param string
	 * @param hilightBtnDrawX
	 * @param _currentY
	 * @param ft12px
	 * @param _font_color
	 */
	public void drawSplitedText(String text, int x,
			int y, FontSize size, int _font_color) {
		byte[] buffer;
		try {
			buffer = text.getBytes("GBK");
			//buffer = splitString(text, size, pxPerLine).getBytes("GBK");



			// �ַ����п��ܻ���ascii�ַ������ǵĿ���Ǻ��ֵ�һ��.(��"�㻹���ұ���CHATȥ��")
			int char_width = 0;

			// �洢һ�����ֵ�����ϢҪ���ֽ���
			// 12px�ģ�ÿ�������ֽڣ�12��, ��Ϊ24
			// 16px�ģ�ÿ�������ֽڣ�16�У���Ϊ32
			int char_dataSize = 0;

			switch (size)
			{
			case FT_12PX:
				char_width = 12;
				char_dataSize = 24;
				break;
			case FT_16PX:
				char_width = 16;
				char_dataSize = 32;
				break;
			default:
				break;
			}

			int xx = x;//Nice
			int yy = y;


			paint.setColor(0);
			paint.setStyle(Style.FILL);
			paint.setAlpha(255);



			// �����ַ����桶--- ��Ӣ�Ļ���һ��Ķ���
			for (int i = 0; i < buffer.length; i++)
			{
				byte b = buffer[i];
				// С��0xA0(160)�ģ���ascii�ַ�
				if ((b & 0xFF)< 0xA0)
				{
					// Added by ��ͷ20130729
					
					// ò�� '\n'��Ascii��Ϊ0x0a(10)
					if(b == 0x0A)
					{
						xx = x;
						yy += char_width;// ��Ϊ���ǿ�=�ߵ�������...
						continue;
					}
					
					int asciiCharWidth = char_width / 2;
					int asciiCharDataSize = 12;//12 * 1
					int offset= b * asciiCharDataSize;
					
					byte[] char_lattice_info = new byte[char_dataSize];
					for (int tmp = 0; tmp < asciiCharDataSize; tmp++)
					{
						char_lattice_info[tmp] = Assets.ascii12[tmp + offset];
					}
					
					int height = size.size();//�߶ȷ�����ֽ���
					int width = 1;//ˮƽ�������ֽ�

					int ptr_byte = 0;// ��¼�õ��˵ڼ����ֽ�
					
					for (int ht = 0; ht < height; ht++)
					{
						for (int wd = 0; wd < width; wd++)
						{
							for (int bit = 0; bit < 8; bit++)
							{
								// ����������Ϣ
								boolean draw = (char_lattice_info[ptr_byte] & (1 << bit)) == 0 ? false : true;

								if (draw)
								{
									drawPixel(
											xx + (wd << 3) + 7 - bit,// Xλ�� = һֱ��¼��x + wd * 8 + 7-bit������7-bit��Ϊ���Ǵ��ұ�����ߴ�....
											yy + ht,// Yλ�ã����ǻ����еĺ�����ֻ��Ҫ��ֹ���Ƶ���кžͺ���
											0
											);
								}
							}

							// !! ������һ���ֽ���...ָ����һ���ֽ�
							ptr_byte++;
						}
					}
					
					xx += asciiCharWidth;//+���ֿ��һ��
				}
				// �Ҵ���
				else
				{
					// ��λ�룬���ǹ̶��Ĺ�ʽ, ��������(����Ĭ�ϱ����õ��ֽ�)ת��Ϊ��λ��Ĺ�ʽ
					// area - ����pos - λ 
					// ��λ������ǰ�ƴ����˳�򣬺ܺ�
					int area = (buffer[i] & 0xFF) - 0xA0;//C#��ʵ����û��Ҫ&0xFF.��Ϊbyte������
					int pos = (buffer[i+1] & 0xFF) - 0xA0;

					// Ѱַ��ƫ�� = ((���� - 1 * 94) + λ�� - 1 ) * ��һ�����ֵ���Ҫ���ֽ���
					int offset = ((area - 1) * 94 + pos - 1) * char_dataSize;

					// ��֪������С�����ֵ���Ǳ�㣬�Ҳ�֪��Ϊʲô���ֵ�ƫ�ˣ�����ȴû
					if (offset > char_dataSize * 564)
						offset -= char_dataSize * 564;

					// ����ƫ�������ֿ����һ�����ֵĵ�����Ϣ���Ƴ��� ���� ȷʵҲûɶ��Ҫ...
					byte[] char_lattice_info = new byte[char_dataSize];
					for (int tmp = 0; tmp < char_dataSize; tmp++)
					{
						if (size == FontSize.FT_12PX)
							char_lattice_info[tmp] = Assets.charGBK12[tmp + offset];
						else
							char_lattice_info[tmp] = Assets.charGBK16[tmp + offset];
					}

					int height = size.size();//�߶ȷ�����ֽ���
					int width = 2;//ˮƽ�������ֽ�

					int ptr_byte = 0;// ��¼�õ��˵ڼ����ֽ�

					// ����ȡ����һ�����ֵĵ�����Ϣ(char_lattice_info)�����Ի���
					//      ����������
					//          �����(���)���� ��������
					//          �м��      ���� ������(�������ֽ�)
					//          ���ڲ�      ���� �����ֽڵ����λ�������Ƿ񻭵�
					for (int ht = 0; ht < height; ht++)
					{
						for (int wd = 0; wd < width; wd++)
						{
							for (int bit = 0; bit < 8; bit++)
							{
								// ����������Ϣ
								boolean draw = (char_lattice_info[ptr_byte] & (1 << bit)) == 0 ? false : true;

								if (draw)
								{
									// C# û�л��㺯��..
									drawPixel(
											xx + (wd << 3) + 7 - bit,// Xλ�� = һֱ��¼��x + wd * 8 + 7-bit������7-bit��Ϊ���Ǵ��ұ�����ߴ�....
											yy + ht,// Yλ�ã����ǻ����еĺ�����ֻ��Ҫ��ֹ���Ƶ���кžͺ���
											_font_color
											);
								}
							}

							// !! ������һ���ֽ���...ָ����һ���ֽ�
							ptr_byte++;
						}
					}

					xx += char_width;// ���� ���=�߶�

					i++;//һ�����ֻ��������ֽڣ���һ���Ѿ����õ��ˡ���������һ��
				}
			}

		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
