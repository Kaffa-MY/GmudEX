/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����IGame.java <p>
 * ����ʱ�䣺2013-5-19 ����7:26:04 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework;

/**
 * ������IGame <p>
 * ˵����
 * @author 12548
 */
public interface IGame {
	public IInput getInput();
	
	public IFileIO getFileIO();
	
	public IGraphics getGraphics();
	
	//TODO��û���ġ���
	
	public void  setScreen(CScreen screen);
	
	public CScreen getCurrentScreen ();
	public CScreen getStartScreen();

	/**
	 * 
	 */
	public void oo();

}
