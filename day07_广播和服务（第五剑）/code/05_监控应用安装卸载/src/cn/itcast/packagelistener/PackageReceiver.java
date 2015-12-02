package cn.itcast.packagelistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class PackageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//�жϽ��յ���������㲥
		String action = intent.getAction();
		//��ȡӦ�õİ���
		Uri uri = intent.getData();
		if(Intent.ACTION_PACKAGE_ADDED.equals(action)){
			Toast.makeText(context, uri.toString() + "��װ��", 0).show();
		}
		else if(Intent.ACTION_PACKAGE_REPLACED.equals(action)){
			Toast.makeText(context, uri.toString() + "������", 0).show();
		}
		else if(Intent.ACTION_PACKAGE_REMOVED.equals(action)){
			Toast.makeText(context, uri.toString() + "ж����", 0).show();
		}

	}

}
