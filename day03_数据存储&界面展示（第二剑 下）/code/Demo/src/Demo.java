import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Demo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		//1. ���ڴ��г�ʼ����һ��file����
		File file = new File("C:\\info.txt");
		
		//2. ��file������Ӳ���ϴ����ļ�
		FileOutputStream fos = new FileOutputStream(file);
		fos.write("�Ǻǡ�������".getBytes());
		fos.close();
		
	}

}
