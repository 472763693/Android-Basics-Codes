package cn.itcast.sendcustombroadcast;

import android.os.Bundle;
import android.app.Activity;
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
    	//1.������ͼ����
    	Intent intent = new Intent();
    	//2.������ͼ��action
    	intent.setAction("a.b.c");
    	//3.�����Զ�������㲥
    	sendBroadcast(intent);
    	
    }
    
}
