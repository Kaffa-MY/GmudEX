/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����InventoryScreen.java <p>
 * ����ʱ�䣺2013-12-23 ����7:04:35 <p>
 * ������Ŀ��GmudEX <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MainCharTile;
import lostland.gumd.platinum12548.blgframework.CScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.data.Item;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.core.DoubleScrollScreen;
import lostland.gumd.platinum12548.ui.core.YesNoScreen;
import lostland.gumd.platinum12548.ui.meta.ReadingDialog;

/**
 * ������InventoryScreen <p>
 * ˵����
 * @author 12548
 */
public class InventoryScreen extends DoubleScrollScreen {

	boolean b = false;
	
	int sticking[][] = new int[10][Item.item_names.length];
	
	CScreen ts;
	AutoWindow bottomWindow;
	
	
	/**
	 * @param game
	 * @param x
	 * @param y
	 * @param w1
	 * @param w2
	 * @param max
	 */
	public InventoryScreen(IGame game, boolean b,CScreen ts) {
		super(game, 60, 40, 36, 180, 6);
		this.b = b;
		this.ts = ts;
		bottomWindow = new AutoWindow((GmudGame) game, x, y + max * 12, w1+w2-1, 26, "");
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#gets()
	 */
	@Override
	public void gets() {
		if(b)
			s1 = new String[] {"ʳ��","ҩ��"};
		else
			s1 = new String[] {"ʳ��","ҩ��","����","װ��","����","����"};
		
		if(s2 == null)
			s2 = new String[6][];
		
		if(sticking == null)
		{
			sticking = new int[10][Item.item_names.length];
		}
		
		int i,k;
		for(i = 0 ; i < 5;i++)
		{
			k=0;
			for(int  j : GmudWorld.mc.items)
				if(j >0 && GmudWorld.wp[j].kind == i)
					k++;
			
			s2[i] = new String[k];
			
			k=0;
			for(int  j : GmudWorld.mc.items)
			{
				if(j >0 && GmudWorld.wp[j].kind == i)
				{
					s2[i][k] = GmudWorld.wp[j].name + (GmudWorld.mc.equips(j)?"����װ����":"") + "x" + GmudWorld.mc.inventory[j];
					sticking[i][k] = j;
					k++;
				}
			}
		}
		i=5;
		
		k=0;
		for(int  j : GmudWorld.mc.items)
			if(j >0 && j != 77)
				k++;
		
		s2[i] = new String[k];
		
		k=0;
		for(int  j : GmudWorld.mc.items)
		{
			if(j >0 && j != 77)
			{
				s2[i][k] = GmudWorld.wp[j].name + (GmudWorld.mc.equips(j)?"����װ����":"") + "x" + GmudWorld.mc.inventory[j];
				sticking[i][k] = j;
				k++;
			}
		}
		
		if(layer==1)
			bottomWindow.text = GmudWorld.wp[sticking[v1.cursor][v2.cursor]].des;
		else
			bottomWindow.text = "";
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#onClick(int)
	 */
	@Override
	public void onClick(int c) {
		int d = v1.cursor;
		switch(d)
		{
		case 0:
			int a = GmudWorld.wp[sticking[d][c]].a3;
			int bb = GmudWorld.wp[sticking[d][c]].a4;
			if(GmudWorld.mc.food < GmudWorld.mc.getFoodmax()){
				GmudWorld.mc.drop(sticking[d][c], 1);
				GmudWorld.mc.food += a;
				GmudWorld.mc.drink += bb;
			}
			if(b)onCancel();
			break;
		case 1:
			switch(GmudWorld.wp[sticking[d][c]].subkind)
			{
			case 0:
				if(GmudWorld.mc.hp < GmudWorld.mc.maxhp)
				{
					GmudWorld.mc.drop(sticking[d][c], 1);
					GmudWorld.mc.cure((int) (GmudWorld.mc.maxhp * ((GmudWorld.wp[sticking[d][c]].a3+1)*0.25)));
				}
				break;
			case 1:
				GmudWorld.mc.drop(sticking[d][c], 1);
				GmudWorld.mc.maxfp += GmudWorld.wp[sticking[d][c]].a3;
				break;
			}
			if(b)onCancel();
			break;
		case 2:
			if(GmudWorld.mc.itemsckd[0] == sticking[d][c])
				GmudWorld.mc.itemsckd[0] = 0;
			else
				GmudWorld.mc.itemsckd[0] = sticking[d][c];
			break;
		case 3:
			int place = GmudWorld.wp[sticking[d][c]].subkind;
			int t[] = new int[0];
			if(GmudWorld.mc.equips(sticking[d][c]))
			{
				for(int i:GmudWorld.mc.itemsckd)
					if(i != sticking[d][c])
						t=GmudWorld.push_back(t, i);
			}else{
				for(int i:GmudWorld.mc.itemsckd)
					if(GmudWorld.wp[i].kind != 3 || GmudWorld.wp[i].subkind != place)
						t=GmudWorld.push_back(t, i);
				t=GmudWorld.push_back(t, sticking[d][c]);
			}
			GmudWorld.mc.itemsckd = t;

			break;
		case 4:
			if(GmudWorld.wp[sticking[d][c]].kind == 4)
			{
				if(sticking[d][c] == 81 && GmudWorld.mc.sex != 2)
				{
					GmudWorld.game.setScreen(new YesNoScreen(GmudWorld.game,"���Ҫ������"){

						@Override
						protected void onYes() {
							GmudWorld.game.setScreen(new YesNoScreen(GmudWorld.game,"�������"){

								@Override
								protected void onYes() {
									GmudWorld.mc.sex = 2;
									GmudWorld.game.setScreen(GmudWorld.ms);
								}

								@Override
								protected void onNo() {
									GmudWorld.game.setScreen(GmudWorld.ms);
								}

							});

						}

						@Override
						protected void onNo() {
							GmudWorld.game.setScreen(GmudWorld.ms);
						}

					});
				}
				else
				{
					if(GmudWorld.mc.skills[Skill.KIND_ZHISHI] <= 0)
						GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ms,"�㻹�Ǹ���ä��"));
					else if(GmudWorld.mc.faction < 7 && GmudWorld.mc.faction > 0)
					{
						GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ms,"������ѧ�ñ����书��"));
					}
					else
					{
						GmudWorld.mc.faction = 7;
						new ReadingDialog(GmudWorld.game).show(sticking[d][c]);
					}
				}
			}
			break;
		case 5:
			if(!GmudWorld.mc.only(sticking[d][c]))
				GmudWorld.mc.drop(sticking[d][c], 1);
			break;
		}
		if(layer==1)
			bottomWindow.text = GmudWorld.wp[sticking[d][c]].des;
		else
			bottomWindow.text = "";
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#drawbg()
	 */
	@Override
	public void drawbg() {
		GmudWorld.mapTile.drawMap(GmudWorld.ms.map, GmudWorld.ms.X, GmudWorld.ms.Y);
		GmudWorld.cnm.draw(MainCharTile.currentDirection, GmudWorld.cnm.currentStep, MainCharTile.X, MainCharTile.Y);
		bottomWindow.draw();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.DoubleScrollScreen#cancel()
	 */
	@Override
	public void cancel() {
		game.setScreen(ts);
	}

}
