package com.itcast.web;
/**
 * tomcat���õ������ iso-8859-1��� û�����ġ�
 * ��������˲���ʶ���ַ��� ��Ĭ��ʹ�ñ��ص�Ĭ�����gbk��
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�����QQ�� ������
		String qq = request.getParameter("qq");
		String pwd = request.getParameter("pwd");
		
		//����̨��ӡ���
		System.out.println("---------------");
		System.out.println("qq:"+ new String(qq.getBytes("iso-8859-1"),"utf-8"));
		System.out.println("pwd:"+pwd);
		
		//ģ��������Ĳ�������ѯ���ݿ� ��qq�������Ƿ���ȷ
		if("123".equals(qq)&&"asd".equals(pwd)){
			//�������������  ����  �ֻ�
			response.getOutputStream().write("��¼�ɹ�".getBytes("utf-8"));
		}else{
			response.getOutputStream().write("��¼ʧ��".getBytes("utf-8"));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
		System.out.println();
		System.out.println("post�ύ������");
	}

}
