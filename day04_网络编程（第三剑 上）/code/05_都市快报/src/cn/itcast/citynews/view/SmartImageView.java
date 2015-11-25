package cn.itcast.citynews.view;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import cn.itcast.citynews.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * ���������һ��ͼƬ
 */
public class SmartImageView extends ImageView {

	protected static final int MSG_SUCC = 0;
	protected static final int MSG_ERR = 1;

	public SmartImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SmartImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SmartImageView(Context context) {
		super(context);
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SUCC://�ɹ�
				Bitmap bm = (Bitmap) msg.obj ;
				//���ø���ImageView�ķ�����������ͼƬ
				setImageBitmap(bm);
				break;
			case MSG_ERR://ʧ��
				Toast.makeText(getContext(), "code:"+msg.obj, 0).show();
				//��ʾĬ�ϵĴ���ͼƬ
				setImageResource(R.drawable.err);
				break;

			default:
				break;
			}
			
		};
	};

	/**
	 * ��Url��ImageView����ͼƬ
	 * 
	 * @param path
	 */
	public void setImageUrl(final String path) {
		new Thread() {
			public void run() {
				try {
					// 1. ��ʼ��Url
					URL url = new URL(path);
					// 2. ͨ��Url��ȡHttp����
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					// 3. �����������������ʽ
					conn.setRequestMethod("GET");
					// 4. ��ȡ������ 200:�ɹ� 3xxx���� 4xxx�ͻ��˴��� 500����������
					int code = conn.getResponseCode();
					if (code == 200) {
						// 5. �õ��ӷ������˷��ص�������
						InputStream is = conn.getInputStream();
						Bitmap bmp = BitmapFactory.decodeStream(is);
						Message msg = Message.obtain();
						msg.obj = bmp;
						msg.what = MSG_SUCC;
						mHandler.sendMessage(msg);
					} else {
						Message msg = Message.obtain();
						msg.what = MSG_ERR;
						msg.obj = code;
						mHandler.sendMessage(msg);
					}

				} catch (Exception e) {
					e.printStackTrace();
					Message msg = Message.obtain();
					msg.what = MSG_ERR;
					mHandler.sendMessage(msg);
				}
			};
		}.start();

	}

}
