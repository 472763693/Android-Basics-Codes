package cn.itcast.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private EditText etName;
	private EditText etNum;
	private RadioGroup rgSex;
	private TextView tvContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// �ҵ����ĵĿؼ�
		etName = (EditText) findViewById(R.id.et_name);
		etNum = (EditText) findViewById(R.id.et_num);
		rgSex = (RadioGroup) findViewById(R.id.rg_sex);
		tvContent = (TextView) findViewById(R.id.tv_content);

		readXmlData();
	}

	/**
	 * ����Xml�ļ�
	 */
	public void readXmlData() {
		try {
			// 1. ��ʼ��Xml������
			XmlPullParser parser = Xml.newPullParser();
			// 2. ���ò���
			InputStream is = this.getAssets().open("student.xml");
			parser.setInput(is, "utf-8");
			// 3. ��������
			int type = parser.getEventType();
			String name = null;
			String num = null;
			String sex = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				// ��ȡ��ǩ����
				String tag = parser.getName();
				switch (type) {
				case XmlPullParser.START_TAG:// ��ʼ��ǩ
					if ("name".equals(tag)) {// ����
						name = parser.getText();
						Log.e(TAG, name);
					} else if ("num".equals(tag)) {// ѧ��
						num = parser.nextText();
						Log.e(TAG, num);
					} else if ("sex".equals(tag)) {// �Ա�
						sex = parser.nextText();
						Log.e(TAG, sex);
					}
					break;

				default:
					break;
				}

				// �õ���ǰ���¼�
				type = parser.next();
			}
			is.close();
			
			tvContent.setText("����:"+name+" ѧ��:"+num+"�Ա�"+sex);
			Toast.makeText(this, "��ȡ�ɹ���", 0).show();
		} catch (Exception e) {
			Toast.makeText(this, "��ȡʧ�ܣ�", 0).show();
			e.printStackTrace();
		}
	}

	/**
	 * �����ť����Xml�ļ�
	 * 
	 * @param v
	 */
	public void create(View v) {
		String name = etName.getText().toString().trim();
		String num = etNum.getText().toString().trim();
		if (TextUtils.isEmpty(name) || TextUtils.isEmpty(num)) {
			Toast.makeText(this, "��������ѧ�Ų���Ϊ�գ�", MODE_PRIVATE).show();
			return;
		}
		// ����Xml�ļ�
		try {
			// 1. ��ʼ��Xml���л���
			XmlSerializer serializer = Xml.newSerializer();
			// 2. ���ò���������
			FileOutputStream fos = this.openFileOutput("student.xml", 0);
			serializer.setOutput(fos, "utf-8");
			// 3. ����Xml�ļ�
			serializer.startDocument("utf-8", true);

			serializer.startTag(null, "stu");

			// ����
			serializer.startTag(null, "name");
			serializer.text(name);
			serializer.endTag(null, "name");

			// ѧ��
			serializer.startTag(null, "num");
			serializer.text(num);
			serializer.endTag(null, "num");

			// �Ա�
			String sex = "��";
			int id = rgSex.getCheckedRadioButtonId();
			switch (id) {
			case R.id.rb_boy:// ��
				sex = "��";
				break;
			case R.id.rb_girl:// Ů
				sex = "Ů";
				break;
			case R.id.rb_yao:// ��
				sex = "��";
				break;
			default:
				break;
			}
			serializer.startTag(null, "sex");
			serializer.text(sex);
			serializer.endTag(null, "sex");

			serializer.endTag(null, "stu");
			serializer.endDocument();
			fos.close();
			Toast.makeText(this, "����Xml�ļ�succ", 0).show();
		} catch (Exception e) {
			Toast.makeText(this, "����Xml�ļ�ʧ��", 0).show();
			e.printStackTrace();
		}

	}

}
