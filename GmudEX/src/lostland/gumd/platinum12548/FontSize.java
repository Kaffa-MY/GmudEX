/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����FontSize.java <p>
 * ����ʱ�䣺2013-7-12 ����2:07:39 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

/**
 * ������FontSize <p>
 * ˵����
 * @author 12548
 */
public enum FontSize {
	FT_12PX,
	FT_16PX;
	
	public int size()
	{
		if(this == FT_12PX)
			return 12;
		else
			return 16;
	}
}
