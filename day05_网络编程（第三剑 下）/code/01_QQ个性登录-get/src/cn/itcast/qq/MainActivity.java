package cn.itcast.qq;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etQQ;
	private EditText etPwd;
	private String qq;
	private String pwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etQQ = (EditText) findViewById(R.id.et_qq);
		etPwd = (EditText) findViewById(R.id.et_pwd);

	}

	/**
	 * �����ť
	 * 
	 * @param view
	 */
	public void login(View view) {
		qq = etQQ.getText().toString().trim();
		pwd = etPwd.getText().toString().trim();
		if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(this, "QQ�Ż������벻��Ϊ�գ�����", 0).show();
			return;
		}

		//�����߳��з�������
		new Thread(){
			public void run() {
				requestNet();
			}
		}.start();
	}

	/**
	 * �ύQQ�˺ź����뵽������
	 */
	private void requestNet(){
		try {
			String path = "http://192.168.1.253:8080/web/LoginServlet"
								+"?qq="+URLEncoder.encode(qq, "utf-8")
								+"&pwd="+URLEncoder.encode(pwd, "utf-8");
			// 1. ��ʼ��Url
			URL url = new URL(path);
			// 2. ͨ��Url��ȡHttp����
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. �����������������ʽ
			conn.setRequestMethod("GET");
			conn.setReadTimeout(3000);
			// 4. ��ȡ������ 200:�ɹ� 3xxx���� 4xxx�ͻ��˴��� 500����������
			int code = conn.getResponseCode();
			if (code == 200) {
				// 5. �õ��ӷ������˷��ص�������
				InputStream is = conn.getInputStream();
				//�ѷ������˷��ص�������ת���ַ���
				String text = StreamUtils.parserStream2String(is);
				showToastInThread(text);
			}else {
				showToastInThread("code:"+code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			showToastInThread("��磬�쳣��!!!");
		}
	}
	
	/**
	 * ���߳�������Ϣ���Ƶ���˾
	 * @param text
	 */
	private void showToastInThread(final String text){
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MainActivity.this, text, 0).show();	
			}
		});
	}
	
}
