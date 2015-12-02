package cn.itcast.transmitdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		//��ȡ��������Activity����ͼ����
		Intent intent = getIntent();
		
//		String maleName = intent.getStringExtra("maleName");
//		String femaleName = intent.getStringExtra("femaleName");
		
		Bundle bundle = intent.getExtras();
		String maleName = bundle.getString("maleName");
		String femaleName = bundle.getString("femaleName");
		
		String text = maleName + femaleName;
		byte[] b = text.getBytes();
		int total = -100;
		for (byte c : b) {
			total += c;
		}
		//ȡ����ֵ�����⸺����ģ101�����ֵ����100
		total = Math.abs(total) % 101;
		
		TextView tv = (TextView) findViewById(R.id.tv);
		tv.setText(maleName + "��" + femaleName + "����ԵֵΪ��" + total + ",ʵ������֮��,�����Ե������һ��");
	}
}
