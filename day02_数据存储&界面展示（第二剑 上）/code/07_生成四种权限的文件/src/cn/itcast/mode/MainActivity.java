package cn.itcast.mode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// �ҵ����ĵĿؼ�
		Button btnP = (Button) findViewById(R.id.btn_private);
		Button btnR = (Button) findViewById(R.id.btn_read);
		Button btnW = (Button) findViewById(R.id.btn_write);
		Button btnRW = (Button) findViewById(R.id.btn_rw);
		// ���ü���
		btnP.setOnClickListener(this);
		btnR.setOnClickListener(this);
		btnW.setOnClickListener(this);
		btnRW.setOnClickListener(this);
	}

	/**
	 * �����ť
	 */
	@Override
	public void onClick(View v) {
		// Log.i(TAG, "�ҵ���˰�ť��");
		try {
			int id = v.getId();
			FileOutputStream fos = null;

			switch (id) {
			case R.id.btn_private:// ˽��
				fos = this.openFileOutput("private.txt", MODE_PRIVATE);
				break;
			case R.id.btn_read: // ȫ�ֿɶ�
				fos = this.openFileOutput("readable.txt", MODE_WORLD_READABLE);
				break;
			case R.id.btn_write:// ȫ�ֿ�д
				fos = this
						.openFileOutput("writeable.txt", MODE_WORLD_WRITEABLE);
				break;
			case R.id.btn_rw: // ȫ�ֿɶ���д
				fos = openFileOutput("all", MODE_WORLD_READABLE
						+ MODE_WORLD_WRITEABLE);
				break;
			default:
				break;
			}
			fos.write("�������ҵ�Ǯ��".getBytes());
			fos.close();
			Toast.makeText(this, "�����ļ��ɹ�����", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "�����ļ�ʧ�ܣ���", 0).show();
		}

	}

}
