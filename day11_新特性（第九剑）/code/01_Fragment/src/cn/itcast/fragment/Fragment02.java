package cn.itcast.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment02 extends Fragment {

	//ϵͳ���ã�����һ��View������ΪFragment����ʾ���� 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//�Ѳ����ļ�����View����return��ȥ
		View v = inflater.inflate(R.layout.fragment02, null);
		return v;
	}
}
