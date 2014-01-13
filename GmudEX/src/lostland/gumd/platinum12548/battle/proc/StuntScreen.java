/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����StuntScreen.java <p>
 * ����ʱ�䣺2013-8-12 ����10:31:26 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.battle.proc;

import java.util.ArrayList;

import android.util.Log;

import lostland.gumd.platinum12548.FontSize;
import lostland.gumd.platinum12548.GmudGame;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.battle.ControlScreen;
import lostland.gumd.platinum12548.battle.ViewScreen;
import lostland.gumd.platinum12548.battle.proc.stunt.���־�;
import lostland.gumd.platinum12548.battle.proc.stunt.JiZiJue;
import lostland.gumd.platinum12548.battle.proc.stunt.LiuLangWenYing;
import lostland.gumd.platinum12548.battle.proc.stunt.LiuXingFeiZhi;
import lostland.gumd.platinum12548.battle.proc.stunt.LuanHuanJue;
import lostland.gumd.platinum12548.battle.proc.stunt.LuoYingBinFen;
import lostland.gumd.platinum12548.battle.proc.stunt.SanHuanTaoYue;
import lostland.gumd.platinum12548.battle.proc.stunt.ShenDaoGuiDie;
import lostland.gumd.platinum12548.battle.proc.stunt.XueHuaLiuChu;
import lostland.gumd.platinum12548.battle.proc.stunt.YinYangJue;
import lostland.gumd.platinum12548.battle.proc.stunt.ZhenZiJue;
import lostland.gumd.platinum12548.battle.proc.stunt.ӭ��һ��ն;
import lostland.gumd.platinum12548.blgframework.IGame;
import lostland.gumd.platinum12548.blgframework.impl.BLGGraphics;
import lostland.gumd.platinum12548.data.Skill;
import lostland.gumd.platinum12548.ui.core.ArrowButton;
import lostland.gumd.platinum12548.ui.core.GmudWindow;
import lostland.gumd.platinum12548.ui.core.MenuScreen;

/**
 * ������StuntScreen <p>
 * ˵����
 * @author 12548
 */
public class StuntScreen extends MenuScreen{

	public static final String name[] = new String[]{
		"���־�","���־�","������","�һ���","���־�","���־�","��������","���Ƿ���","ѩ������","�񵹹��",
		"��Ӣ�ͷ�","������ݺ","����Ϊ��","���Ե�Ӱ��","����Ӱ��","����Ϊ��","��������ն","ӭ��һ��ն","�׶�����","��������",
		"���ľ�","����","������Ļ","�̷�Ӱ����"
	};

	public static final int sklNeeded[][] = new int[][]{
		{1,31,0,32},{60,60,60,60},//���־�
		{1,31,0,32},{70,70,70,70},//���־�
		{1,31,0,32},{120,120,120,120},//����
		{1,31,0,32},{100,100,100,100},//�һ�
		{2,30,0,32},{80,80,80,80},//���־�
		{2,30,0,32},{80,80,80,80},//���־�
		{2,30,0,32},{120,120,120,120},//��������
		{0,25,5,23},{80,80,80,80},//���Ƿ���
		{2,38,0,36},{60,60,60,60},//ѩ������
		{1,39,0,36},{80,80,100,100},//�񵹹��
		{6,17,0,20},{80,80,80,80},//��Ӣ�ͷ�
		{3,18,0,20},{100,100,100,100},//������ݺ
		{12,1,0,14},{70,70,70,70},//����Ϊ��
		{11,0,14},{90,70,70},
		{11,0,14},{90,70,70},
		{0,1,13},{90,90,90},//����Ϊ��
		{0,26,3,29},{80,80,60,60},
		{0,26,3,29},{80,80,80,80},
		{0,25},{60,60},
		{0,25},{80,80},
		{0,36},{60,60},
		{0,20},{60,60},
		{0,26},{60,60},
		{0,26},{80,80}
	};

	public static final int cost[] = new int[]{
		200,350,300,500,250,350,400,850,600,350,
		400,400,200,450,150,400,350,550,150,350,
		250,350,300,550
	};

	public static final int cd[] = new int[]{
		2,2,6,9,6,9,5,5,4,9,
		4,4,4,4,4,4,7,7,5,5
		,5,5,5,5
	};

	static int cnt = 0;
	static int[] t = new int[10];
	static ArrayList<String> s = new ArrayList<String>();
	public static int i;
	/**
	 * @param game
	 */
	public StuntScreen(IGame game) {
		super(game,getWindows());


		this.dummyBorder = new GmudWindow((GmudGame) game, 48, 44, 70, 12*cnt+2){
			@Override
			public void draw() {
				this.drawBackground();
			}
		};
	}

	public static boolean canuse(int index)
	{
		boolean flag = false;
		if(GmudWorld.bs.zdp.getAttackSkill().kind == Skill.KIND_BINGREN)
		{
			int t[] ={30,23,38,17,18,11,29};
			for(int i:t)
				if(i == GmudWorld.bs.zdp.skillsckd[1])
				{
					switch(i)
					{
					case 30:
						switch(index)
						{
						case 4:
						case 5:
						case 6:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 23:
						switch(index)
						{
						case 7:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 38:
						switch(index)
						{
						case 8:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 17:
						switch(index)
						{
						case 10:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 18:
						switch(index)
						{
						case 11:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 11:
						if(index == 13 && GmudWorld.bs.zdp.skillsckd[0] == 12)
							flag = true;
						else if(index == 14 && GmudWorld.bs.zdp.skillsckd[0] == 13)
							flag = true;
						
						break;
					case 29:
						switch(index)
						{
						case 16:
						case 17:
							flag = true;
							break;
						default:
							break;
						}
						
						break;
					default:
						break;
					}
				}
		}
		else
		{
			int t[] ={31,39,12,13};
			for(int i:t)
				if(i == GmudWorld.bs.zdp.skillsckd[0])
				{
					switch(i)
					{
					case 31:
						switch(index)
						{
						case 0:
						case 1:
						case 2:
						case 3:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 39:
						switch(index)
						{
						case 9:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 12:
						switch(index)
						{
						case 12:
							flag = true;
							break;
						default:
							break;
						}
						break;
					case 13:
						switch(index)
						{
						case 15:
							flag = true;
							break;
						default:
							break;
						}
						break;
					}
				}
		}
		int t[] ={25,26,20,36};
		for(int i:t)
			if(i == GmudWorld.bs.zdp.skillsckd[3])
			{
				switch(i)
				{
				case 25:
					switch(index)
					{
					case 18:
					case 19:
						flag = true;
						break;
					default:
						break;
					}
					break;
				case 26:
					switch(index)
					{
					case 22:
					case 23:
						flag = true;
						break;
					default:
						break;
					}
					break;
				case 20:
					switch(index)
					{
					case 21:
						flag = true;
						break;
					default:
						break;
					}
					break;
				case 36:
					switch(index)
					{
					case 20:
						flag = true;
						break;
					default:
						break;
					}
					break;
				}
			}




		if(GmudWorld.bs.zdp.sz[index]>0)
			return false;

		if(GmudWorld.bs.zdp.fp < cost[index])
			return false;

		for(int i=0;i<sklNeeded[index*2].length;i++)
		{
			if(GmudWorld.bs.zdp.skills[sklNeeded[index*2][i]]<sklNeeded[index*2+1][i])
			{
				return false;
			}
		}

		if(index == 7 && GmudWorld.bs.zdp.getStr()<32)
			return false;

		return flag;
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.MenuScreen#onClick(int)
	 */
	@Override
	protected void onClick(int index) {
		boolean flag = false;

		if(GmudWorld.bs.zdp.sz[t[index]]>0){
			ViewScreen.setText("��������⹦��������ЪЪ��");
			flag = true;
		}else if(GmudWorld.bs.zdp.fp < cost[t[index]]){
			ViewScreen.setText("�����������");
			flag = true;
		}else{
			for(int i=0;i<sklNeeded[t[index]*2].length;i++)
			{
				if(GmudWorld.bs.zdp.skills[sklNeeded[t[index]*2][i]]<sklNeeded[t[index]*2+1][i])
				{
					ViewScreen.setText("���"+GmudWorld.skill[sklNeeded[t[index]*2][i]].name+"��Ϊ����");
					flag = true;
					break;
				}
			}
		}


		if(!flag){
			process(t[index]);
		}

		game.setScreen(new ViewScreen(game));

	}


	@Override
	public void onCancel() {
		game.setScreen(new ControlScreen(game));

	}

	public static void StuntOver()
	{
		AttackStatus.ts = new RoundOverStatus();
		GmudWorld.bs.setStatus(new DummyStatus());

		GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
	}


	/* ���� Javadoc��
	 * @see lostland.gumd.platinum12548.ui.core.ButtonControlledScreen#show()
	 */
	@Override
	protected void show() {
		GmudWorld.bs.present(0.01f);
		dummyBorder.draw();
		for(int i = 0; i < cnt; i++)
			buttons[i].draw();
	}


	static GmudWindow[] getWindows()
	{
		cnt = 0;
		t = new int[10];
		s = new ArrayList<String>();

		if(GmudWorld.bs.zdp.getAttackSkill().kind == Skill.KIND_BINGREN)
			switch(GmudWorld.bs.zdp.skillsckd[1]){
			case 30:
				t[s.size()] = 4;
				s.add(name[t[s.size()]]);
				t[s.size()] = 5;
				s.add(name[t[s.size()]]);
				t[s.size()] = 6;
				s.add(name[t[s.size()]]);
				cnt+=3;
				break;
			case 23:
				t[s.size()] = 7;
				s.add(name[t[s.size()]]);

				cnt++;
				break;
			case 38:
				t[s.size()] = 8;
				s.add(name[t[s.size()]]);
				cnt++;
				break;
			case 17:
				t[s.size()] = 10;
				s.add(name[t[s.size()]]);
				cnt++;
				break;
			case 18:
				t[s.size()] = 11;
				s.add(name[t[s.size()]]);
				cnt++;
				break;
			case 11:
				if(GmudWorld.bs.zdp.getEquipedSkill(0).id ==12)
				{
					t[s.size()] = 13;
					s.add(name[t[s.size()]]);
					cnt++;
				}
				else if (GmudWorld.bs.zdp.getEquipedSkill(0).id ==13)
				{
					t[s.size()] = 14;
					s.add(name[t[s.size()]]);
					cnt++;
				}
				break;
			case 29:
				t[s.size()] = 16;
				s.add(name[t[s.size()]]);
				t[s.size()] = 17;
				s.add(name[t[s.size()]]);
				cnt +=2;
				break;
			default:
				break;
			}
		else
		{
			switch(GmudWorld.bs.zdp.getEquipedSkill(0).id)
			{
			case 31:
				t[s.size()] = 0;
				s.add(name[t[s.size()]]);
				t[s.size()] = 1;
				s.add(name[t[s.size()]]);
				t[s.size()] = 2;
				s.add(name[t[s.size()]]);
				t[s.size()] = 3;
				s.add(name[t[s.size()]]);
				cnt +=4;
				break;
			case 39:
				t[s.size()] = 9;
				s.add(name[t[s.size()]]);
				cnt++;
				break;
			case 12:
				t[s.size()] = 12;
				s.add(name[t[s.size()]]);
				cnt++;
				break;
			case 13:
				t[s.size()] = 15;
				s.add(name[t[s.size()]]);
				cnt++;
				break;
			default:
				break;
			}
		}

		switch(GmudWorld.bs.zdp.getEquipedSkill(3).id)
		{
		case 25:
			t[s.size()] = 18;
			s.add(name[t[s.size()]]);
			t[s.size()] = 19;
			s.add(name[t[s.size()]]);
			cnt+=2;
			break;
		case 26:
			t[s.size()] = 22;
			s.add(name[t[s.size()]]);
			t[s.size()] = 23;
			s.add(name[t[s.size()]]);
			cnt+=2;
			break;
		case 20:
			t[s.size()] = 21;
			s.add(name[t[s.size()]]);
			cnt++;
			break;
		case 36:
			t[s.size()] = 20;
			s.add(name[t[s.size()]]);
			cnt++;
			break;
		default:
			break;
		}

		ArrowButton[] tw = new ArrowButton[cnt];
		for(i=0;i<cnt;i++)
		{
			tw[i] = new ArrowButton((GmudGame) GmudWorld.game, 49, 45+12*i, 60, 12){
				final int a = i;
				@Override
				public void draw() {
					this.drawBackground();
					BLGGraphics g = (BLGGraphics) game.getGraphics();
					g.drawText(name[t[a]], x+8, y, FontSize.FT_12PX);
				}
			};
		}

		return tw;
	}

	public static void process(int index)
	{
		switch(index)
		{
		case 0://���־�
			ViewScreen.setText(GmudWorld.bs.bsp("ͻȻ$N˫������������һ��ԲȦ�ѽ�$n��ס��̫��ȭ�����־��漴ʹ����"));
			GmudWorld.bs.setStatus(new ZhenZiJue());
			break;
		case 1://���־�
			ViewScreen.setText(GmudWorld.bs.bsp("$N�ҽ�ʵ������飬���� [��] �־���ճ��ճ�棬���Ʒ����Ѵ�ס$n���֣�"));
			GmudWorld.bs.setStatus(new JiZiJue());
			break;
		case 2://������
			ViewScreen.setText(GmudWorld.bs.bsp("[̫�����������ޣ����¿����ʸ���] ����������ʹ��ʱ���Ტ�ã�ίʱ���Ī�⣡"));
			GmudWorld.bs.setStatus(new YinYangJue());
			break;
		case 3://�һ���
			ViewScreen.setText(GmudWorld.bs.bsp("$N��һ����̫��ԲȦ������������֮΢��������$n��ǧ����� ��"));
			GmudWorld.bs.setStatus(new LuanHuanJue());
			break;
		case 4://���־�
			ViewScreen.setText(GmudWorld.bs.bsp("$Nÿһ�о����Ի��δ̳��������ջأ����಻��������$n�ս���"));
			GmudWorld.bs.setStatus(new ���־�());
			break;
		case 5://���־�
			ViewScreen.setText(GmudWorld.bs.bsp("$N���н����ϻ�Ȧ������Ȧһ��δ����һ�����������Ȧ����һ��������������ˮ��©��"));
			GmudWorld.bs.zdp.evd_bouns += GmudWorld.bs.zdp.skills[30] / 10;
			GmudWorld.bs.zdp.hit_bouns += 10;
			GmudWorld.bs.zdp.buff[0] = 8;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 6://��������
			ViewScreen.setText(GmudWorld.bs.bsp("$N����бָ��ʹ��̫������ѧ�������£���������ֱ��$n������"));
			GmudWorld.bs.setStatus(new SanHuanTaoYue(98));
			break;
		case 7://���Ƿ���

			if(GmudWorld.bs.zdp.getStr()<32)
			{
				ViewScreen.setText(GmudWorld.bs.bsp("����������������ʹ�����Ƿ�����"));
				GmudWorld.game.setScreen(new ViewScreen(GmudWorld.game));
				return;
			}
			ViewScreen.setText(GmudWorld.bs.bsp("$N����������Хһ����������$w��$n����������ȥ�Ƽ���������������磡"));

			GmudWorld.bs.setStatus(new LiuXingFeiZhi());
			break;
		case 8://ѩ������

			ViewScreen.setText(GmudWorld.bs.bsp("$N��Хһ����ʹ��ѩɽ��ѩ������������ѩ������֮�ͣ�һ˲����$n�̳�������"));
			GmudWorld.bs.setStatus(new XueHuaLiuChu());
			break;
		case 9://�񵹹��
			ViewScreen.setText(GmudWorld.bs.bsp("$Nʹ�������񵹹����������һ��һץһ��������У���˵����ҲҪˤ����ͷ��"));
			GmudWorld.bs.setStatus(new ShenDaoGuiDie());
			break;
		case 10://��Ӣ�ͷ�
			ViewScreen.setText(GmudWorld.bs.bsp("$N����$w���裬����һ����һ��Ȧ�ӣ�$n������Ȧһ�ƣ���ʱ�ۻ����ң�"));
			GmudWorld.bs.setStatus(new LuoYingBinFen());
			break;
		case 11://������ݺ
			ViewScreen.setText(GmudWorld.bs.bsp("$Nʹ��������ݺ��������$nͬʱ��������һ����һʱ�䵶���������Ʒ���ݺ��"));
			GmudWorld.bs.setStatus(new LiuLangWenYing());
			break;
		case 12://����Ϊ��

			ViewScreen.setText(GmudWorld.bs.bsp("$N����һ��������Ԫһ�����Ƶ�˫�ƣ�������������Ĺ�â����Ե��������ֵ�һ�㣡"));
			GmudWorld.bs.zdp.hit_bouns += (GmudWorld.bs.zdp.skills[1]+GmudWorld.bs.zdp.skills[12])/20;
			GmudWorld.bs.zdp.buff[2]+=4;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 13://���Ե�Ӱ��
			ViewScreen.setText(GmudWorld.bs.bsp("$Nʹ�������ŵ�Ӱ�ƾ�ѧ��һʱ�䵶���������Ʒ��Х��������Ӱֱ��$n������"));
			GmudWorld.bs.setStatus(new LiuLangWenYing());
			break;
		case 14://���Ե�Ӱ��
			ViewScreen.setText(GmudWorld.bs.bsp("$Nʹ�������ŵ�Ӱ�ƾ�ѧ��һʱ�䵶���������Ʒ��Х��������Ӱֱ��$n������"));
			GmudWorld.bs.setStatus(new LiuLangWenYing());
			break;
		case 15://����Ϊ��

			ViewScreen.setText(GmudWorld.bs.bsp("$N����һ��������Ԫһ�����Ƶ�˫�ƣ�������������Ĺ�â����Ե��������ֵ�һ�㣡"));
			GmudWorld.bs.zdp.str_bouns += GmudWorld.bs.zdp.skills[13]/5;
			GmudWorld.bs.zdp.hit_bouns += GmudWorld.bs.zdp.skills[13]/10;
			GmudWorld.bs.zdp.dz +=3;
			GmudWorld.bs.zdp.buff[6]+=7;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 16://��������ն
			ViewScreen.setText(GmudWorld.bs.bsp("$N��ָ������Ʒ���������ʹ����������ն���������������������������"));
			GmudWorld.bs.setStatus(new SanHuanTaoYue(87));
			break;
		case 17://ӭ��һ��ն
			ViewScreen.setText(GmudWorld.bs.bsp("$N�����յ�������Х����ʱ�����Ϊ֮��ɫ����һ��֮����Ȼƽƽ��ȴ�������ˣ�"));
			GmudWorld.bs.setStatus(new ӭ��һ��ն());
			break;
		case 18://�׶�����
			ViewScreen.setText(GmudWorld.bs.bsp("$NĬ��������壬����žž���죬������ת�䣬�������ϵ�������ǿ�ˣ�"));
			GmudWorld.bs.zdp.str_bouns += 3+(GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[25])/10;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 19://��������
			ViewScreen.setText(GmudWorld.bs.bsp("$N����Ĭ�к������壺ȥ�г���Ψ�ҹ�������������˫�ۣ��ƺ�������ս������"));
			GmudWorld.bs.zdp.hit_bouns += -3+(GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[25])/10;
			GmudWorld.bs.zdp.dz++;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 20://���ľ�
			ViewScreen.setText(GmudWorld.bs.bsp("$N����һ������ȫ��������ת��������������һƬ���ѩ��ľ�Ө֮ɫ��"));
			GmudWorld.bs.zdp.def_bouns += (GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[36]*2)/8;
			GmudWorld.bs.zdp.buff[5]+=9;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 21://����
			ViewScreen.setText(GmudWorld.bs.bsp("$N�����˹���������һƬ�߲�Ѥ��֮ɫ���ƺ�����һ��������ѣ�����Ȼ��죡"));
			GmudWorld.bs.zdp.agi_bouns += GmudWorld.bs.zdp.skills[20] / 10;
			GmudWorld.bs.zdp.evd_bouns += (GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[20]*2)/10 -5;
			GmudWorld.bs.zdp.buff[2]+=(GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[20])/40;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		case 22://������Ļ
			ViewScreen.setText(GmudWorld.bs.bsp("$N˫�����ӣ�һ�ƻ��ڵ��ϣ��ڵ�һ������һ����Ļ��$n��ǰ��ʱһƬ�谵��"));

			double hit_rate = 0.8 + 0.2 * (((double)GmudWorld.bs.zdp.fp - GmudWorld.bs.bdp.fp) / (double)(GmudWorld.bs.zdp.fp + GmudWorld.bs.bdp.fp + 1));
			
			Log.i("������Ļ","������=" + hit_rate);
			
			boolean hit = Math.random() < hit_rate;
			
			
			if(hit)
			{
				GmudWorld.bs.zdp.buff[3]+=(GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[26])/40;
				GmudWorld.bs.bdp.hit_bouns -= 20;
				GmudWorld.bs.setStatus(new RoundOverStatus());
			}
			else
			{
				GmudWorld.bs.setStatus(new Status(){
					@Override
					public boolean execute() {
						ViewScreen.setText(GmudWorld.bs.bsp("û�뵽$n������񣬵�������һ�ƣ���ɢ������"));
						GmudWorld.bs.zdp.dz+=3;
						StuntOver();
						return false;
					}
				});
			}

			break;
		case 23://�̷�Ӱ����
			ViewScreen.setText(GmudWorld.bs.bsp("$N˫�ֺ������μ�ת��һ���ͺ��У���Ӱһ��Ϊ����$nһʱ���ֱ粻����٣�"));
			GmudWorld.bs.zdp.buff[4]+=(GmudWorld.bs.zdp.skills[0]+GmudWorld.bs.zdp.skills[26])/40;
			GmudWorld.bs.setStatus(new RoundOverStatus());
			break;
		}
		GmudWorld.bs.zdp.fp -= cost[index];
		GmudWorld.bs.zdp.sz[index] += cd[index];
	}

}
