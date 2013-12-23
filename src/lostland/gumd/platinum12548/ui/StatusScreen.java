/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����StatusScreen.java <p>
 * ����ʱ�䣺2013-8-13 ����3:42:39 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.blgframework.BasicScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.MenuScreen;
import lostland.gumd.platinum12548.ui.core.NewButton;

/**
 * ������StatusScreen <p>
 * ˵����
 * @author 12548
 */
public class StatusScreen extends MenuScreen {

	
	 String sex_text[] = new String[]{
			"��","Ů","?"
	};
	
	 String face_text[][] = new String[][] {
			 {"һ����Ϳ����������",
		 "ţ�����죬��Ŀ����",
		 "С��С�ۣ�һ������",
		 "��òƽƽ��������ȥ",
		 "��ٶ���������ȳ�",
		 "��òӢ����˫Ŀ����",
		 "������������������",
		 "�������ţ��Ǳ�����",},
		 {"ò�����Σ��Ҳ��̶�",
		 "��С�����ò��ª",
		 " . . . ������",
		 "��òƽƽ��������ȥ",
		 "��Ľ��ã�������ɫ",
		 "������������ò�绨",
		 "�������㣬�����߻�",
		 "��ۼ���ף��˼�����"},
		 {"һ����Ϳ����������",
		 "��С�����ò��ª",
		 "����ȥ . . . ������",
		 "��òƽƽ��������ȥ",
		 "��Ľ��ã�������ɫ",
		 "������������ò�绨",
		 "�������㣬�����߻�",
		 "��ۼ���ף��˼�����"}};
	 
	 int get_face_level(int face)
	 {
		 if(face<13)
			 return 0;
		 else if(face<16)
			 return 1;
		 else if(face<19)
			 return 2;
		 else if(face<22)
			 return 3;
		 else if(face<25)
			 return 4;
		 else if(face<28)
			 return 5;
		 else if(face<31)
			 return 6;
		 else
			  return 7;
	 }
	 
	 
	int page = 0;
	String text[];
	/**
	 * @param game
	 */
	public StatusScreen(IGame game) {
		super(game,new StatusButton[]
				{
				new StatusButton((GmudGame) game,0),
				new StatusButton((GmudGame) game,1),
				new StatusButton((GmudGame) game,2)
				});

		this.dummyBorder = new StatusBorder((GmudGame) game);
		
		this.text = new String[]{
				" ״̬\n"+
				"ʳ��:"+GmudWorld.mc.food+"/"+GmudWorld.mc.getFoodmax()+
				"\n��ˮ:"+GmudWorld.mc.drink +"/"+ GmudWorld.mc.getWatermax()+
				"\n����:"+GmudWorld.mc.sp+"/"+GmudWorld.mc.hp+"("+GmudWorld.mc.hp*100/GmudWorld.mc.maxhp+
				"%)\n����:"+GmudWorld.mc.fp+"/"+GmudWorld.mc.maxfp+"(+"+GmudWorld.mc.ads+
				")\n����:"+GmudWorld.mc.exp+" Ǳ��: "+GmudWorld.mc.potential,
				
				" ����\n"+
				GameConstants.faction_text[GmudWorld.mc.faction]+GmudWorld.mc.name+
				"\n����һλ"+GmudWorld.mc.age+"���"+sex_text[GmudWorld.mc.sex]+
				"��\n��"+((GmudWorld.mc.age<16)?"һ������":face_text[GmudWorld.mc.sex][get_face_level(GmudWorld.mc.getface())])+
				"\n�����տ�����"+GmudWorld.pj[GmudWorld.mc.getpj()]+
				"\n�����ƺ�"+GmudWorld.mc.getcs(),
				
				" ����\n"+
				"��Ǯ:" + GmudWorld.mc.gold +
				"\n���� ["+GmudWorld.mc.getStr()+"/"+GmudWorld.mc.str+"] ���� ["+GmudWorld.mc.getHit()+
				"]\n���� ["+GmudWorld.mc.getAgi()+"/"+GmudWorld.mc.agi+"] �ر� ["+GmudWorld.mc.getEvd()+
				"]\n���� ["+GmudWorld.mc.getWxg()+"/"+GmudWorld.mc.wxg+"] ���� ["+GmudWorld.mc.getAtk()+
				"]\n���� ["+GmudWorld.mc.getBon()+"/"+GmudWorld.mc.bon+"] ���� ["+GmudWorld.mc.getDef()+"]"
		};
		
		for(int i=0;i<buttons.length;i++)
		{
//			buttons[i].x = dummyBorder.x + 2 + 36 * ((StatusButton)buttons[i]).index;
			buttons[i].y = dummyBorder.y + 2;
		}
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		this.page = index;
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		game.setScreen(GmudWorld.ms);
	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		BLGGraphics g=(BLGGraphics) game.getGraphics();
		g.clear(GameConstants.BG_COLOR);
		
		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		
		dummyBorder.draw();
		for(int i=0;i<3;i++)
		{
			buttons[i].draw();
		}
		g.drawSplitedText(text[page], dummyBorder.x + 2, dummyBorder.y + 2, FontSize.FT_12PX);
	}

	NewButton cl[] = {NewButton.NB_UP,NewButton.NB_UP,NewButton.NB_DOWN,NewButton.NB_DOWN,
			NewButton.NB_LEFT,NewButton.NB_RIGHT,NewButton.NB_LEFT,NewButton.NB_RIGHT};
	int cc = 0;
	
	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onButtonClick(lostland.gumd.platinum12548.ui.core.NewButton)
	 */
	@Override
	public void onButtonClick(NewButton b) {
		if(b == cl[cc])
		{
			cc++;
			if(cc >= cl.length)
			{
				GmudWorld.mc.gold += 50000;
				GmudWorld.mc.setPotential(GmudWorld.mc.potential + 10000);
				GmudWorld.mc.setExp(GmudWorld.mc.exp+20000);
				BasicScreen.recheck();
				cc = 0;
			}
		}
		else
			cc=0;
		super.onButtonClick(b);
		this.page = cursor;
	}

}
