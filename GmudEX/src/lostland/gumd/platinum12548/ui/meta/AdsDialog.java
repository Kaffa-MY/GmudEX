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
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import lostland.gmud.platinum12548.R;
import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.ui.NotificationScreen;

/**
 * ������BottomDialog <p>
 * ˵����
 * @author 12548
 */
public class AdsDialog extends Dialog {

	private Window mWindow;
	
	EditText et;
	
	
	/**
	 * @param context
	 */
	public AdsDialog(Context context) {
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
		mWindow.setContentView(R.layout.dialog_ads);
		
		et = (EditText) findViewById(R.id.etBon);
	}
	

	@Override
	public void show()
	{
		et.setText(""+GmudWorld.mc.ads);
		super.show();
	}


	/* ���� Javadoc��
	 * @see android.app.Dialog#cancel()
	 */
	@Override
	public void cancel() {
		int i;
		String t = et.getText().toString();
		try{
			i = Integer.parseInt(t);
		}
		catch(NumberFormatException e)
		{
			i = 0;
		}
		
		if(i<0)i=0;
		if(i>GmudWorld.mc.getAdsLimit())i=GmudWorld.mc.getAdsLimit();
		
		GmudWorld.mc.ads = i;
		
		GmudWorld.game.setScreen(new NotificationScreen(GmudWorld.game,GmudWorld.ims,"��Ŀǰ��������Ϊ"+GmudWorld.mc.getAdsLimit()));
		super.cancel();
	}
	
}
