package cn.itcast.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class XianZF extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String order = getResultData();
		System.out.println("�������յ��ļ���" + order);

	}

}
