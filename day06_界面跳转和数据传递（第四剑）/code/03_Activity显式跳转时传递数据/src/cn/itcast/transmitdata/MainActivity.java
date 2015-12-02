package cn.itcast.transmitdata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){
    	EditText et_maleName = (EditText) findViewById(R.id.et_malename);
    	EditText et_femaleName = (EditText) findViewById(R.id.et_femalename);
    	
    	String maleName = et_maleName.getText().toString();
    	String femaleName = et_femaleName.getText().toString();
    	
    	Intent intent = new Intent(this, SecondActivity.class);
    	
    	//�����ݷ�װ����ͼ������
    	//���Է�װ�������ͣ��˴������String��bundle����ʵ�������л��ӿڵĶ���
//    	intent.putExtra("maleName", maleName);
//    	intent.putExtra("femaleName", femaleName);
    	
    	//bundle��Android��������װ���ݵ�һ��api
    	//bundle�ܷ�װ������������intentһ��
    	Bundle bundle = new Bundle();
    	bundle.putString("maleName", maleName);
    	bundle.putString("femaleName", femaleName);
    	
    	//��bundle������ͼ��
    	intent.putExtras(bundle);
    	startActivity(intent);
    }
    
}
