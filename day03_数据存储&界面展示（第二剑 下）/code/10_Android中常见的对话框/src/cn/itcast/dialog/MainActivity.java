package cn.itcast.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void qdqx(View v) {
		// �����Ի������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// ���öԻ���ı���
		builder.setTitle("����9��");
		builder.setMessage("�����˹��������߰ɣ�");

		// ȡ����ť
		builder.setNegativeButton("�Ҳ�ѧ-ȡ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "���������ߣ�����Ը���", 0).show();
			}
		});

		// ȷ����ť
		builder.setPositiveButton("ҪҪҪ-ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "�������춼��������9������", 0).show();
			}
		});

		// ��Ҫ
		builder.show();

	}

	String sex;

	public void single(View v) {
		// �����Ի������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// ���öԻ���ı���
		builder.setTitle("��ѡ�Ի���");

		final String[] items = new String[] { "��", "Ů", "��", "δ֪" };
		builder.setSingleChoiceItems(items, 3, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				sex = items[which];
				dialog.dismiss();
				Toast.makeText(MainActivity.this, items[which], 0).show();
			}
		});

		builder.show();
	}

	public void mutil(View view) {
		// �����Ի������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// ���öԻ���ı���
		builder.setTitle("��ѡ�Ի���");

		final String[] items = new String[] { "����", "Android", "����", "��", "���¾Ž�" };
		final boolean[] checkedItems = new boolean[] { true, true, false,
				false, true };
		builder.setMultiChoiceItems(items, checkedItems,
				new OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						checkedItems[which] = isChecked;
						Toast.makeText(MainActivity.this,
								"�Ƿ�ѡ��" + checkedItems[which], 0).show();
					}
				});

		builder.setPositiveButton(

			"��ϲ��",
			new OnClickListener() {
	
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < checkedItems.length; i++) {
						if (checkedItems[i]) {
							
							sb.append(" "+items[i]);
						}
					}
					
					Toast.makeText(MainActivity.this, sb.toString(), 0).show();
				}
			}

		);
		builder.show();
	}
}
