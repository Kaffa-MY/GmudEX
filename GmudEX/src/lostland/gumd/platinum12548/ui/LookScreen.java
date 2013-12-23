/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����LookScreen.java <p>
 * ����ʱ�䣺2013-8-24 ����10:42:26 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui;

import java.util.ArrayList;

import android.util.Log;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GameConstants;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.ui.core.DialogScreen;

/**
 * ������LookScreen <p>
 * ˵����
 * @author 12548
 */
public class LookScreen extends DialogScreen {

	
	ArrayList<String> pages = new ArrayList<String>();
	BLGGraphics g = (BLGGraphics) game.getGraphics();
	public int page = 0;
	
	
	/**
	 * @param game
	 */
	public LookScreen(IGame game,int npcid) {
		super(game);
		this.border = new StatusBorder((GmudGame) game);
		ArrayList<String> t;
		Log.i("look", "npc:"+npcid + GameConstants.faction_text[GmudWorld.npc[npcid].faction]);
		String s = GmudWorld.npc[npcid].name+"������Լ" + GmudWorld.npc[npcid].age/10 + 
				"0����\n���տ�����" + GmudWorld.pj[GmudWorld.npc[npcid].getpj()] +
				"\n�����ƺ�" + GmudWorld.npc[npcid].getcs() +
				"\n����:";
		Log.i("look", "npc:"+npcid);
		for(int i=0;i<GmudWorld.npc[npcid].items.length;i++)
			if(GmudWorld.npc[npcid].items[i] !=0)
				s+=" " + GmudWorld.wp[GmudWorld.npc[npcid].items[i]].name;
		s+="\n";
		Log.i("look", "npc:"+npcid);
		if(npcid != GmudWorld.npc.length-1){
			final int p1 = 24;
			if(GmudWorld.npc[npcid].des.length()>p1)
			{
				s+=GmudWorld.npc[npcid].des.substring(0, p1);
				pages.add(s);
				String ss = GmudWorld.npc[npcid].des.substring(p1);
				t = g.splitString(ss, FontSize.FT_12PX, 87, 6);
				pages.addAll(t);
			}
			else
			{
				s+=GmudWorld.npc[npcid].des;
				pages.add(s);
			}
		}
		else
			pages.add(s);
		Log.i("look", "npc:"+npcid);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchDown(int, int)
	 */
	@Override
	protected void onTouchDown(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchMove(int, int)
	 */
	@Override
	protected void onTouchMove(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onTouchUp(int, int)
	 */
	@Override
	protected void onTouchUp(int tx, int ty) {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onClick(int, int)
	 */
	@Override
	protected void onClick(int tx, int ty) {
		
		if(page<pages.size()-1)
			page++;
		else
			game.setScreen(GmudWorld.ms);
		
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		if(page<pages.size()-1)
			page++;
		else
			game.setScreen(GmudWorld.ms);
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#present(float)
	 */
	@Override
	public void present(float deltaTime) {
		border.draw();
		if(page>0)
			g.drawSplitedText(pages.get(page), border.x + 2, border.y + 2, FontSize.FT_12PX);
		else
			g.drawText(pages.get(page), border.x + 2, border.y + 2, FontSize.FT_12PX, 144);

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#pause()
	 */
	@Override
	public void pause() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#resume()
	 */
	@Override
	public void resume() {
		// TODO �Զ����ɵķ������

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.blgframework.CScreen#dispose()
	 */
	@Override
	public void dispose() {
		
	}

}
