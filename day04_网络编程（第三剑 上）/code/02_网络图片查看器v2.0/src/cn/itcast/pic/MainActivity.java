package cn.itcast.pic;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int MSG_CODE_ERR = 0;
	private static final int MSG_SUCC = 1;
	private static final int MSG_ERR = 2;
	private EditText etPath;
	private ImageView ivPic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etPath = (EditText) findViewById(R.id.et_path);
		ivPic = (ImageView) findViewById(R.id.iv_pink);

		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName());
	}

	public void look(View v) {
		final String path = etPath.getText().toString().trim();

		// �����߳̽����������
		new Thread() {
			public void run() {
				requestNetWork(path);
			};
		}.start();
	}

	// 2> ��Activity��дHandler��Ա����
	private Handler mHandler = new Handler() {
		// 3> ��handlmessage������Ϣ
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			int id = msg.what;
			switch (id) {
			case MSG_SUCC:// �ɹ�����ͼƬ����
				Bitmap bmp = (Bitmap) msg.obj;
				// ��ͼƬ������ʾ��iv
				ivPic.setImageBitmap(bmp);
				break;
			case MSG_ERR:// �쳣
				Toast.makeText(MainActivity.this, "���ǳ��쳣��", 0).show();
				break;
			case MSG_CODE_ERR:// �������˵ķ����벻��200
				int code = (Integer) msg.obj;
				Toast.makeText(MainActivity.this, "code:" + code, 0).show();
				break;

			default:
				break;
			}
		}
	};

	/**
	 * ���������ȡͼƬ
	 * 
	 * @param path
	 */
	private void requestNetWork(String path) {
		try {
			// 1. ��ʼ��Url
			URL url = new URL(path);
			// 2. ͨ��Url��ȡHttp����
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. �����������������ʽ
			conn.setRequestMethod("GET");// Ĭ�ϵ�����ʽ
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(3000);
			// 4. ��ȡ������ 200:�ɹ� 3xxx���� 4xxx�ͻ��˴��� 500����������
			int code = conn.getResponseCode();
			if (code == 200) {
				// 5. �õ��ӷ������˷��ص�������
				InputStream is = conn.getInputStream();

				// �ѷ��������صĶ�����������ת��ͼƬ����
				Bitmap bmp = BitmapFactory.decodeStream(is);

				// 1> �����߳��з�����Ϣ
				Message msg = new Message();
				msg.obj = bmp;
				msg.what = MSG_SUCC;
				mHandler.sendMessage(msg);
			} else {
				Message msg = new Message();
				msg.what = MSG_CODE_ERR;
				msg.obj = code;
				mHandler.sendMessage(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.what = MSG_ERR;
			mHandler.sendMessage(msg);
		}
	}
}
