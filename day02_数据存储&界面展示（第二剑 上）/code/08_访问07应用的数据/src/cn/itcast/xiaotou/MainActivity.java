package cn.itcast.xiaotou;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		read07YYData();
	}

	/**
	 * ��07Ӧ����д����
	 * 
	 * @param v
	 */
	public void nama(View v) {
		try {
//			File file = new File("/data/data/cn.itcast.mode/files/writeable.txt");
//			File file = new File("/data/data/cn.itcast.mode/files/readable.txt");
//			File file = new File("/data/data/cn.itcast.mode/files/private.txt");
			File file = new File("/data/data/cn.itcast.mode/files/all");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write("�������ţ� �Ҹ���  -8Ԫ".getBytes());

			fos.close();
			Toast.makeText(this, "д�����ݳɹ���", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "д��07Ӧ�õ�����ʧ�ܣ�", 0).show();
		}
	}

	/**
	 * ��ȡ07Ӧ�õ�����
	 */
	public void read07YYData() {
		try {
			// File file = new
			// File("/data/data/cn.itcast.mode/files/private.txt");
			// File file = new File("/data/data/cn.itcast.mode/files/all");
			// File file = new
			// File("/data/data/cn.itcast.mode/files/readable.txt");
			File file = new File(
					"/data/data/cn.itcast.mode/files/writeable.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String text = br.readLine();
			br.close();
			Toast.makeText(this, text, 0).show();

		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "��ȡ07Ӧ�õ�����ʧ�ܣ�", 0).show();
		}
	}
}
