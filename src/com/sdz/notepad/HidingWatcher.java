package com.sdz.notepad;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class HidingWatcher implements AnimationListener {

	/* ATTRIBUTES */
	private MainActivity activity = null;
	private LayoutParams position = null;
	
	/* CONSTRUCTORS */
	public HidingWatcher(MainActivity activity) {
		this.activity = activity;
	}
	
	/* OTHER FUNCTIONS */
	public void setPosition(boolean hide) {
		this.position = new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		if(hide) {
			this.position.topMargin = - MainActivity.SIZE_CONTROLS;
		}
		else {
			this.position.topMargin = 0;
		}
	}
	
	public void onAnimationEnd(Animation animation) {
	    this.activity.getControlLayout().setLayoutParams(position);
	}

	public void onAnimationRepeat(Animation animation) {
		
	}

	public void onAnimationStart(Animation animation) {
	}

}
