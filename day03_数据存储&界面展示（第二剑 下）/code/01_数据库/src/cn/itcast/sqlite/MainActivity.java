package cn.itcast.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	/**
	 * �����ݿ�ı����һ������
	 * 
	 * @param v
	 */
	public void insert(View v) {
		// 1. ���ڴ��д���һ�����ݿ������Ķ���
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. ���ֻ����������ݿ��ļ�
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("insert into stu (name,num) values (?,?)", new Object[] {
				"linqingxia", 28 });
		// ��Ҫ���ͷ���Դ
		db.close();
	}
	/**
	 * ɾ�����ݿ�������
	 */
	public void delete(View v) {
		// 1. ���ڴ��д���һ�����ݿ������Ķ���
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. ���ֻ����������ݿ��ļ�
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from stu");
		// ��Ҫ���ͷ���Դ
		db.close();
	}
	/**
	 * �޸����ݿ�������
	 */
	public void update(View v) {
		// 1. ���ڴ��д���һ�����ݿ������Ķ���
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. ���ֻ����������ݿ��ļ�
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update stu set name=?", new Object[] { "yadan" });
		// ��Ҫ���ͷ���Դ
		db.close();
	}
	/**
	 * ��ѯ���ݿ�������
	 * @param v
	 */
	public void query(View v) {
		// 1. ���ڴ��д���һ�����ݿ������Ķ���
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. ���ֻ����������ݿ��ļ�
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from stu", null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(0);
			String name = cursor.getString(1);
			String num = cursor.getString(2);
			System.out.println("======");
			System.out.println("id:" + id + "  name:" + name + " num:" + num);
		}

		// ��Ҫ���ͷ���Դ
		db.close();
	}
}
