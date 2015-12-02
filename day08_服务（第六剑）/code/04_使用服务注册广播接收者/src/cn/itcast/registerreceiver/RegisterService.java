package cn.itcast.registerreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class RegisterService extends Service {

	private ScreenOffOnReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	//ע��㲥������
	@Override
	public void onCreate() {
		super.onCreate();
		receiver = new ScreenOffOnReceiver();
		//������ͼ����������
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		
		//ע��
		registerReceiver(receiver, filter);
		
	}
	
	//���ע��
	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}
}
