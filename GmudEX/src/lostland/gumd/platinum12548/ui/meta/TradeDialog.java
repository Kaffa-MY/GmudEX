/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BottomDialog.java <p>
 * ����ʱ�䣺2013-5-21 ����4:07:07 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.meta;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import lostland.gmud.platinum12548.R;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.ui.LearningScreen;
import lostland.gumd.platinum12548.ui.NotificationScreen;

/**
 * ������BottomDialog <p>
 * ˵����
 * @author 12548
 */
public class TradeDialog extends Dialog {

	private Window mWindow;

	ListView lv;
	TextView tv1,tv2;

	ArrayList<String> list;
	int sticking[] = new int[200];


	/**
	 * @param context
	 */
	public TradeDialog(Context context) {
		super(context);
		Log.e("aha1", "������");
		mWindow=this.getWindow();
		mWindow.setBackgroundDrawable(new ColorDrawable(0));
		mWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		WindowManager.LayoutParams lp=mWindow.getAttributes();
		lp.gravity=Gravity.CENTER;
		lp.dimAmount=0.0001f;
		mWindow.setAttributes(lp);
		setCanceledOnTouchOutside(true);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mWindow.setContentView(R.layout.dialog_trade);
		Log.e("aha0", "������");
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);

		lv = (ListView) findViewById(R.id.lvRead);
		Arrays.fill(sticking, 0);
	}

	int s;

	private ArrayAdapter<String> aa;
	public void show(final int npcid)
	{
		list = new ArrayList<String>();
		switch(GmudWorld.npc[npcid].trading)
		{
		case 1:
			tv1.setText("Ҫ��ʲô���Լ������ɣ�");
			tv2.setText("��Ǯ��"+GmudWorld.mc.gold);
			
			for(int i:GmudWorld.npc[npcid].sells)
				push(GmudWorld.wp[i].name+"(�۸�"+GmudWorld.wp[i].cost+")",i);

			aa = new ArrayAdapter<String>(GmudWorld.game, android.R.layout.simple_expandable_list_item_1,list);
			
			lv.setAdapter(aa);

			lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					s = arg2;
					if(GmudWorld.wp[sticking[s]].cost <= GmudWorld.mc.gold && (!GmudWorld.mc.only(sticking[s])))
					{
						GmudWorld.mc.gold -= GmudWorld.wp[sticking[s]].cost;
						GmudWorld.mc.give(sticking[s]);
					}
					tv2.setText("��Ǯ��"+GmudWorld.mc.gold);
				}
			});
			break;
			
		case 2:
			tv1.setText("��ʲô���õĶ����������ɣ�");
			tv2.setText("��Ǯ��"+GmudWorld.mc.gold);
			
			re();
			
			lv.setAdapter(new ArrayAdapter<String>(GmudWorld.game, android.R.layout.simple_expandable_list_item_1,list));
			lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					s = arg2;
					if(!(GmudWorld.mc.inventory[sticking[s]] == 1 && GmudWorld.mc.equips(sticking[s])))
					{
						GmudWorld.mc.gold += (int)(GmudWorld.wp[sticking[s]].cost * 0.7);
						GmudWorld.mc.drop(sticking[s], 1);
//						tv2.setText("��Ǯ��"+GmudWorld.mc.gold);
						re();
//						aa.notifyDataSetChanged();
					}
					tv2.setText("��Ǯ��"+GmudWorld.mc.gold);
				}
			});
			break;
			
		case 101:
			tv1.setText("����ѧʲô��˵�ɣ�");
			tv2.setVisibility(View.INVISIBLE);
			for(int i=0;i<GmudWorld.npc[npcid].skills.length;i++)
				if(GmudWorld.npc[npcid].skills[i]>0)
					push(GmudWorld.skill[i].name + "x" + GmudWorld.npc[npcid].skills[i], i);
			lv.setAdapter(new ArrayAdapter<String>(GmudWorld.game, android.R.layout.simple_expandable_list_item_1,list));
			
			lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					s = arg2;
					if(!GmudWorld.mc.expcanlearn(GmudWorld.mc.skills[sticking[s]]+1))
						GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ms,"�����ѧ���鲻�㣬�޷�������Ĺ���"));
					else if(GmudWorld.mc.skills[sticking[s]] > GmudWorld.npc[npcid].skills[sticking[s]])
						GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ms,"��Ĺ����Ѿ�����Ϊʦ�ˣ����ǿ�ϲ�ɺ�ѽ��"));
					else if(GmudWorld.mc.potential == 0)
					{
						GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ms,"���Ǳ���Ѿ����ӵ�������"));
						cancel();
						return;
					}
					else
					{
						GmudWorld.game.setScreen(new LearningScreen(GmudWorld.game,GmudWorld.ms,sticking[s], GmudWorld.npc[npcid].skills[sticking[s]]));
						cancel();
						return;
					}
				}
			});
			break;
		}

		super.show();
	}


	public void re()
	{
		Arrays.fill(sticking,0);
		list = new ArrayList<String>();
		for(int i:GmudWorld.mc.items)
			if(i!=0)
				push(GmudWorld.wp[i].name + "x" + GmudWorld.mc.inventory[i]+"(�۸�"+(int)(GmudWorld.wp[i].cost * 0.7)+")",i);
	}
	


	public void push(String s,int i)
	{
		list.add(s);
		sticking[list.size()-1] = i;
	}

}
