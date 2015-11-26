package cn.itcast.painter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	int startX;
	int startY;
	private Canvas canvas;
	private Paint paint;
	private ImageView iv;
	private Bitmap bmCopy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ȡ����ͼƬ
		Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
		bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
		paint = new Paint();
		canvas = new Canvas(bmCopy);
		//����
		canvas.drawBitmap(bmSrc, new Matrix(), paint);
		
		iv = (ImageView) findViewById(R.id.iv);
		iv.setImageBitmap(bmCopy);
		
		iv.setOnTouchListener(new OnTouchListener() {
			

			//����imageviewʱ����
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				//��ָ������Ļ
				case MotionEvent.ACTION_DOWN:
					//��ȡ���������ImageView������
					startX = (int) event.getX();
					startY = (int) event.getY();
//					System.out.println(startX + ";" + startY);
					break;
					//��ָ�뿪��Ļ
				case MotionEvent.ACTION_UP:
					break;
					//��ָ����
				case MotionEvent.ACTION_MOVE:
					int newX = (int) event.getX();
					int newY = (int) event.getY();
//					System.out.println(newX + ";" + newY);
					
					//���ݻ�ȡ�����꣬����ֱ��
					canvas.drawLine(startX, startY, newX, newY, paint);
					startX = newX;
					startY = newY;
					iv.setImageBitmap(bmCopy);
					break;
				}
				//����true��ʾ����iv������������¼��������false����ʾ���¼����ݸ����ڵ�
				return true;
			}
		});
	}

	public void red(View v){
		paint.setColor(Color.RED);
	}
	public void green(View v){
		paint.setColor(Color.GREEN);
	}
	public void frush(View v){
		//�ı仭�ʴ�ϸ
		paint.setStrokeWidth(8);
	}
	
	public void save(View v){
		//��λͼ����ѹ���������ļ�
		File file = new File("sdcard/dazuo2.png");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bmCopy.compress(CompressFormat.PNG, 100, fos);
		
		//����SD�������㲥
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
		intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
		sendBroadcast(intent);
	}
	

}
