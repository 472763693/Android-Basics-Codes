package cn.itcast.phonecall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * ����
 * 
 */
public class MainActivity extends Activity {

	/**
	 * ����activity������ִ��
	 * 
	 * ͨ�����䴴��MainActivity���󣬵���onCreate
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ���ز����ļ�
		setContentView(R.layout.activity_main);
		// �ҵ������ļ��еİ�ť
		Button btn = (Button) findViewById(R.id.button);
		// ���õ���¼��ļ���
		// 1> �����ڲ���ķ�ʽ
		// btn.setOnClickListener(new MyListener());
		// 2> �����ڲ���
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ͼ �� �绰 �� � �� ����
				// 1. ��ʼ��һ����ͼ
				Intent intent = new Intent();
				// 2. ���ö���
				intent.setAction(Intent.ACTION_CALL);
				// 3. ��������
				// Urlͳһ��Դ��λ�� http://www.baidu.com < Uri ͳһ��Դ��ʶ��
				// chuangzhi://04/�೤
				Uri data = Uri.parse("tel://110");
				intent.setData(data);
				// 4. ������ͼ
				startActivity(intent);
			}
		});

	}

	/**
	 * OnClickListener�ӿڵ�һ��ʵ����
	 * 
	 * �ڲ���
	 */
	class MyListener implements OnClickListener {
		// �����ť����
		@Override
		public void onClick(View v) {
			System.out.println("������˰�ť");

			// ��ͼ �� �绰 �� � �� ����
			// 1. ��ʼ��һ����ͼ
			Intent intent = new Intent();
			// 2. ���ö���
			intent.setAction(Intent.ACTION_CALL);
			// 3. ��������
			// Urlͳһ��Դ��λ�� http://www.baidu.com < Uri ͳһ��Դ��ʶ�� chuangzhi://04/�೤
			Uri data = Uri.parse("tel://110");
			intent.setData(data);
			// 4. ������ͼ
			startActivity(intent);
		}

	}

}
