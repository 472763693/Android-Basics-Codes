package cn.itcast.createcopy;

import cn.itcast.matrix.R;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//����ͼƬ���˶�����ֻ����
		Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/photo3.jpg");
		ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		iv_src.setImageBitmap(bmSrc);
		
		//����ͼƬ�ĸ���
		//1.����һ����ԭͼ��Сһ�µĿ������൱�ڴ�����һ����ԭͼ��Сһ�µİ�ֽ
		Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
		
		//2.��������
		Paint paint = new Paint();
		
		//3.�������壬Ȼ��Ѱ�ֽ���ڻ�����
		Canvas canvas = new Canvas(bmCopy);
		
		Matrix matrix = new Matrix();
		//ƽ��Ч��
		matrix.setTranslate(10, 20);
		
		//����Ч��
		matrix.setScale(0.5f, 2);
		//ָ���������ĵ�
		matrix.setScale(0.5f, 2, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
		
		//��תЧ��
		matrix.setRotate(45);
		matrix.setRotate(45, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
		
		//����Ч��
		matrix.setScale(-1, 1);
		matrix.postTranslate(bmCopy.getWidth(), 0);
		
		//��ӰЧ��
		matrix.setScale(1, -1);
		matrix.postTranslate(0, bmCopy.getHeight());
		
		//4.��ʼ����
		canvas.drawBitmap(bmSrc, matrix, paint);
		ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
		
		iv_copy.setImageBitmap(bmCopy);
	}


}
