/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MemAntiCheater.java <p>
 * ����ʱ�䣺2013-9-25 ����9:24:44 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.data;

import java.util.zip.Adler32;

import android.util.Log;

import lostland.gumd.platinum12548.GmudWorld;
import lostland.gumd.platinum12548.blgframework.BasicScreen;

/**
 * ������MemAntiCheater <p>
 * ˵����
 * @author 12548
 */
public class MemAntiCheater {

	private Adler32 a;
	private boolean running = false;
	
	private long chksum;
	
	private int rint;
	
	/**
	 * 
	 */
	public MemAntiCheater() {
		a = new Adler32();
		rint = GmudWorld.rand.nextInt();
	}

	public void render()
	{
		if(!running)
			return;
		
		long t = check();
		if(t != chksum && BasicScreen.b)
		{
			Log.e("MemAntiCheater", "�ڴ�У��ʧ�ܣ�");
			GmudWorld.mc.exp = 0;
			GmudWorld.mc.potential = 0;
			
			for(int i = 0; i<GmudWorld.mc.skills.length; i++)
				GmudWorld.mc.skills[i] = 0;
			
			recheck();
			
		}
	}
	
	public long check()
	{
		a.reset();
		
		long t = a.getValue();
		
		try{
			
		
		a.update(12548);
		a.update(GmudWorld.mc.exp);
		a.update(GmudWorld.mc.potential);
		
		a.update(rint);
		
		for(int i : GmudWorld.mc.skills)
			a.update(i);
		a.update(32768);
		
		t = a.getValue();
//		Log.w("MemAntiCheater", "checking:" + t);
		
		}
		finally{
			//.......
		}
		return t;
	}
	
	public void recheck()
	{
		chksum = check();
		Log.w("MemAntiCheater", "rechecked:" + chksum);
	}
	
	public void start()
	{
		recheck();
		running = true;
	}
	
	public void stop()
	{
		running = false;
	}
	
	private static MemAntiCheater getInstance()
	{
		return GmudWorld.game.getCurrentScreen().getMAC();
	}
	
	public static void notifyChange()
	{
		getInstance().recheck();
	}

	/**
	 * @return running
	 */
	public boolean isRunning() {
		return running;
	}
}
