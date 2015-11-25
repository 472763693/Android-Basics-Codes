package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 2. ��Activity���ҵ�ListView
		ListView lv = (ListView) findViewById(R.id.lv);

		// 3. ��������������
		lv.setAdapter(new MyAdapter());
	}

	/**
	 * 4. ���ڲ���ʵ������������
	 * 
	 *  C:������
	 *  
	 */
	class MyAdapter extends BaseAdapter {

		// ����ϵͳ��ʾ���ٸ���Ŀ
		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		// Androidϵͳ����getView����
		//����ģ��  M
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = null;
//			tv = new TextView(MainActivity.this);
			
			if (convertView == null) {
				tv = new TextView(MainActivity.this);
				System.out.println("convertView ���������Ķ���:" + convertView);
			}else {
				System.out.println("convertView ���û����ֻ����ĵ���Ŀ:" + convertView);
				tv=(TextView) convertView;
			}

			System.out.println("getView()" + position);
			tv.setText("���ǣ�" + position);
			tv.setTextSize(30);
			tv.setTextColor(Color.RED);

			return tv;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

	}
}
