package cn.itcast.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShengZF extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String order = getResultData();
		System.out.println("ʡ�����յ��ļ���" + order);
		//����㲥�����޸�����
		setResultData("ÿ�˷�80�����");

	}

}
