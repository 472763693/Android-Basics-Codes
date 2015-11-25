package cn.itcast.tween;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.iv_fly);
	}

	/**
	 * ͸���ȶ���
	 * 
	 * @param v
	 */
	public void alpha(View v) {
		/*
		 * ��һ������fromAlpha��������ʼʱ��͸���ȣ� �ڶ�������toAlpha�� ��������ʱ��͸���ȡ�
		 */
		Animation alpha = new AlphaAnimation(1f, 0.1f);

		// ������ʾʱ�䳤��
		alpha.setDuration(2000);
		// �����ظ�����
		alpha.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		alpha.setRepeatMode(Animation.REVERSE);

		// ��ImageView�ϲ��Ŷ���
		iv.startAnimation(alpha);

	}

	/**
	 * ���Ŷ���
	 * 
	 * @param v
	 */
	public void scale(View v) {

		/*
		 * ����1��x������ʼ��С(1f��ʾԭͼ��С) ����2��x������ֹ��С(0.2f��ʾԭͼ��0.2��)
		 * ����3��y������ʼ��С(1f��ʾԭͼ��С) ����4��y������ֹ��С(0.2f��ʾԭͼ��0.2��) ����5���������ĵ�x��ȡֵ�Ĳ��շ�ʽ
		 * ����6: ���ĵ�x���ȡֵ(0.5f��ʾ�����ԭͼ��0.5��) ����7���������ĵ�y��ȡֵ���շ�ʽ ����8:
		 * ���ĵ�y���ȡֵ(0.5f��ʾ�����ԭͼ��0.5��)
		 */
		ScaleAnimation rotate = new ScaleAnimation(4f, 0.2f, 4f, 0.2f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// ������ʾʱ�䳤��
		rotate.setDuration(2000);
		// �����ظ�����
		rotate.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		rotate.setRepeatMode(Animation.REVERSE);

		// ��ImageView�ϲ��Ŷ���
		iv.startAnimation(rotate);
	}

	/**
	 * ��ת����
	 * 
	 * @param v
	 */
	public void rotate(View v) {

		/*
		 * ����1����ת����ʼ�Ƕ� ����2����ת����ֹ�Ƕ� ����3����ת���ĵ�x��ȡֵ���շ�ʽ
		 * ����4�����ĵ�x���ȡֵ(0.5f��ʾ�����ԭͼ��0.5��) ����5����ת���ĵ�y��ȡֵ���շ�ʽ
		 * ����6�����ĵ�y���ȡֵ(0.5f��ʾ�����ԭͼ��0.5��)
		 */
		RotateAnimation rotate = new RotateAnimation(360, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// ������ʾʱ�䳤��
		rotate.setDuration(2000);
		// �����ظ�����
		rotate.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		rotate.setRepeatMode(Animation.REVERSE);

		// ��ImageView�ϲ��Ŷ���
		iv.startAnimation(rotate);

	}

	/**
	 * λ�ƶ���
	 * 
	 * @param v
	 */
	public void translate(View v) {

		/*
		 * ����1,����3������5������7�� ���ò��յ�ķ�ʽ������Լ���Animation.RELATIVE_TO_SELF
		 * ����2��x����ʼ�ƶ���λ�� (0��ʾԭͼλ�����Ͻ�x�������) ����4��x��ֹͣ�ƶ���λ�ã�2��ʾ�ƶ�ԭͼ��ȵ�������
		 * ����6��y����ʼ�ƶ���λ�� (0��ʾԭͼλ�����Ͻ�y�������) ����8��y��ֹͣ�ƶ���λ�ã�2��ʾ�ƶ�ԭͼ�߶ȵ�������
		 */
		TranslateAnimation tras = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2,
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);
		// ������ʾʱ�䳤��
		tras.setDuration(2000);
		// �����ظ�����
		tras.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		tras.setRepeatMode(Animation.REVERSE);

		// ��ImageView�ϲ��Ŷ���
		iv.startAnimation(tras);
	}
	
	public void mahang (View view){
		AnimationSet set = new AnimationSet(false);
		
		TranslateAnimation tras = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2,
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);
		// ������ʾʱ�䳤��
		tras.setDuration(2000);
		// �����ظ�����
		tras.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		tras.setRepeatMode(Animation.REVERSE);
		
		RotateAnimation rotate = new RotateAnimation(360, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// ������ʾʱ�䳤��
		rotate.setDuration(2000);
		// �����ظ�����
		rotate.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		rotate.setRepeatMode(Animation.REVERSE);

		
		
		ScaleAnimation scale = new ScaleAnimation(4f, 0.2f, 4f, 0.2f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// ������ʾʱ�䳤��
		scale.setDuration(2000);
		// �����ظ�����
		scale.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		scale.setRepeatMode(Animation.REVERSE);

		
		Animation alpha = new AlphaAnimation(1f, 0.1f);

		// ������ʾʱ�䳤��
		alpha.setDuration(2000);
		// �����ظ�����
		alpha.setRepeatCount(2);
		// ���ö����ظ���ģʽ
		alpha.setRepeatMode(Animation.REVERSE);
		
		set.addAnimation(tras);
		set.addAnimation(alpha);
		set.addAnimation(rotate);
		set.addAnimation(scale);
		
		// ��ImageView�ϲ��Ŷ���
		iv.startAnimation(set);

	}
}
