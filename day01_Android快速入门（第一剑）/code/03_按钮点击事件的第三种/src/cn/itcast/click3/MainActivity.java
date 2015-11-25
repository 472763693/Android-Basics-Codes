package cn.itcast.click3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//�ҵ���ť
		Button btn1 = (Button) findViewById(R.id.btn1);
		Button btn2 = (Button) findViewById(R.id.btn2);
		Button btn3 = (Button) findViewById(R.id.btn3);
		//���ü���
		//this:��ʾ��ǰ��MainActivity�Ķ���
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
		
	}
	/**
	 * ����˰�ť
	 * @param view
	 */
	public  void click1(View view){
		System.out.println("���ǵ����ַ�ʽ");
	}
	
	//�����ť����
	@Override
	public void onClick(View v) {
		System.out.println("�磬������˰�ť������");
		int id = v.getId();
		switch (id) {
		case R.id.btn1:
			System.out.println("1111");
			break;
		case R.id.btn2:
			System.out.println("2222");
			break;
		case R.id.btn3:
			System.out.println("3333");
			break;
		default:
			break;
		}
	}

}
