/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����Direction.java <p>
 * ����ʱ�䣺2013-5-27 ����4:09:36 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

/**
 * ������Direction <p>
 * ˵����
 * @author 12548
 */
public enum Direction {
	LEFT,
	RIGHT,
	UP,
	DOWN;
	
	public int maincharTileY()
	{
		switch(this)
		{
		case LEFT:
			return 1;
		case RIGHT:
			return 2;
		case DOWN:
			return 0;
		case UP:
			return 3;
		}
		return 0;
	}
	
	public int dx()
	{
		switch(this)
		{
		case UP:
		case DOWN:
			return 0;
		case LEFT:
			return -1;
		case RIGHT:
			return 1;
		}
		return 0;
	}
	
	public int dy()
	{
		switch(this)
		{
		case DOWN:
			return 1;
		case LEFT:
		case RIGHT:
			return 0;
		case UP:
			return -1;
		}
		return 0;
	}
	
	public Direction inverse()
	{
		switch(this)
		{
		case DOWN:
			return UP;
		case LEFT:
			return RIGHT;
		case RIGHT:
			return LEFT;
		case UP:
			return DOWN;
		}
		return null;
	}
	
	public static Direction getDirection(int dx,int dy)
	{
		if(Math.abs(dx)==Math.abs(dy))
			return null;
		else if(Math.abs(dx)>Math.abs(dy))
			if(dx>0)
				return RIGHT;
			else
				return LEFT;
		else
			if(dy>0)
				return DOWN;
			else
				return UP;
	}
}
