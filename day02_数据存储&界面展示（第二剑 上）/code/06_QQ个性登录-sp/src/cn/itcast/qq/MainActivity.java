package cn.itcast.qq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etQQ;
	private EditText etPwd;
	private CheckBox cbRem;

	SharedPreferences mSp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etQQ = (EditText) findViewById(R.id.et_qq);
		etPwd = (EditText) findViewById(R.id.et_pwd);
		cbRem = (CheckBox) findViewById(R.id.cb_rem);
		// 1. ��ʼ��SharedPreference
		mSp = this.getSharedPreferences("config.xml", 0);
		readData();
	}

	public void readData() {

		// �ж��ļ��Ƿ���ڣ�������ڶ�ȡ�ϴδ洢������
		String qq = mSp.getString("qq", "");
		String pwd = mSp.getString("mm", "");

		// ��������
		etQQ.setText(qq);
		etPwd.setText(pwd);
	}

	/**
	 * �����ť
	 * 
	 * @param view
	 */
	public void gxlogin(View view) {
		// System.out.println("�����ť�ˣ��洢��������");
		String qq = etQQ.getText().toString().trim();
		String pwd = etPwd.getText().toString().trim();
		if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(this, "QQ�Ż������벻��Ϊ�գ�����", 0).show();
			return;
		}

		// �û��Ƿ�ѡ����ס����
		boolean isChecked = cbRem.isChecked();
		if (isChecked) {
			// �洢����

			// 2. ��ȡ�༭��Editor
			Editor edit = mSp.edit();
			// 3. �ñ༭���洢����
			edit.putString("qq", qq);
			edit.putString("mm", pwd);
			// 4. ��Ҫ����ס�ύ����
			edit.commit();

			Toast.makeText(this, "���ݴ洢�ɹ���", 0).show();
		} else {
			System.out.println("���洢����");
		}

	}

}
