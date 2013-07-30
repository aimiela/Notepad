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
	
	public void onAnimationEnd(Animation anim) {
	    this.activity.getControlLayout().setLayoutParams(position);
	    if(position.topMargin == - MainActivity.SIZE_CONTROLS)
	    	this.activity.getControlLayout().setVisibility(0);
	}

	public void onAnimationRepeat(Animation anim) {
		
	}

	public void onAnimationStart(Animation anim) {
	    if(position.topMargin == 0)
	    	this.activity.getControlLayout().setVisibility(1);
	}

}
