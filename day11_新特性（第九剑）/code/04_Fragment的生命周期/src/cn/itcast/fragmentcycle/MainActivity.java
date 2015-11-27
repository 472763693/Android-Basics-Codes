package cn.itcast.fragmentcycle;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    private Fragment01 fragment01;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //1.����Fragment����
        fragment01 = new Fragment01();
    	//2.��ȡFragment������
    	FragmentManager fm = getFragmentManager();
    	//3.������
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.������ʾfragment01
    	//arg0:������id��Ҳ����֡����
    	ft.replace(R.id.fl, fragment01);
    	//5.�ύ
    	ft.commit();
    }


    public void click1(View v){
    	//��ʾfragment01
    	//2.��ȡFragment������
    	FragmentManager fm = getFragmentManager();
    	//3.������
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.������ʾfragment01
    	//arg0:������id��Ҳ����֡����
    	ft.replace(R.id.fl, fragment01);
    	//5.�ύ
    	ft.commit();
    }
    
    public void click2(View v){
    	//��ʾfragment02
    	//1.����Fragment����
    	Fragment02 fragment02 = new Fragment02();
    	//2.��ȡFragment������
    	FragmentManager fm = getFragmentManager();
    	//3.������
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.������ʾfragment02
    	//arg0:������id��Ҳ����֡����
    	ft.replace(R.id.fl, fragment02);
    	//5.�ύ
    	ft.commit();
    }
    
    public void click3(View v){
    	//��ʾfragment03
    	//1.����Fragment����
    	Fragment03 fragment03 = new Fragment03();
    	//2.��ȡFragment������
    	FragmentManager fm = getFragmentManager();
    	//3.������
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.������ʾfragment03
    	//arg0:������id��Ҳ����֡����
    	ft.replace(R.id.fl, fragment03);
    	//5.�ύ
    	ft.commit();
    }
    2015/6/14
}
