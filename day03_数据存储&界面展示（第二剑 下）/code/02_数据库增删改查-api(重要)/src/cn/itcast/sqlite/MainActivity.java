package cn.itcast.sqlite;

import android.R.id;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
		// db.execSQL("insert into stu (name,num) values (?,?)", new Object[] {
		// "linqingxia", 28 });

		ContentValues values = new ContentValues();
		values.put("name", "������");
		values.put("num", "10086");
		/*
		 * table :���� nullColumnHack:Ĭ�ϻ����һ��NULL��һ��д��null������ values
		 * ��ContentValues����map����
		 */
		long res = db.insert("stu", null, values);
		if (res != -1) {
			Toast.makeText(this, "����ɹ� ��" + res, 0).show();
		} else {
			Toast.makeText(this, "����ʧ�� ��" + res, 0).show();
		}
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
		// db.execSQL("delete from stu");
		/*
		 * table ������ whereClause��where���� whereArgs����ѯ����
		 */
		int res = db.delete("stu", null, null);
		if (res > 0) {
			Toast.makeText(this, "succ:" + res, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "err", Toast.LENGTH_SHORT).show();
		}

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
		// db.execSQL("update stu set name=?", new Object[] { "yadan" });
		/*
		 * table :���� values ��ContentValues����map���� whereClause��where����
		 * whereArgs����ѯ����
		 */
		ContentValues values = new ContentValues();
		values.put("name", "lisi");

		int res = db.update("stu", values, null, null);
		if (res > 0) {
			Toast.makeText(this, "succ:" + res, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "err", Toast.LENGTH_SHORT).show();
		}
		// ��Ҫ���ͷ���Դ
		db.close();
	}

	/**
	 * ��ѯ���ݿ�������
	 * 
	 * @param v
	 */
	public void query(View v) {
		// 1. ���ڴ��д���һ�����ݿ������Ķ���
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. ���ֻ����������ݿ��ļ�
		SQLiteDatabase db = helper.getReadableDatabase();

		// Cursor cursor = db.rawQuery("select * from stu", null);
		/*
		 * table :���� columns ��Ҫ��ѯ���� selection����ѯ���� selectionArgs����ѯ���� groupBy
		 * ������ having ������ orderBy ������ limit ����������
		 */
		Cursor cursor = db.query("stu", new String[] { "num", "name", "_id" },
				null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(2);
			String name = cursor.getString(1);
			String num = cursor.getString(0);

			System.out.println("======");
			System.out.println("id:" + id + "  name:" + name + " num:" + num);
		}
		// ��Ҫ���ͷ�
		cursor.close();
		// ��Ҫ���ͷ���Դ
		db.close();
	}
}
