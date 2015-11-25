package cn.itcast.citynews;

import java.util.List;

import org.w3c.dom.Text;

import com.loopj.android.image.SmartImageView;

import cn.itcast.citynews.bean.NewsBean;
import cn.itcast.citynews.net.NetUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected static final int MSG_ERR = 0;
	protected static final int MSG_SUCC = 1;

	// �ӷ��������õ���������Ŀ�ļ���
	private List<NewsBean> newsList;
	private ListView lvNews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 2. ��MainActivity���ҵ�ListView
		lvNews = (ListView) findViewById(R.id.lv_news);
		//�������ȡ����
		initData();
	}

	/**
	 * // 4. �����ڲ���ķ�ʽȥд
	 */
	private class NewsAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return newsList == null ? 0 : newsList.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(MainActivity.this,
						R.layout.adapter_news_item, null);
			}
			TextView title = (TextView) convertView.findViewById(R.id.tv_title);
			TextView des = (TextView) convertView.findViewById(R.id.tv_des);
			TextView comment = (TextView) convertView
					.findViewById(R.id.tv_comment);
			// ��ʾ������Ŀ������
			NewsBean bean = newsList.get(position);
			title.setText(bean.getTitle());
			des.setText(bean.getDes());
			comment.setText(bean.getComment());

			// ��ʾͼƬ
			SmartImageView iv = (SmartImageView) convertView.findViewById(R.id.iv_news_pic);
			iv.setImageUrl(bean.getImage(),R.drawable.err);
			
			return convertView;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}
	}

	// 2.�����̣߳�Activity����дһ��Handler
	private Handler mHandler = new Handler() {
		// 3.��handlmessage�������޸�UI
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SUCC:// �ɹ�
				// ��listView��������������
				lvNews.setAdapter(new NewsAdapter());
				break;
			case MSG_ERR:// ʧ��
				Toast.makeText(MainActivity.this, "�磬ʧ��low����", 0).show();
				break;

			default:
				break;
			}
		};
	};

	/**
	 * �����߳��з�������
	 */
	public void initData() {
		new Thread() {
			public void run() {
				newsList = NetUtils.requestNetWorkData(MainActivity.this);
				if (newsList == null) {
					// 1.дһ�����̷߳�����Ϣ
					Message msg = Message.obtain();
					msg.what = MSG_ERR;
					mHandler.sendMessage(msg);

				} else {
					// 1.дһ�����̷߳�����Ϣ
					Message msg = Message.obtain();
					msg.what = MSG_SUCC;
					mHandler.sendMessage(msg);
				}
			}
		}.start();
	}

}
