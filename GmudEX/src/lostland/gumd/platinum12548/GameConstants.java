/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����GameConstants.java <p>
 * ����ʱ�䣺2013-5-20 ����11:42:15 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

/**
 * ������GameConstants <p>
 * ˵����
 * @author 12548
 */
public interface GameConstants {
	int FBWIDTH  = MapScreen.C_ROWS * 32;
	int FBHEIGHT = MapScreen.C_COLUMNS * 32;
	
	int BG_COLOR = 0x90B057;
	
	
	
	/**
	 * �������������ʡ�
	 */
	double BASE_BASIC_HIT_RATE=0.85;
	/**
	 * �������ݻرܱ���������
	 */
	double INNATE_AGI_EVADE_RATE=0.02;
	/**
	 * �������������޳���
	 */
	double BASIC_HIT_RATE_LOWERLIMIT=0.6;
	/**
	 * �������ݼӳɱ�������
	 */
	double HIT_RATE_AGI_ADDITION_RATE=0.008;
	/**
	 * �ر����ݼӳɱ�������
	 */
	double EVADE_RATE_AGI_ADDITION_RATE=0.012;
	/**
	 * ������ѧ����ѹ�Ʊ�����С����
	 */
	double BASIC_ART_HIT_RATE_SUPPRESS_REDUCE_RATE=2.0;
	/**
	 * ��������ѹ�Ʊ�����С����
	 */
	double ADDITIONAL_HIT_RATE_SUPPRESS_REDUCE_RATE=1.5;
	/**
	 * ��������ѹ���γɳ���
	 */
	double BASIC_STR_SUPPRESS_FORM=20.0;
	/**
	 * ������ѹ�˺�ϵ������
	 */
	double BASIC_SUPPRESS_DAMAGE_QUO=2.0;
	/**
	 * �����������ʳ���
	 */
	double BASE_BASIC_BLOCK_RATE=0.09;
	/**
	 * �������Ը�ѹ�Ʊ�����С����
	 */
	double BASIC_ABILITY_BLOCK_RATE_SUPPRESS_REDUCE_RATE=2.25;
	/**
	 * ������ѧ��ѹ�Ʊ�����С����
	 */
	double BASIC_ART_BLOCK_RATE_SUPPRESS_REDUCE_RATE=1.75;
	/**
	 * ���Ǽ������޳���
	 */
	double BONE_DAMAGE_REDUCE_UPPERLIMIT=0.80;
	/**
	 * ������Ǽ�������ϵ������
	 */
	double INNATE_BONE_DAMAGE_REDUCE_RATE_UPPERLIMIT=0.80;
	/**
	 * �������Ǽ���ϵ������
	 */
	double BASIC_BONE_DAMAGE_REDUCE_QUO=0.01;
	/**
	 * ����������Ǽ���ϵ������
	 */
	double BASIC_INNATE_BONE_DAMAGE_REDUCE_QUO=1.0;
	/**
	 * ���������˺�ϵ������
	 */
	double BASIC_STR_DAMAGE_QUO=1.10;
	/**
	 * �������������˺�ϵ������
	 */
	double BASIC_INNATE_STR_DAMAGE_QUO=1.10;
	/**
	 * �����ж�ϵ������
	 */
	double DAMAGE_SEVERITY_JUDGEMENT_QUO=1.75;
	
	double ADVANCED_QINGGONG_HIT_QUE=2.0;
	
	double ADVANCED_QINGGONG_EVADE_QUE=3.0;
	
	String faction_text[] = new String[]{
		"[����СϺ]","[������]","[̫����]","[������]","[���ع�]","[������]","[ѩɽ��]","[��ң��]"
	};

	int master_faction[][] = new int[][]{{},{38,43,47},{96,97,101},{56,57,66,58},{87,90,94},{73,80},{110,118,122}};
	
	float TICK_TIME = 0.05f;


}
