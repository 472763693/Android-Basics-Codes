package com.example.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private String[] objects = new String[] { "������", "����", "������", "�������" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.lv);
		/*
		 * context :������ resource ��Listview��Ŀ�Ĳ����ļ�
		 * textViewResourceId��Listview��Ŀ�Ĳ����ļ���tv��Id objects
		 * ��ListView��ÿ����Ŀtextview��ʾ������
		 */
		// lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,
		// R.layout.adapter_list_array_item, R.id.tv_array_item, objects));

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "aaa");
		map1.put("phto", R.drawable.ic_launcher);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "aaa");
		map2.put("phto", R.drawable.ic_launcher);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "aaa");
		map3.put("phto", R.drawable.ic_launcher);

		data.add(map1);
		data.add(map2);
		data.add(map3);

		/*
		 * context �������� data ��Ҫ��ʾ������ resource ��Listview��Ŀ�Ĳ����ļ� from
		 * ��ÿ����Ŀmap�е�key to ����Ŀ�����ļ��пؼ���ID
		 */
		lv.setAdapter(new SimpleAdapter(MainActivity.this, data,
				R.layout.adapter_list_array_item,
				new String[] { "phto", "name" }, new int[] { R.id.iv,
						R.id.tv_array_item }));
	}

}
