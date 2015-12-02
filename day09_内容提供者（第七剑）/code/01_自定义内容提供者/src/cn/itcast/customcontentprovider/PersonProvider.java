package cn.itcast.customcontentprovider;

import cn.itcast.customcontentprovider.db.MyOpenHelper;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {

	MyOpenHelper oh;
	SQLiteDatabase db;
	
	//����һ��uriƥ����������ƥ��uri
	UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
	//��uriƥ�������ƥ�����
	{
		um.addURI("cn.itcast.person", "person", 1);//content://cn.itcast.person/person
		um.addURI("cn.itcast.person", "handsome", 2);//content://cn.itcast.person/handsome
		um.addURI("cn.itcast.person", "person/#", 3);//content://cn.itcast.person/person/2
	}
	
	//�����ṩ�ߴ���ʱ����
	@Override
	public boolean onCreate() {
							//�����ṩ���������ĸ������ģ��ͻ�ȡ�ĸ�������
		oh = new MyOpenHelper(getContext());
		db = oh.getWritableDatabase();
		return false;
	}
		
	
	//uri:�����ṩ�ߵ�������
	//values:��������Ҫ���������
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//���ƥ������1����person�������
		if(um.match(uri) == 1){
			//��˽�����ݿ��в�������
			db.insert("person", null, values);
			
			//����֪ͨ�����ݹ۲���
			//arg0:����ע�������uri�ϵ����ݹ۲���,�����յ�����֪ͨ
			getContext().getContentResolver().notifyChange(uri, null);
		}
		//���ƥ������2����handsome�������
		else if(um.match(uri) == 2){
			db.insert("handsome", null, values);
			getContext().getContentResolver().notifyChange(uri, null);
		}
		else{
			throw new IllegalArgumentException("���uri�����Ⱑɵ��");
		}
		
		return uri;
	}
		
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int i = 0;
		if(um.match(uri) == 1){
			i = db.delete("person", selection, selectionArgs);
		}
		else if(um.match(uri) == 2){
			i = db.delete("handsome", selection, selectionArgs);
		}
		else{
			throw new IllegalArgumentException("���uri���������Ⱑɵ���ź�");
		}
		
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int i = db.update("person", values, selection, selectionArgs);
		return i;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
		if(um.match(uri) == 1){
			cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
		}
		else if(um.match(uri) == 2){
			cursor = db.query("handsome", projection, selection, selectionArgs, null, null, sortOrder);
		}
		else if(um.match(uri) == 3){
			//��uri·����Я��������ȡ����
			long id = ContentUris.parseId(uri);
			cursor = db.query("person", projection, "_id = ?", new String[]{id + ""}, null, null, sortOrder);
		}
		else{
			throw new IllegalArgumentException("���uri���������Ⱑ");
		}
		return cursor;
	}

	@Override
	public String getType(Uri uri) {//content://cn.itcast.person/person
		if(um.match(uri) == 1){
			return "vnd.android.cursor.dir/person";
		}
		else if(um.match(uri) == 3){//content://cn.itcast.person/person/4
			return "vnd.android.cursor.item/person";
		}		
		return null;
	}

}
