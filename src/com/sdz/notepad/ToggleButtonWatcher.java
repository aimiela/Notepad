package com.sdz.notepad;

import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ToggleButtonWatcher implements OnCheckedChangeListener {

	/* ATTRIBUTES */
	private MainActivity activity = null;
	private String actualStr = null;
	private String newStr = null;
	private TranslateAnimation anim = null;
	private HidingWatcher hidingWatcher = null;
	
	/* CONSTRUCTORS */
	public ToggleButtonWatcher(MainActivity activity) {
		this.activity = activity;
		this.hidingWatcher = new HidingWatcher(activity);
	}

	/* OTHER FUNCTIONS */
	public void onCheckedChanged(CompoundButton button, boolean checked) {
		
		switch(button.getId()) {
			case R.id.bold:
				this.actualStr = activity.getEdit().getText().toString();
				if(checked) {
					this.newStr = actualStr.concat("<b>");
					this.activity.getEdit().setText(newStr);
					button.setBackgroundResource(R.drawable.button_on);
				}
				else {
					this.newStr = actualStr.concat("</b>");
					this.activity.getEdit().setText(newStr);
					button.setBackgroundResource(R.drawable.button_off);
				}
				break;
			case R.id.italic:
				this.actualStr = activity.getEdit().getText().toString();
				if(checked) {
					this.newStr = actualStr.concat("<i>");
					this.activity.getEdit().setText(newStr);
					button.setBackgroundResource(R.drawable.button_on);
				}
				else {
					this.newStr = actualStr.concat("</i>");
					this.activity.getEdit().setText(newStr);
					button.setBackgroundResource(R.drawable.button_off);
				}
				break;
			case R.id.underline:
				this.actualStr = activity.getEdit().getText().toString();
				if(checked) {
					this.newStr = actualStr.concat("<u>");
					this.activity.getEdit().setText(newStr);
					button.setBackgroundResource(R.drawable.button_on);
				}
				else {
					this.newStr = actualStr.concat("</u>");
					this.activity.getEdit().setText(newStr);
					button.setBackgroundResource(R.drawable.button_off);
				}
				break;
			case R.id.hide:
				if(checked) {
					hideControls(true);
					button.setBackgroundResource(R.drawable.button_on);
					button.setText("Show");
				}
				else {
					hideControls(false);
					button.setBackgroundResource(R.drawable.button_off);
					button.setText("Hide");
				}
		}
	}
	
	public void hideControls(boolean hide)
	{
		hidingWatcher.setPosition(hide);
		int coef;
		if(hide) {
			coef = -1;
		}
		else {
			coef = 1;
		}
		this.anim = new TranslateAnimation( 0, 0 , 0, coef * MainActivity.SIZE_CONTROLS);
		this.anim.setDuration(1000);
		this.anim.setFillAfter(false);
		this.anim.setAnimationListener(hidingWatcher);
	    this.activity.getLayout().startAnimation(anim);
	}

}