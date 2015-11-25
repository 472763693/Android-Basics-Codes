package cn.itcast.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) this.findViewById(R.id.tv_list_item);
		tv.setText("����Activity�ı���!!!");
		// 2. ��Activity���ҵ�ListView
		ListView lv = (ListView) this.findViewById(R.id.lv);
		// 3. ��������������


		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "����ϼ	");
		map1.put("photo", R.drawable.ic_launcher);

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "���»�");
		map2.put("photo", R.drawable.ic_launcher);

		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "��ѧ��");
		map3.put("photo", R.drawable.ic_launcher);

		data.add(map1);
		data.add(map2);
		data.add(map3);
		
		/*
		 * context �������� 
		 * data ����䵽list��item������
		   resource ����䵽list��item�Ĳ����ļ�
		   from ��map�����key
		 * to ����ʾview��ID
		 */
		lv.setAdapter(new SimpleAdapter(MainActivity.this, data,
				R.layout.adapter_list_item, new String[]{"photo","name"}, 
				new int[]{R.id.iv,R.id.tv_list_item}));

	}

}
