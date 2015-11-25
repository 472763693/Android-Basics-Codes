package cn.itcast.mutildownloade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private EditText etTC;
	private EditText etPath;

	// �߳���
	private int threadCount = 3;
	private LinearLayout llContent;
	// ����url
	private String path;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etPath = (EditText) findViewById(R.id.et_path);
		etTC = (EditText) findViewById(R.id.et_thread_count);
		llContent = (LinearLayout) findViewById(R.id.ll_content);
	}

	/**
	 * �����ļ�
	 * 
	 * @param v
	 */
	public void download(View v) {
		path = etPath.getText().toString().trim();
		String count = etTC.getText().toString().trim();
		if (!TextUtils.isEmpty(count)) {
			threadCount = Integer.valueOf(count);
		}

		// �Ƴ�ll���������view
		llContent.removeAllViews();

		// ��ll������ӽ�����
		for (int i = 0; i < threadCount; i++) {
			View pb = View.inflate(this, R.layout.progressbar, null);
			llContent.addView(pb);
		}

		// ���߳�����ͨ��
		new Thread() {
			public void run() {
				requestNet();
			};
		}.start();
	}

	private void requestNet() {
		// (1). �����ͷ�������Դ�ļ�һ����С�Ŀ��ļ�
		try {
			// 1. ��ʼ��Url
			URL url = new URL(path);
			// 2. ͨ��Url��ȡHttp����
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. �����������������ʽ
			conn.setRequestMethod("GET");
			// 4. ��ȡ������ 200:�ɹ� 3xxx���� 4xxx�ͻ��˴��� 500����������
			int code = conn.getResponseCode();
			// 5. �õ��ӷ������˷��ص���Դ�ļ��Ĵ�С
			int fileLength = conn.getContentLength();
			if (code == 200) {
				System.out.println("��������Դ�ļ��Ĵ�С��" + fileLength);
				RandomAccessFile raf = new RandomAccessFile(getFileName(), "rw");
				// ��Ҫ�����ļ��Ĵ�С
				raf.setLength(fileLength);
				raf.close();
			}

			// (2).��������߳�����
			// ÿ������Ĵ�С
			int blockSize = fileLength / threadCount;

			for (int threadId = 0; threadId < threadCount; threadId++) {
				int startIndex = threadId * blockSize;
				int endIndex = (threadId + 1) * blockSize;
				// ���һ���߳�
				if (threadId == threadCount - 1) {
					// �����ļ�������λ��
					endIndex = fileLength - 1;
				}
				// ��ʼ�߳�
				new DownLoadThread(startIndex, endIndex, threadId).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class DownLoadThread extends Thread {
		// ��ʼλ��
		int startIndex;
		// ����λ��
		int endIndex;
		// �߳�Id
		int threadId;
		// ÿ���߳��������Դ�ļ�������λ��
		int lastDownFilePos;
		ProgressBar  mPb;
		//ÿһ���߳����ص��ܽ���
		int totalSize ;
		//���������ڵĿ�ʼλ��
		int firstStartIndex;
		//��ǰ�߳����صĽ���
		int progress;
		public DownLoadThread(int startIndex, int endIndex, int threadId) {
			super();
			firstStartIndex = startIndex;
			
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.threadId = threadId;
			lastDownFilePos = startIndex;
			mPb = (ProgressBar) llContent.getChildAt(threadId);
			totalSize = endIndex - startIndex;
			mPb.setMax(totalSize);
			
		}

		@Override
		public void run() {
			super.run();
			System.out.println("�������߳�" + threadId + ": " + startIndex + " ~ "
					+ endIndex);
			// System.out.println("�߳�" + threadId + "������: "
			// +(endIndex-startIndex));

			try {
				File file = new File(getTmpFileName(threadId));
				if (file.exists() && file.length() > 0) {
					FileInputStream fis = new FileInputStream(file);
					BufferedReader br = new BufferedReader(
							new InputStreamReader(fis));
					lastDownFilePos = Integer.valueOf(br.readLine());
					startIndex = lastDownFilePos;
					br.close();
				}
				System.out.println("	ʵ�����߳�" + threadId + ": " + startIndex
						+ " ~ " + endIndex);

				// 1. ��ʼ��Url
				URL url = new URL(path);
				// 2. ͨ��Url��ȡHttp����
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				// 3. �����������������ʽ
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(3000);
				// ��Ҫ������ÿ���߳������������Դ�Ĵ�С
				conn.setRequestProperty("Range", "bytes=" + startIndex + "-"
						+ endIndex);
				// 4. ��ȡ������ 200:�ɹ� 3xxx���� 4xxx�ͻ��˴��� 500����������
				// 206:��ʾ��������ɹ�
				int code = conn.getResponseCode();
				System.out.println("��������ɹ���" + code);
				if (code == 206) {
					// 5. �õ��ӷ������˷��ص�������
					InputStream is = conn.getInputStream();
					RandomAccessFile rf = new RandomAccessFile(getFileName(),
							"rw");
					// ��Ҫ��ÿ���̴߳����Ŀ�ʼλ��д�ļ�
					rf.seek(startIndex);
					byte[] buffer = new byte[1024];
					int len = -1;
					while ((len = is.read(buffer)) != -1) {
						rf.write(buffer, 0, len);

						lastDownFilePos = lastDownFilePos + len;
						
						//���㵱ǰ�������صĽ���
						progress = lastDownFilePos-firstStartIndex;
						mPb.setProgress(progress);
						
						// �洢�߳������ļ��Ľ���
						RandomAccessFile f = new RandomAccessFile(
								getTmpFileName(threadId), "rwd");
						String pos = String.valueOf(lastDownFilePos);
						f.write(pos.getBytes());
						f.close();
					}
					rf.close();
				}

				System.out.println("�߳�" + threadId + "������ˣ�");
				// ɾ��������ȵ���ʱ�ļ�
				System.out.println(file.delete());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��������Դ������
	 * 
	 * @return
	 */
	String getFileName() {
		int index =path.lastIndexOf("/") + 1;
		return  "/mnt/sdcard/"+path.substring(index);
	}

	/**
	 * �߳����ؽ����ļ��Ĵ洢
	 * 
	 * @param threadId
	 * @return
	 */
	String getTmpFileName(int threadId) {

		return getFileName() + threadId + ".txt";
	}

}
