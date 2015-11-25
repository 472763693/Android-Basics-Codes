package cn.itcast.sms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etNum;
	private EditText etText;
	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//���ز����ļ�
		setContentView(R.layout.activity_main);
		//�ҵ����ĵĿؼ�
		etNum = (EditText) findViewById(R.id.et_num);
		etText = (EditText) findViewById(R.id.et_text);
		btn = (Button) findViewById(R.id.btn);
		//ע�����
		btn.setOnClickListener(new MyBtnOnClickListener());
	}

	/**
	 * MainActivity���ڲ���
	 */
	class MyBtnOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			System.out.println("��ť���ҵ���ˣ�");
			
			String num = etNum.getText().toString();
			String text = etText.getText().toString().trim();
			//�ж��û�������ֻ��Ż��߶����Ƿ�Ϊ��
			if (TextUtils.isEmpty(num) || TextUtils.isEmpty(text)) {
				//  MainActivity.this �� MainActivity�Ķ���
				
//				Toast.makeText(MainActivity.this, "�ֻ�������߶������ݲ���Ϊ�գ���������", Toast.LENGTH_SHORT).show();
				Toast.makeText(MainActivity.this, "�ֻ�������߶������ݲ���Ϊ�գ���������", 0).show();
				return;
			}
			//���Ź�����
			SmsManager sm = SmsManager.getDefault();
			/*
			 * destinationAddress:���ܶ��ŵĵ绰����
			 * scAddress		  ��null
			 * text				 :���ŵ�����
			 * sentIntent		  �����ŷ��ͳɹ�����
			 * deliveryIntent	  ���Է����ܳɹ�
			 */
			sm.sendTextMessage(num, null, text, null, null);
			
			
		}

		
	}
	
}
