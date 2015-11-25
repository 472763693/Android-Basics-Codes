package cn.itcast.qq;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etPath;
	private ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etPath = (EditText) findViewById(R.id.et_path);
		pb = (ProgressBar) findViewById(R.id.pb);
	}

	/**
	 * �����ť
	 * 
	 * @param view
	 */
	public void upload(View view) {
		String path = etPath.getText().toString().trim();
		if (TextUtils.isEmpty(path)) {
			Toast.makeText(this, "�������ļ���λ��", 0).show();
			return;
		}

		String urlPath = "http://192.168.1.253:8080/web/UploadServlet";
		// 1. ��ʼ���ͻ���
		AsyncHttpClient client = new AsyncHttpClient();
		// �ϴ����ļ�
		File file = new File(path);
		if (file.exists()) {
			RequestParams params = new RequestParams();
			try {
				params.put("file", file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 2. post�ύ�ļ�
			client.post(urlPath, params, new AsyncHttpResponseHandler() {
				// �ϴ��ļ��ɹ�
				@Override
				public void onSuccess(int statusCode, Header[] headers,
						byte[] responseBody) {
					Toast.makeText(MainActivity.this, new String(responseBody),
							0).show();
				}

				/**
				 * �ϴ��Ľ���
				 */
				@Override
				public void onProgress(int bytesWritten, int totalSize) {
					super.onProgress(bytesWritten, totalSize);
					// �����ܽ���
					pb.setMax(totalSize);
					// �ϴ��Ľ���
					pb.setProgress(bytesWritten);
				}

				// �ϴ��ļ�ʧ��
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					Toast.makeText(MainActivity.this, new String(responseBody),
							0).show();
				}
			});

		}
	}
}
