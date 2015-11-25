package cn.itcast.qq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etQQ = (EditText) findViewById(R.id.et_qq);
		etPwd = (EditText) findViewById(R.id.et_pwd);
		cbRem = (CheckBox) findViewById(R.id.cb_rem);

		readData();
	}

	public void readData() {

		File file = new File("/mnt/sdcard/waibucunchu.txt");

		// �ж��ļ��Ƿ���ڣ�������ڶ�ȡ�ϴδ洢������
		if (file.exists()) {
			try {
				 FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String text = br.readLine();
				br.close();

				String[] content = text.split("==");
				String qq = content[0];
				String pwd = content[1];
				// �������ݵ�etQQ,etPwd
				etQQ.setText(qq);
				etPwd.setText(pwd);
				Toast.makeText(this, "ohohohoh", 0).show();
			} catch (Exception e) {
				Toast.makeText(this, "���ǣ���ȡʧ�ܣ�����", 0).show();
				e.printStackTrace();
			}
		}
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
			try {
				File file = new File("/mnt/sdcard/waibucunchu.txt");
				FileOutputStream fos = new FileOutputStream(file);
				String text = qq + "==" + pwd;
				fos.write(text.getBytes());
				fos.close();
				Toast.makeText(this, "���ݴ洢�ɹ���", 0).show();
			} catch (Exception e) {
				Toast.makeText(this, "���ݴ洢ʧ�ܣ�", 0).show();
				e.printStackTrace();
			}
		} else {
			System.out.println("���洢����");
		}

	}

}
