package cn.itcast.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MusicController();
	}

	//���м����еķ�����ȡ���ӿ��У�Ȼ��ʵ������ӿ�
	class MusicController extends Binder implements MusicControllerInterface{
		@Override
		public void play(){
			//�����ⲿ���ͬ������
			MusicService.this.play();
		}

		@Override
		public void pause() {
			MusicService.this.pause();
			
		}
	}
	
	public void play(){
		System.out.println("����������");
	}
	
	public void pause(){
		System.out.println("���ֲ�����ͣ��");
	}
}
