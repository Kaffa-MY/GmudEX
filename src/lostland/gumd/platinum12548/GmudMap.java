/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����GmudMap.java <p>
 * ����ʱ�䣺2013-5-21 ����12:41:17 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import android.graphics.Point;

/**
 * ������GmudMap <p>
 * ˵������ͼ����ʾ��
 * @author 12548
 */
public class GmudMap {
	
	public static final int MP_WALKABLE=-1;
	public static final int MP_UNWALKABLE=0;
	public static final int MP_CHANGETO=-1;//��Ҫ��������
	public static final int MP_NPC=2;
	public static final int MP_EVENT=3;
	
	
	
	public static final String MAP_NAME[] = new String[] {   //map name
		//"ƽ����", "�̼ұ�", "��Ů��", "��ָɽ", "����", "�䵱ɽ", "��ѩɽ", "��ɭ��", "���Ĺ�", "������", 
		//"�һ�Դ"
		"����", "ƽ������", "�����ż�", "�÷��", "������", "ƽ����", "�峤��", "����", "��ҵ��", "�ӻ���",
		"ҩ��", "����", "������", "��ջ", "ƽ���򱱽�", "ƽ��������", "ƽ�����Ͻ�", "ƽ���򶫽�", "��ѩɽկ", "��ѩɽ���ͷ���",
		"��ѩɽ����԰", "��ѩɽ���ͷ�һ", "��ѩɽ���ͷ���", "��ѩɽ����԰", "��ѩɽ���ͷ�һ", "�䵱ɽ��", "�䵱ɽ", "ɽ�����", "��ָɽ", "������",
		"��Ů��", "ʱ�յľ�ͷ", "���𵺶ɿ�", "����������", "��������", "���𵺶�����", "���𵺶���", "����", "�̼ұ�", "�̼ұ�����", 
		"�̼ұ���¥", "�̼ұ��ͷ�һ", "�̼ұ��ͷ���", "�̼ұ��ͷ���", "�̼ұ��ͷ���", "ʧ�������", "��Ů֮��", "���"
		};

	
	Point p[][][];
	int i,j,k;
	public int width,height;
	public int id;

	/**
	 * ��ȡ��ͼid��
	 * @return ��ͼ��id
	 */
	public int getId() {
		return id;
	}

	public GmudMap(int width,int height,int id)
	{
		p=new Point[4][width][height];
		for(i=0;i<4;i++)
			for(j=0;j<width;j++)
				for(k=0;k<height;k++)
					p[i][j][k]=new Point(-1,-1);
		this.width=width;
		this.height=height;
		this.id = id;
	}
	
	public void setPoint(int z,int x,int y,int tileX,int tileY)
	{
		p[z][x][y].x=tileX;
		p[z][x][y].y=tileY;
	}
	
	public int getTileX(int z,int x,int y)
	{
		if(x<0 || x>=width ||y<0 || y>=height)
			return 0;
		return p[z][x][y].x;
	}
	
	public int getTileY(int z,int x,int y)
	{
		if(x<0 || x>=width ||y<0 || y>=height)
			return 0;
		return p[z][x][y].y;
	}
	
	public void setWalkable(int x,int y,int walkable)
	{
		p[3][x][y].x=walkable;
	}
	
	public void setEvent(int x,int y,int eventid)
	{
		p[3][x][y].y=eventid;
	}
	
	public int getWalkable(int x,int y)
	{
		if(x<0 || x>=width ||y<0 || y>=height)
			return 0;
		return p[3][x][y].x;
	}
	
	public int getEvent(int x,int y)
	{
		if(x<0 || x>=width ||y<0 || y>=height)
			return 0;
		return p[3][x][y].y;
	}
	
	public boolean isWalkable(int x,int y)
	{
		if( (x<0) || (x>=width) || (y<0) || (y>=height))
			return false;
		
		return p[3][x][y].x==MP_WALKABLE;
	}
	
	
}
