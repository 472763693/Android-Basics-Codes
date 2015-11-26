package cn.itcast.createcopy;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 1. �õ�ԭͼ
		Bitmap srcBmp = BitmapFactory.decodeFile("/sdcard/2015.jpg");
		// 2. ������ԭͼһ�����Ŀհ�ֽ��
		Bitmap copyBmp = srcBmp.createBitmap(srcBmp.getWidth(),
				srcBmp.getHeight(), srcBmp.getConfig());
		// 3. �ѿհ׵�ֽ�����ڻ�����
		Canvas canvas = new Canvas(copyBmp);
		// 4. ��������
		Paint paint = new Paint();
		// 5. ��ʼ����
		 Matrix matrix = new Matrix();
		 //ƽ��
//		 matrix.setTranslate(100, 200);
		 //��ת
//		 matrix.setRotate(45);
//		 matrix.setRotate(45, copyBmp.getWidth()/2, copyBmp.getHeight()/2);
		 //����
//		 matrix.setScale(0.5f, 2,copyBmp.getWidth()/2, copyBmp.getHeight()/2);
		 //����
//		 matrix.setScale(-1, 1);
//		 matrix.postTranslate(copyBmp.getWidth(), 0);
		 //��Ӱ
		 matrix.setScale(1, -0.5f);
		 matrix.postTranslate(0, copyBmp.getHeight());
		 
		canvas.drawBitmap(srcBmp,matrix, paint);

		ImageView ivCopy = (ImageView) findViewById(R.id.iv_copy);
		ivCopy.setImageBitmap(copyBmp);
		ImageView ivSrc = (ImageView) findViewById(R.id.iv_src);
		ivSrc.setImageBitmap(srcBmp);
	}

}
