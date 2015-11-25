package cn.itcast.citynews.test;

import java.io.InputStream;
import java.util.List;

import cn.itcast.citynews.bean.NewsBean;
import cn.itcast.citynews.service.ParserXml;

import android.test.AndroidTestCase;

/**
 * ���Խ���Xml�ļ��ķ���
 */
public class TestParserXml extends AndroidTestCase {

	public void testParserXmlFromStream() throws Exception {
		InputStream is = getContext().getAssets().open("news.xml");
		List<NewsBean> newsList = ParserXml.parserXmlFromStream(is);
		
		for (NewsBean bean : newsList) {
			System.out.println(bean.toString());
		}
	}
}
