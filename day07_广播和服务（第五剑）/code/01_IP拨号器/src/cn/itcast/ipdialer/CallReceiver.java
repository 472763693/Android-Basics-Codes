package cn.itcast.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CallReceiver extends BroadcastReceiver {

	//�յ��㲥ʱ���ͻ����
	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("�յ���绰�㲥");
		//�ӹ㲥��ȡ������ĺ���
		String phone = getResultData();
		
		phone = "17951" + phone;
		
		//���޸ĺ�ĵ绰���룬����㲥��
		setResultData(phone);
		//������Ч����Ϊ��绰Ӧ�õĽ������ǵ绰�㲥�����ս�����
		//abortBroadcast();
	}

}
