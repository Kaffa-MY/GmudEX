/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����BottomDialog.java <p>
 * ����ʱ�䣺2013-5-21 ����4:07:07 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.ui.meta;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ToggleButton;
import lostland.gmud.platinum12548.R;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.MapScreen;
import lostland.gumd.platinum12548.SavingScreen;

/**
 * ������BottomDialog <p>
 * ˵����
 * @author 12548
 */
public class SettingDialog extends Dialog {

	private Window mWindow;


	ToggleButton tb,tb2;
	Button btnSave;

	/**
	 * @param context
	 */
	public SettingDialog(Context context) {
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
		mWindow.setContentView(R.layout.dialog_settings);

		tb = (ToggleButton) findViewById(R.id.toggleButton1);

		tb.setChecked(MapScreen.zlEnabled);

		tb.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				MapScreen.zlEnabled = !MapScreen.zlEnabled;
			}

		});

		tb2 = (ToggleButton) findViewById(R.id.ToggleButton01);

		tb2.setChecked(MapScreen.btnsEnabled);

		tb2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				MapScreen.btnsEnabled = !MapScreen.btnsEnabled;
			}

		});


		btnSave = (Button) findViewById(R.id.btnSave);

		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				GmudWorld.game.setScreen(new SavingScreen(GmudWorld.game));
				cancel();
			}
		});
	}



}
