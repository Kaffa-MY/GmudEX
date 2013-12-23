/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ControlScreen.java <p>
 * ����ʱ�䣺2013-8-5 ����12:26:38 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle;

import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.proc.AttackStatus;
import lostland.gumd.platinum12548.battle.proc.RoundOverStatus;
import lostland.gumd.platinum12548.battle.proc.StuntScreen;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.SingleTouchHandler;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.core.MenuScreen;
import lostland.gumd.platinum12548.ui.core.NewButton;

/**
 * ������ControlScreen <p>
 * ˵����
 * @author 12548
 */
public class ControlScreen extends MenuScreen {

	BattleScreen bs = GmudWorld.bs;
	
	
	/**
	 * @param game
	 */
	public ControlScreen(IGame game) {
		super(game, new BattleButton[]{
				 new BattleButton((GmudGame) game,0),
				 new BattleButton((GmudGame) game,1),
				 new BattleButton((GmudGame) game,2),
				 new BattleButton((GmudGame) game,3),
				 new BattleButton((GmudGame) game,4)
		});
//		this.border = new DummyWindow((GmudGame) game);

	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		switch(index)
		{
		case 0:
			
			if(bs.zdp.dz > 0)
			{
				bs.zdp.dz--;
				bs.setStatus(new RoundOverStatus());
				ViewScreen.setText("�����ڴ���ľ����");
				game.setScreen(new ViewScreen(game));
			}
			else
			{
				AttackStatus.ag = bs.zdp.cg();
				bs.setStatus(new AttackStatus(new RoundOverStatus()));
				ViewScreen.setText(bs.bsp(AttackStatus.ag.c));
				game.setScreen(new ViewScreen(game));
			}
			break;
		case 1:
			if(bs.zdp.dz > 0)
			{
				bs.zdp.dz--;
				bs.setStatus(new RoundOverStatus());
				ViewScreen.setText("�����ڴ���ľ����");
				game.setScreen(new ViewScreen(game));
			}
			else
			{
				boolean flag = false;
				if(bs.zdp.getAttackSkill().kind == Skill.KIND_BINGREN)
				{
					int t[] ={30,23,38,17,18,11,29};
					for(int i:t)
						if(i == bs.zdp.skillsckd[1])
							flag = true;
				}
				else
				{
					int t[] ={31,39,12,13};
					for(int i:t)
						if(i == bs.zdp.skillsckd[0])
							flag = true;
				}
				int t[] ={25,26,20,36};
				for(int i:t)
					if(i == bs.zdp.skillsckd[3])
						flag = true;
				if(flag)
					game.setScreen(new StuntScreen(game));
			}
			break;
		case 2:
			if(bs.zdp.skillsckd[3]<10)
			{
				ViewScreen.setText("�����ѡ��Ҫ�õ��ڹ��ķ�");
				game.setScreen(new ViewScreen(game));
			}
			else if(bs.zdp.sp >= bs.zdp.hp)
			{
				ViewScreen.setText("�������������档");
				game.setScreen(new ViewScreen(game));
			}
			else if(bs.zdp.fp == 0)
			{
				ViewScreen.setText("�������������");
				game.setScreen(new ViewScreen(game));
			}
			else
			{
				bs.zdp.xiqi();
				ViewScreen.setText("���������˿�������ɫ�������ö��ˡ�");
				game.setScreen(new ViewScreen(game));
			}
			
			break;
		case 3:
			break;
		case 4:
			if(bs.zdp.dz > 0)
			{
				bs.zdp.dz--;
				bs.setStatus(new RoundOverStatus());
				ViewScreen.setText("�����ڶ������ã�");
				game.setScreen(new ViewScreen(game));
			}
			else
			{
				if(GmudWorld.rand.nextBoolean())
				{
					bs.setStatus(new RoundOverStatus());
					ViewScreen.setText(bs.bsp("$nһ��קס�㣬���ܣ�û�Ŷ���"));
					game.setScreen(new ViewScreen(game));
				}
				else
				{
					bs.eob = true;
					BattleOverScreen.tpflag = true;
					ViewScreen.setText(bs.bsp("��������"));
					game.setScreen(new ViewScreen(game));
				}
			}
		}
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.DialogScreen#onCancel()
	 */
	@Override
	public void onCancel() {
		// TODO �Զ����ɵķ������

	}



	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		GmudWorld.bs.present(0.01f);
		for(int i = 0; i < 5; i++)
			buttons[i].draw();
	}

	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.MenuScreen#onButtonDown(lostland.gumd.platinum12548.ui.core.NewButton)
	 */
	@Override
	protected void onButtonDown(NewButton b) {
		if(b == NewButton.NB_ENTER && cursor == 3)
		{
			SingleTouchHandler.flag = 7;
		}
		super.onButtonDown(b);
	}

}
