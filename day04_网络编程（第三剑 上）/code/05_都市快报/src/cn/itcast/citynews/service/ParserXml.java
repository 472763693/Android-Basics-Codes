package cn.itcast.citynews.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import cn.itcast.citynews.bean.NewsBean;

/**
 * ����xml�ļ��Ĺ�����
 */
public class ParserXml {

	/**
	 * ���������н���Xml�ļ�
	 * @param is
	 * 			������
	 * @return
	 * 			null:��ʾ����Xml�ļ�����
	 */
	public static List<NewsBean> parserXmlFromStream(InputStream is){
		List<NewsBean> newsList = new ArrayList<NewsBean>();
		try {
			// 1. ��ʼ��Xml������
			XmlPullParser parser = Xml.newPullParser();
			// 2. ���ò���������
			parser.setInput(is, "utf-8");
			// 3. ��������
			int type = parser.getEventType();
			NewsBean bean = null;
			
			while(type != XmlPullParser.END_DOCUMENT){
				//��ʼ���߽�����ǩ
				String tag = parser.getName();
				switch (type) {
				case XmlPullParser.START_TAG://��ʼ��ǩ
					if("item".equals(tag)){			//ÿ��������Ŀ�Ŀ�ʼ��ǩ
						bean  = new NewsBean();
					}else if("title".equals(tag)){	//���ŵı���
						String title = parser.nextText();
						bean.setTitle(title);
					}else if("des".equals(tag)){	//���ŵ�����
						String des = parser.nextText();
						bean.setDes(des);
					}else if("image".equals(tag)){	//���ŵ�ͼƬ��Url
						String imageUrl = parser.nextText();
						bean.setImage(imageUrl);
					}else if("comment".equals(tag)){//���ŵ�����
						String comment = parser.nextText();
						bean.setComment(comment);
					}
					break;
				case XmlPullParser.END_TAG://������ǩ
					if("item".equals(tag)){			//ÿ��������Ŀ�Ľ�����ǩ
						newsList.add(bean);
					}
					break;

				default:
					break;
				}
				
				//�õ���һ���¼�
				type = parser.next();
			}
			
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
