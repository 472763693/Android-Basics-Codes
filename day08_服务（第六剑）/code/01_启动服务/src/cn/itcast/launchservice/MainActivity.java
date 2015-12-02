package cn.itcast.launchservice;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    private MyConnection conn;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        conn = new MyConnection();
    }

    public void start(View v){
    	Intent intent = new Intent(this, MyService.class);
    	startService(intent);
    }
    public void stop(View v){
    	Intent intent = new Intent(this, MyService.class);
    	stopService(intent);
    }
    
    public void bind(View v){
    	Intent intent = new Intent(this, MyService.class);
    	//�󶨷���,��ʵҲ�ǽ�������
    	bindService(intent, conn, BIND_AUTO_CREATE);
    }
    
    public void unbind(View v){
    	//������
    	unbindService(conn);
    }
    
    class MyConnection implements ServiceConnection{

    	//���������ӱ�����ʱ����
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
		}

		//��ʧȥ��������ʱ����
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
