/**
 * ��׿�׽�Ӣ��̳������ <p>
 * �ļ�����AccelerometerHandler.java <p>
 * ����ʱ�䣺2013-6-29 ����10:47:44 <p>
 * ������Ŀ��GmudTest <p>
 * @author 12548 <p>
 */
package lostland.gumd.platinum12548.blgframework.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * ������AccelerometerHandler <p>
 * ˵����
 * @author 12548
 */
public class AccelerometerHandler implements SensorEventListener {

	float accelX;
	float accelY;
	float accelZ;
	
	public AccelerometerHandler(Context context)
	{
		SensorManager manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0)
		{
			Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
		}
	}
	
	
	/* ���� Javadoc��
	 * @see android.hardware.SensorEventListener#onAccuracyChanged(android.hardware.Sensor, int)
	 */
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// nothing to do here~
	}

	/* ���� Javadoc��
	 * @see android.hardware.SensorEventListener#onSensorChanged(android.hardware.SensorEvent)
	 */
	@Override
	public void onSensorChanged(SensorEvent event) {
		accelX = event.values[0];
		accelY = event.values[1];
		accelZ = event.values[2];
	}


	/**
	 * @return accelX
	 */
	public float getAccelX() {
		return accelX;
	}


	/**
	 * @return accelY
	 */
	public float getAccelY() {
		return accelY;
	}


	/**
	 * @return accelZ
	 */
	public float getAccelZ() {
		return accelZ;
	}


}
