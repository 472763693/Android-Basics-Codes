package cn.itcast.netpage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	protected static final int MSG_SUCC = 0;
	protected static final int MSG_ERR = 1;

	private TextView tvContent;

	private String path = "http://192.168.1.253:8080/netpage/page.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvContent = (TextView) findViewById(R.id.tv_content);
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SUCC:
				String text = (String) msg.obj;
				// ��ʾ�������˵�����
				tvContent.setText(text);
				break;
			case MSG_ERR:
				Toast.makeText(MainActivity.this, "���ǣ����쳣�ˣ�", 0).show();
				break;

			default:
				break;
			}
		};
	};

	public void look(View v) {
		// �����߳����ַ�������
		new Thread() {
			public void run() {
				try {
					// 1. ��ʼ��URL
					URL url = new URL(path);
					// 2. ͨ��Url��http����
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					// 3. ���������������ʽ
					conn.setRequestMethod("GET");
					conn.setConnectTimeout(3000);
					conn.setReadTimeout(3000);
					// 4. �õ���Ӧ��
					int code = conn.getResponseCode();
					if (code == 200) {
						// 5. ��ȡ���������ص�������
						InputStream is = conn.getInputStream();
						String text = StreamUtils.parserStream2String(is);

						// 1> �����߳��з�����Ϣ
						Message msg = Message.obtain();
						msg.obj = text;
						msg.what = MSG_SUCC;
						mHandler.sendMessage(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// 1> �����߳��з�����Ϣ
					Message msg = Message.obtain();
					msg.what = MSG_ERR;
					mHandler.sendMessage(msg);
				}
			};
		}.start();
	}

}
