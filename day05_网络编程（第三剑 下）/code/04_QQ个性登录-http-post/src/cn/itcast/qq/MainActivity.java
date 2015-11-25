package cn.itcast.qq;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

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

		// �����߳��з�������
		new Thread() {
			public void run() {
				requestNet();
			}
		}.start();
	}

	/**
	 * �ύQQ�˺ź����뵽������
	 */
	private void requestNet() {
		try {
			// 1>��Ҫ�� �����Url��һ��
			String path = "http://192.168.1.253:8080/web/LoginServlet";

			// 1. �������
			HttpClient client = new DefaultHttpClient();
			// 2. ����Url��ַ
			HttpPost url = new HttpPost(path);
			//�ύ���������˵�����
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			BasicNameValuePair p1 = new BasicNameValuePair("qq", qq);
			parameters.add(p1);
			parameters.add(new BasicNameValuePair("pwd", pwd));
			//����form�������URl
			HttpEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
			url.setEntity(entity);
			// 3. �ûس�
			HttpResponse response = client.execute(url);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				// 5. �õ��ӷ������˷��ص�������
				InputStream is = response.getEntity().getContent();
				// �ѷ������˷��ص�������ת���ַ���
				String text = StreamUtils.parserStream2String(is);
				showToastInThread(text);
			} else {
				showToastInThread("code:" + code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			showToastInThread("��磬�쳣��!!!");
		}
	}

	/**
	 * ���߳�������Ϣ���Ƶ���˾
	 * 
	 * @param text
	 */
	private void showToastInThread(final String text) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MainActivity.this, text, 0).show();
			}
		});
	}

}
