package cn.itcast.junit.text;

import cn.itcast.junit.CalcService;
import android.test.AndroidTestCase;

/**
 * 1. дһ����̳� AndroidTestCase
 * 
 */
public class TestCalcService extends AndroidTestCase {
	/**
	 * 2. дһ�����Է���
	 * 		�׳��쳣��Androidϵͳ
	 * 		���������ֱ�����public��AndroidϵͳҪ�÷���ȥ����
	 * 
	 * @throws Exception
	 */
	public void testAdd()throws Exception{
		CalcService calc = new CalcService();
		int res = calc.add(1, 1);
		
		//3. Ҫ�Բ��Խ�����ж���
		assertEquals(2, res);
	}
}
