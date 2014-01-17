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


	private ItemGenerator item()
	{
		return new ItemGenerator();
	}

	final int ITMTYPE_FOOD = 0;
	final int ITMTYPE_MEDIC = 1;
	final int ITMTYPE_WEAPON = 2;
	final int ITMTYPE_EQUIPMENT = 3;
	final int ITMTYPE_OTHER = 4;

	private class ItemGenerator {

		public ItemGenerator() {
			// TODO ��Ʒ����Ԥ����
		}

		//������Ʒ��
		ItemGenerator name(String s)
		{
			//TODO: δʵ��
			return this;
		}

		//������Ʒ����
		ItemGenerator type(int id)
		{
			//TODO: δʵ��
			return this;
		}

		//������Ʒ�����ͣ�װ��λ�ã�
		ItemGenerator subtype(int id)
		{
			//TODO: δʵ��
			return this;
		}

		//�Ƿ�ɶ���
		ItemGenerator dropable(boolean b)
		{
			//TODO: δʵ��
			return this;
		}

		//������Ʒ����
		ItemGenerator desc(String s)
		{
			//TODO: δʵ��
			return this;
		}

		//������Ʒ�ۼ�
		ItemGenerator cost(int value)
		{
			//TODO: δʵ��
			return this;
		}

		//װ��Ч��
		ItemGenerator equip_effect(EffectGenerator e)
		{
			//TODO: δʵ��
			return this;
		}

		//ʹ��Ч��
		ItemGenerator use_effect(EffectGenerator e)
		{
			//TODO: δʵ��
			return this;
		}

		//Я��Ч��
		ItemGenerator carry_effect(EffectGenerator e)
		{
			//TODO: δʵ��
			return this;
		}

		//TODO: ���ࡣ����������

	}


	private EffectGenerator effect(int effectid)
	{
		return new EffectGenerator(effectid);
	}

	final int EFFECT_RESERVED = 0;                                        //��������Ч��
	final int EFFECT_ADDTO_ATTR = 1;                                  //��������
	final int EFFECT_ADDTO_ATTR_BOUNS = 2;                   //������ʱ���ԣ����������Ѷ���ս����������ʧ��
	final int EFFECT_RECOVER_SP = 3;                                  //�ָ�����
	final int EFFECT_CURE = 4;                                                //��������
	final int EFFECT_RECOVER_FP = 5;                                  //�ָ�����
	final int EFFECT_ADDTO_XATTR = 6;                               //�����������ԣ�ֻ��������Ч�����ԣ�
	final int EFFECT_SEE_SOMETHING_CLEAR = 7;              //�ܿ����������䣨�ϻ�����
	final int EFFECT_FISHING = 8;                                            //�����������㣨��ͣ�
	final int EFFECT_HOLD_FISH = 9;                                     //��������װ�㣨��¨��


	//Ч������Ŀ��
	enum EffectTarget{ 
		SELF,
		ENEMY
	}

	final int ATTR_STR = 0;
	final int ATTR_AGI = 1;
	final int ATTR_WXG = 2;
	final int ATTR_BON = 3;
	final int ATTR_ATK = 4;
	final int ATTR_DEF = 5;
	final int ATTR_HIT = 6;
	final int ATTR_EVD = 7;
	final int ATTR_EXP = 8;
	final int ATTR_ADS = 9;
	final int ATTR_MAXHP = 10;
	final int ATTR_MAXFP = 11;

	final int XATTR_FACE = 0;
	final int XATTR_POT = 1;
	final int XATTR_FOOD = 2;
	final int XATTR_WATER = 3;


	private class EffectGenerator {
		EffectGenerator(int effectid)
		{

		}

		//Ч��ֵ
		EffectGenerator value(int value)
		{
			//TODO: δʵ��
			return this;
		}

		//Ч������ֵ
		EffectGenerator value(float rate)
		{
			//TODO: δʵ��
			return this;
		}

		//Ч����������
		EffectGenerator attr(int attr)
		{
			//TODO: δʵ��
			return this;
		}

		// Ч������Ŀ��
		EffectGenerator target(EffectTarget value)
		{
			//TODO: δʵ��
			return this;
		}


	}


	void exec()
	{
		// �ѱ༭�����ɵĴ���ŵ�����


		//example:
		item()
		.name("����ʯ��")
		.type(ITMTYPE_OTHER)
		.desc("һ�������Զ��ʯ��")
		.dropable(false);

		//���ӣ�����֮������10�㹥����
		item()
		.name("����֮��")
		.type(ITMTYPE_WEAPON)
		.desc("����ʹ�õı���")
		.subtype(6)
		.dropable(true) //�ɶ���������ʡ�ԣ�Ĭ�Ͽɶ���
		.cost(100000)
		.equip_effect(
				effect(EFFECT_ADDTO_ATTR)
				.attr(ATTR_ATK)
				.value(10)
				.target(EffectTarget.SELF) //Ч������Ŀ������Ҳ����ʡ�ԣ�Ĭ��ΪSELF
				);

		//������ָ�50%Ѫ��
		item()
		.name("������")
		.type(ITMTYPE_MEDIC)
		.desc("�������ҩ��")
		.cost(3000)
		.use_effect(
				effect(EFFECT_CURE)
				.value(0.5f)
				);

		//������ҩ������֮�����ý���10Ѫ��������5����ò
		item()
		.name("������ҩ")
		.type(ITMTYPE_MEDIC)
		.desc("�������Ƶ�ҩ��")
		.cost(1000000000)
		.use_effect(
				effect(EFFECT_ADDTO_ATTR)
				.attr(ATTR_MAXHP)
				.value(-10)
				)
		.use_effect(
				effect(EFFECT_ADDTO_XATTR)
				.attr(XATTR_FACE)
				.value(5)
				);

		
		//�ϻ���
		item()
		.name("�ϻ���")
		.type(ITMTYPE_EQUIPMENT)
		.subtype(0)
		.desc("һ���ϻ���,����ȥ���Կ�,һЩ������������")
		.cost(100)
		.equip_effect(effect(EFFECT_SEE_SOMETHING_CLEAR));
		
		
		//��¨
		item()
		.name("��¨")
		.type(ITMTYPE_OTHER)
		.desc("һ���ݱ����¨,ר������װ���")
		.cost(100)
		.carry_effect(effect(EFFECT_HOLD_FISH));

	}





	/**
	 * 
	 */
	public Room() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
