package cn.itcast.logcat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String TAG="MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		System.out.println("MainActivity�����´����ˣ�onCreate�������ˣ�");
		
		Log.v(TAG, "������־   ��ʾ  ");
		Log.d(TAG, "������־   ����  ");
		Log.i(TAG, "������־   ��Ϣ  ");
		Log.w(TAG, "������־   ����  ");
		Log.e(TAG, "������־   ����  ");
	}

}
