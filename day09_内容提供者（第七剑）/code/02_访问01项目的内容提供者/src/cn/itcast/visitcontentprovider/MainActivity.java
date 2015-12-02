package cn.itcast.visitcontentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void insert(View v){
    	//ͨ�������ṩ�ߣ���01��Ŀ��˽�����ݿ��������
    	
    	//��ȡContentResolver
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues values = new ContentValues();
//    	values.put("name", "����");
//    	values.put("money", "13000");
//    	//���insert������ȥ���������ṩ�ߵ�insert����
//    	cr.insert(Uri.parse("content://cn.itcast.person/person"), values);
    	
    	//���values������
    	values.clear();
    	values.put("name", "٩ү");
    	cr.insert(Uri.parse("content://cn.itcast.person/handsome"), values);
    }
    
    public void delete(View v){
    	//��ȡContentResolver
    	ContentResolver cr = getContentResolver();
    	int i = cr.delete(Uri.parse("content://cn.itcast.person"), "name = ?", new String[]{"�ϱ�"});
    	System.out.println(i);
    }
    
    public void update(View v){
    	//��ȡContentResolver
    	ContentResolver cr = getContentResolver();
    	ContentValues values = new ContentValues();
    	values.put("money", 13200);
    	int i = cr.update(Uri.parse("content://cn.itcast.person"), values, "name = ?", new String[]{"�ź�"});
    	System.out.println(i);
    }
    
    public void query(View v){
    	//��ȡContentResolver
    	ContentResolver cr = getContentResolver();
    	Cursor cursor = cr.query(Uri.parse("content://cn.itcast.person/person"), new String[]{"money", "name"}, null, null, null);
    	
    	while(cursor.moveToNext()){
    		String name = cursor.getString(cursor.getColumnIndex("name"));
    		String money = cursor.getString(cursor.getColumnIndex("money"));
    		
    		System.out.println(name + ":" + money);
    	}
    }
    public void querySingle(View v){
    	ContentResolver cr = getContentResolver();
    	Cursor cursor = cr.query(Uri.parse("content://cn.itcast.person/person/4"), null, null, null, null);
    	if(cursor.moveToFirst()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String money = cursor.getString(cursor.getColumnIndex("money"));
			
			System.out.println(name + ":" + money);
		}
    }
}
