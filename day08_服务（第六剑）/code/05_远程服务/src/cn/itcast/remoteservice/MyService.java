package cn.itcast.remoteservice;

import cn.itcast.remoteservice.PublicBusiness.Stub;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("bind");
		return new YangMishu();
	}
	
	//�м��˶���ֱ�Ӽ̳�Stub��Stub�Ѿ��̳���Binderʵ����PublicBusiness�ӿ�
	class YangMishu extends Stub{

		@Override
		public void qianXian() {
			// TODO Auto-generated method stub
			remoteBanZheng();
		}
		
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("unbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("create");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("start");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("destroy");
	}
	
	public void remoteBanZheng(){
		System.out.println("���쵼��·�ˣ�ֻ��Զ�̰�֤");
	}
}
