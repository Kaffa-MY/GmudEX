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
			
		}
		
		//������Ʒ�����ͣ�װ��λ�ã�
		void subtype(int id)
		{
			
		}
		
		//�Ƿ�ɵ���
		void dropable(boolean b)
		{
			
		}
		
		
		
	}
	
	
	public abstract class EquipEffect {
		
	}
	
	public abstract class Buff {
		
	}
	
	public abstract class Trigger {
		
	}
	
	
	
	/**
	 * 
	 */
	public Room() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
