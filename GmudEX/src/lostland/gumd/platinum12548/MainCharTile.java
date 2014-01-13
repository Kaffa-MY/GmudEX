/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����MainCharTile.java <p>
 * ����ʱ�䣺2013-5-20 ����4:54:37 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548;

import lostland.gumd.platinum12548.blgframework.impl.BLGPixmap;

/**
 * ������MainCharTile <p>
 * ˵����
 * @author 12548
 */
public class MainCharTile extends Tileset {

	final static int MAINCHAR_WIDTH=32;
	final static int MAINCHAR_HEIGHT=48;
	
	final static int WALK_STEPS=4;
	
	GmudGame game;
	public int currentStep=0;
	public static int X,Y;
	BLGPixmap pixmap2;
	
	public static Direction currentDirection;
	
	/**
	 * ��Ҫʹ��������캯����
	 * @param pixmap
	 * @param tileWidth
	 * @param tileHeight
	 */
	public MainCharTile(BLGPixmap pixmap, int tileWidth, int tileHeight) {
		super(pixmap, tileWidth, tileHeight);
	}

	public MainCharTile(GmudGame game)
	{
		super((BLGPixmap) Assets.maincharTile,MAINCHAR_WIDTH,MAINCHAR_HEIGHT);
		this.game=game;
		pixmap2 = (BLGPixmap) Assets.girl;
	}
	
	
	
	/**
	 * @param direction ���ǳ���
	 * @param step ���ǲ�������4ȡ���0��2Ϊ��ֹ��1Ϊ���ҽţ�3Ϊ����š�
	 * @param x ͨ��Ϊ1��2��3���֡�
	 * @param y ͨ��Ϊ1.
	 */
	public void draw(Direction direction,int step,int x,int y)
	{
		BLGPixmap pixmap = this.pixmap;
		if(GmudWorld.mc.sex > 0) pixmap = pixmap2;
		
		
		game.getGraphics().drawPixmap(pixmap, x*MAINCHAR_WIDTH, (y+1)*MAINCHAR_WIDTH-MAINCHAR_HEIGHT
				, (step%4)*tileWidth, direction.maincharTileY()*tileHeight, tileWidth, tileHeight);
		currentStep=step%4;
		currentDirection= direction;
		X=x;
		Y=y;
	}
	
	/**
	 * ����ԭ��̤������һ֡��
	 * @param direction ����
	 * @param x
	 * @param y
	 */
	public void drawOriWalking(Direction direction,int x,int y)
	{
		BLGPixmap pixmap = this.pixmap;
		if(GmudWorld.mc.sex > 0) pixmap = pixmap2;
		
		game.getGraphics().drawPixmap(pixmap, x*MAINCHAR_WIDTH, (y+1)*MAINCHAR_WIDTH-MAINCHAR_HEIGHT
				, currentStep*tileWidth, direction.maincharTileY()*tileHeight, tileWidth, tileHeight);
		currentDirection= direction;
	}
	
	/**
	 * ������ͼ�������ƶ�����һ֡��
	 * @param direction ����ֻ��ΪLEFT��RIGHT��
	 * @param step �߳��ĵ�N-1�����ߵ���һ�����ӹ���WALK_STEPS����
	 * @param x ������x���꣬1��2��3��
	 */
	public void drawInnerWalking(Direction direction,int step, int x,int y)
	{
		BLGPixmap pixmap = this.pixmap;
		if(GmudWorld.mc.sex > 0) pixmap = pixmap2;
		
		int dx=(direction.dx())*MAINCHAR_WIDTH*(step+1)/WALK_STEPS;
		int dy=direction.dy()*MAINCHAR_WIDTH*(step+1)/WALK_STEPS;
		game.getGraphics().drawPixmap(pixmap, x*MAINCHAR_WIDTH+dx, (y+1)*MAINCHAR_WIDTH-MAINCHAR_HEIGHT+dy
				, currentStep*tileWidth, direction.maincharTileY()*tileHeight, tileWidth, tileHeight);
		currentDirection= direction;
	}
	
	public static int absX()
	{
		return GmudWorld.ms.X+X;
	}
	
	public static int absY()
	{
		return GmudWorld.ms.Y+Y;
	}
	
	public static int frontX()
	{
		return X+ currentDirection.dx();
	}
	
	public static int frontY()
	{
		return Y+ currentDirection.dy();
	}
	
	public static int frontAbsX()
	{
		return absX()+ currentDirection.dx();
	}
	
	public static int frontAbsY()
	{
		return absY()+ currentDirection.dy();
	}
}
