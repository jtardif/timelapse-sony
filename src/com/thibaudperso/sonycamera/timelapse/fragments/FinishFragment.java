package com.thibaudperso.sonycamera.timelapse.fragments;

import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thibaudperso.sonycamera.R;
import com.thibaudperso.sonycamera.timelapse.StepFragment;

public class FinishFragment extends StepFragment {

	private FinishFragmentListener mListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View resView = inflater.inflate(R.layout.fragment_finish, container, false);
		
		ImageView restartImage = (ImageView) resView.findViewById(R.id.finishRestartImage);
		TextView restartMessage = (TextView) resView.findViewById(R.id.finishRestartMessage);
	
		restartImage.setOnClickListener(onRestartClickListener);
		restartMessage.setOnClickListener(onRestartClickListener);
		
		return resView;
	}
	
	public void setListener(FinishFragmentListener listener) {
		this.mListener = listener;
	}
	
	private OnClickListener onRestartClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(mListener != null) {
				mListener.onRestartProcess();
			}
		}
	};
	
	public void onEnterFragment() {
		super.onEnterFragment();
		setStepCompleted(true);
	};
	
	@Override
	public void onExitFragment() {
		super.onExitFragment();
		setStepCompleted(false);
	}
	
	@Override
	public Spanned getInformation() {
		return null;
	}
	
}