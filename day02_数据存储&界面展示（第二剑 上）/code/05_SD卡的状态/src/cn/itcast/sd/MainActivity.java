package cn.itcast.sd;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	/**
	 * ���Sd���Ĳ��״̬
	 * @param v
	 */
	public void click(View v) {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "SD�Ѳ���", 0).show();
		} else if (state.equals(Environment.MEDIA_UNMOUNTED)) {
			Toast.makeText(this, "SD���Ƴ�", 0).show();
		}
	}
	
	/**
	 * ��ȡSD����·��
	 * @param view
	 */
	public void path(View view){
		File file = Environment.getExternalStorageDirectory();
		Toast.makeText(this, file.getAbsolutePath(), 0).show();
	}
	
	/**
	 * ��ȡSD���Ŀ��ÿռ�
	 * @param view
	 */
	public void space(View view){
		File file = Environment.getExternalStorageDirectory();
		long size = file.getFreeSpace(); //byte
		String formatFileSize = Formatter.formatFileSize(this, size);
		
		Toast.makeText(this, formatFileSize, 0).show();
	}
	
}
