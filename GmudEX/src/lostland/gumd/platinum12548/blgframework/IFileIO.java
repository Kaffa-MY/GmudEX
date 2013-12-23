/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����IFileIO.java <p>
 * ����ʱ�䣺2013-5-19 ����7:09:55 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.SharedPreferences;

/**
 * ������IFileIO <p>
 * ˵����
 * @author 12548
 */
public interface IFileIO {
	public InputStream readAsset(String fileName) throws IOException;
	
	public InputStream readFile(String FileName) throws IOException;
	
	public OutputStream writeFile(String fileName) throws IOException;
	
	public SharedPreferences getPreferences();
}
