/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����GmudWorld.java <p>
 * ����ʱ�䣺2013-5-20 ����4:50:38 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import java.util.Random;

import lostland.gumd.platinum12548.battle.BattleScreen;
import lostland.gumd.platinum12548.blgframework.impl.SingleTouchHandler;
import lostland.gumd.platinum12548.data.Gesture;
import lostland.gumd.platinum12548.data.Item;
import lostland.gumd.platinum12548.data.MainChar;
import lostland.gumd.platinum12548.data.Npc;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.InnerMenuScreen;
import lostland.gumd.platinum12548.ui.MainMenuScreen;

/**
 * ������GmudWorld <p>
 * ˵����
 * @author 12548
 */
public class GmudWorld {
	
	
	public static Random rand = new Random();
	
	
	public static GmudGame game;
	
//	public static TradeDialog td;
//	public static TopMenuDialog tmd;
//	public static StatusDialog sd;
//	public static BottomDialog bd;
	public static MainCharTile cnm;
	public static MapTile mapTile;
	
	
	
	public static MainMenuScreen mms;
	public static MapScreen ms;
	public static BattleScreen bs;
	
	public static InnerMenuScreen ims;
	public static SingleTouchHandler sth;
	
	public static GmudNPC npcc;
	public static GmudMap map[];
	
	public static MainChar mc;
	public static Npc npc[];
	public static Skill skill[];
	public static Gesture zs[];
	public static Item wp[];
	
	
	public static boolean near(int x1,int y1,int x2,int y2)
	{
		return Math.abs(x1-x2)+Math.abs(y1-y2)==1;
	}
	
	public static int[] push_back(int[] a,int item)
	{
		int t[] = new int[a.length+1];
		for(int i=0;i< a.length;i++)
			t[i]=a[i];
		t[a.length] = item;
		return t;
	}
	
	public static int[] push_top(int[] a,int item)
	{
		int t[] = new int[a.length+1];
		t[0] = item;
		for(int i=1;i<t.length;i++)
			t[i]=a[i-1];
		return t;
	}
	
	public static int bool2int(boolean b)
	{
		if(b)
			return 1;
		else
			return 0;
	}
	
	public static boolean int2bool(int a)
	{
		if(a == 0)
			return false;
		else
			return true;
	}
	
	
	
	public static String pj[] = new String[]{
			"����һ��",
			"��������",
			"����ҳ�",
			"��ѧէ��",
			"����ǿǿ",
			"�����ž�",
			"����é®",
			"��֪һ��",
			"����ͨͨ",
			"ƽƽ����",
			"ƽ������",
			"�ֶ�Ƥë",
			"��������",
			"��������",
			"����С��",
			"����С��",
			"������Ⱥ",
			"�������",
			"������",
			"�ڻ��ͨ",
			"�������",
			"¯����",
			"��Ȼ���",
			"���д��",
			"���д��",
			"��Ȼ��ͨ",
			"�Ǳ�Ѱ��",
			"�������",
			"���е���",
			"����Ⱥ��",
			"����似",
			"�����뻯",
			"����Ⱥ��",
			"�Ƿ��켫",
			"�����ױ�",
			"��������",
			"һ����ʦ",
			"�������",
			"�񹦸���",
			"������˫",
			"��������",
			"���춯��",
			"������",
			"������ʥ",
			"�������",
			"��ǰ����",
			"���˺�һ",
			"��ز�¶",
			"��ɲ�",
			"��豹���",
			"�������",
			"���᲻��",
			"���غ���",
			"��ͬ�ݳ�"
			};
	
	public static final int teachers[] = {38,43,47,56,57,58,66,73,80,87,90,94,96,97,101,122,118,110};
	
	public static final int t_faction[][] = {{},{38,43,47},{96,97,101},{56,57,58,66},{87,90,94},{73,80},{110,118,122}};
	
}


