package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
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
		ListView lv = (ListView) this.findViewById(R.id.lv);
		TextView tvItem = (TextView) this.findViewById(R.id.tv_item);
		tvItem.setText("����Activity���ص�textview");

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
			if (convertView == null) {
				//���ò����������listview���һ������
				convertView = View.inflate(MainActivity.this, R.layout.adapter_list_item, null);
				
//				LayoutInflater intInflater = LayoutInflater.from(MainActivity.this);
//				convertView = intInflater.inflate(R.layout.adapter_list_item, null);
				
//				LayoutInflater  inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//				convertView= inflater.inflate(R.layout.adapter_list_item, null);
				
				System.out.println("convertView ���������Ķ���:" + convertView);
			}else {
				System.out.println("convertView ���û����ֻ����ĵ���Ŀ:" + convertView);
			}
			System.out.println("getView()" + position);
			TextView tvItem = (TextView) convertView.findViewById(R.id.tv_item);
			tvItem.setText("����Activity���ص�ListView�����adapter_list_item��textview");
			return convertView;
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
