package cn.itcast.center;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v){
    	//1.������ͼ
    	Intent intent = new Intent();
    	//2.����action
    	intent.setAction("cn.itcast.fdm");
    	
    	//3.��������㲥
    	//resultReceiver:���������:����㲥�����ߣ��������н����߶����յ��㲥֮�󣬲Ž��չ㲥������һ������յ�
    	sendOrderedBroadcast(intent, null, new MyReceiver(), null, 
    			0, "ÿ�˷�100�����", null);//��������������������װ�������ݵ�
    }
    
    class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String order = getResultData();
			System.out.println("��̰���յ��ļ���" + order);
			
		}
    	
    }
    
}
