/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����ItemRoom.java <p>
 * ����ʱ�䣺2014-1-15 ����10:05:27 <p>
 * ������Ŀ��GmudEX <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.data;

/**
 * ������Room <p>
 * ˵����
 * @author 12548
 */
public class Room {

	private void item(ItemGenerator g)
	{
		//TODO: δʵ��
	}
	
	private abstract class ItemGenerator {
		
		//������Ʒ��
		void name(String s)
		{
			//TODO: δʵ��
		}
		
		//������Ʒ����
		void type(int id)
		{
			//TODO: δʵ��
		}
		
		//������Ʒ�����ͣ�װ��λ�ã�
		void subtype(int id)
		{
			//TODO: δʵ��
		}
		
		//�Ƿ�ɶ���
		void dropable(boolean b)
		{
			//TODO: δʵ��
		}
		
		//������Ʒ����
		void desc(String s)
		{
			//TODO: δʵ��
		}
		
		//TODO: ���ࡣ����������
		
		
		abstract void setup();
	}
	
	
	void exec()
	{
		// �ѱ༭�����ɵĴ���ŵ�����
		
		
		//���磺
		item(new ItemGenerator() {

			@Override
			void setup() {
				name("����ʯ��");
				type(6);
				desc("һ�������Զ��ʯ��");
				dropable(false);
			}
			
			
		});
		
	}
	

	
	
	
	/**
	 * 
	 */
	public Room() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
