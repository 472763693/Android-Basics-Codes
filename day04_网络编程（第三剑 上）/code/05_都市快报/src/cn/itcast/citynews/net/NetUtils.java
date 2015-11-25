package cn.itcast.citynews.net;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import android.content.Context;

import cn.itcast.citynews.R;
import cn.itcast.citynews.bean.NewsBean;
import cn.itcast.citynews.service.ParserXml;

/**
 * ��������
 * 
 */
public class NetUtils {

	/**
	 * �ӷ�������ȡ����
	 * @param context
	 * 			������
	 * @return
	 * 			null:��ʾʧ��
	 */
	public static List<NewsBean> requestNetWorkData(Context context){
		String path = context.getString(R.string.serverip);
		try {
			// 1. ��ʼ��Url
			URL url = new URL(path);
			// 2. ͨ��Url��ȡHttp����
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. �����������������ʽ
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(3000);
			// 4. ��ȡ������ 200:�ɹ� 3xxx���� 4xxx�ͻ��˴��� 500����������
			int code = conn.getResponseCode();
			if (code == 200) {
				// 5. �õ��ӷ������˷��ص�������
				InputStream is = conn.getInputStream();
				//����Xml�ļ�
				return ParserXml.parserXmlFromStream(is);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
