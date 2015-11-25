package cn.itcast.seconds;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("MainActivity�����̣߳�"
				+ Thread.currentThread().getName());

		tvMM = (TextView) findViewById(R.id.tv_mm);
	}
	// 2.�����̣߳�Activity����дһ��Handler
	private Handler mHandler = new Handler() {
		// 3.��handlmessage�������޸�UI
				@Override
				public void handleMessage(Message msg) {
					super.handleMessage(msg);
					int i = (Integer) msg.obj;
					// ��handleMessage���޸�UI
					tvMM.setText(String.valueOf(i));
				}
	};
	
	private void zixianchengzhognfangfa() {
		System.out
				.println("���������̣߳�" + Thread.currentThread().getName());

		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Message msg = new Message();
			msg.obj = i;
			mHandler.sendMessage(msg);
		}
	};
	
	private TextView tvMM;
	public void start(View v) {
		// 1.дһ�����̷߳�����Ϣ
		new Thread() {
			public void run() {
				
				zixianchengzhognfangfa();
			}
		}.start();

	}
}
