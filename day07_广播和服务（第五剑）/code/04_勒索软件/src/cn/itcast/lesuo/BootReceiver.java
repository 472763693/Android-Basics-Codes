package cn.itcast.lesuo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("��������");
		
		//������������
		Intent it = new Intent(context, MainActivity.class);
		//����һ���µ�����ջȥ�����Activity
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
	}

}
