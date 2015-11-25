package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] objects = new String[] { "������", "����", "�������", "������" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) this.findViewById(R.id.tv_list_item);
		tv.setText("����ArrayAdapter");
		// 2. ��Activity���ҵ�ListView
		ListView lv = (ListView) this.findViewById(R.id.lv);
		// 3. ��������������

		/*
		 * context ��������
		 *  resource ��listview��item�����ļ�
		 * textViewResourceId:��ʾ�ı���Textview��ID 
		 * objects ����ʾ������
		 */
		lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,
				R.layout.adapter_list_item, R.id.tv_list_item, objects));

	}

}
