package cn.itcast.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 1. ����һ����̳�SQLiteOpenHelper
 * 
 */
public class MyDbOpenHelper extends SQLiteOpenHelper {
	private static final String TAG="MyDbOpenHelper";

	/**
	 * ���ݿ������Ĺ��췽��
	 * @param context ������
	 * @param name	    ���ݿ������
	 * @param factory null
	 * @param version ���ݿ�İ汾��  >=1
	 */
	public MyDbOpenHelper(Context context) {
		super(context, "student.db", null,4);
	}
	
	/**
	 * ��һ�δ������ݿ�ʱִ�У��ʺϴ������ݿ�ı�
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(TAG,"���ݿ��һ�δ����ˣ�onCreate��������ִ���ˣ�����");
		
		db.execSQL("create table stu(_id integer primary key autoincrement, name varchar(20),num varchar(20))");
	}

	/**
	 * ���ݿ�������
	 * �޸ı�
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(TAG, "���ݿ������ˣ�onUpgrade()ִ����");
		db.execSQL("alter table stu add sex varchar(20)");
	}

}
