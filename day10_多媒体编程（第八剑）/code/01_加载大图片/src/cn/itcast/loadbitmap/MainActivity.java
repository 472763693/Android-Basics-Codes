package cn.itcast.loadbitmap;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v){
		Options opt = new Options();
		//������������Ϣ��ֻ����ͼƬ���
		opt.inJustDecodeBounds = true;
		//���ٽ���������Ϣ���Ͳ���Ҫ�����ڴ�
		BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
		
		//��ȡͼƬ���
		int imageWidth = opt.outWidth;
		int imageHeight = opt.outHeight;
		
		//��ȡ��Ļ���
		Display dp = getWindowManager().getDefaultDisplay();
		int screenWidth = dp.getWidth();
		int screenHeight = dp.getHeight();
		
		//�������ű���
		int widthScale = imageWidth / screenWidth;
		int heightScale = imageHeight / screenHeight;
		
		//����ʹ�õ����ű���
		int scale = 1;
		if(widthScale >= heightScale && widthScale > 1){
			scale = widthScale;
		}
		else if(widthScale < heightScale && heightScale > 1){
			scale = heightScale;
		}	
		
		opt.inSampleSize = scale;
		opt.inJustDecodeBounds = false;
		//����С���ټ���
		Bitmap bm = BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
		
		ImageView iv = (ImageView) findViewById(R.id.iv);
		iv.setImageBitmap(bm);
	}

}
