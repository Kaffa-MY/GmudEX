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
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import lostland.gmud.platinum12548.R;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.ui.LearningScreen;
import lostland.gumd.platinum12548.ui.NotificationScreen;

/**
 * ������BottomDialog <p>
 * ˵����
 * @author 12548
 */
public class ReadingDialog extends Dialog {

	private Window mWindow;

	ListView lv;

	ArrayList<String> list;
	int sticking[] = new int[200];
	int s2[] = new int[2000];

	/**
	 * @param context
	 */
	public ReadingDialog(Context context) {
		super(context);
		mWindow=this.getWindow();
		mWindow.setBackgroundDrawable(new ColorDrawable(0));
		mWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		WindowManager.LayoutParams lp=mWindow.getAttributes();
		lp.gravity=Gravity.CENTER;
		lp.dimAmount=0.0001f;
		mWindow.setAttributes(lp);
		setCanceledOnTouchOutside(true);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mWindow.setContentView(R.layout.dialog_reading);

		lv = (ListView) findViewById(R.id.lvRead);
		Arrays.fill(sticking, 0);
		Arrays.fill(s2, 250);
	}

	int s;
	public void show(final int itmid)
	{
		list = new ArrayList<String>();

		switch(itmid)
		{
		case 68: // ȭ��
			push(250,1);
			push(200,40);
			break;
		case 69: // ����ֽҳ
			push(250,8);
			push(250,7);
			break;
		case 70:
			push(250,3);
			push(200,29);
			break;
		case 71:
			push(250,0);
			push(250,20);
			break;
		case 81:
			push(250,10);
			push(100,41);
			break;
		}

		lv.setAdapter(new ArrayAdapter<String>(GmudWorld.game, android.R.layout.simple_expandable_list_item_1,list));

		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				s = arg2;
				if(GmudWorld.mc.potential == 0)
				{
					GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ms,"���Ǳ���Ѿ����ӵ�������"));
					cancel();
					return;
				}
				else
				{
					GmudWorld.game.setScreen(new LearningScreen(GmudWorld.game,GmudWorld.ms,sticking[s], s2[sticking[s]]));
					cancel();
					return;
				}
			}
		});


		super.show();
	}




	public void push(int lvl,int i)
	{
		list.add(GmudWorld.skill[i].name + "x" + lvl);
		sticking[list.size()-1] = i;
		s2[sticking[s]] = lvl;
	}

}
