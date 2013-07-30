package com.sdz.notepad;

import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ToggleButtonWatcher implements OnCheckedChangeListener {

	/* ATTRIBUTES */
	private MainActivity activity = null;
	private String actualStr = null;
	private String newStr = null;
	private TranslateAnimation animTranslate = null;
	private AlphaAnimation animAlpha = null;
	private HidingWatcher hidingWatcher = null;
	
	/* CONSTRUCTORS */
	public ToggleButtonWatcher(MainActivity activity) {
		this.activity = activity;
		this.hidingWatcher = new HidingWatcher(activity);
	}

	/* OTHER FUNCTIONS */
	public void onCheckedChanged(CompoundButton button, boolean checked) {

		this.actualStr = activity.getEdit().getText().toString();
		switch(button.getId()) {
			case R.id.bold:
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
				break;
		}
	}
	
	public void hideControls(boolean hide)
	{
		hidingWatcher.setPosition(hide);
		int coef;
		if(hide) {
			coef = -1;
			this.animAlpha = new AlphaAnimation(1, 0);
		}
		else {
			coef = 1;
			this.animAlpha = new AlphaAnimation(0, 1);
		}
		this.animTranslate = new TranslateAnimation( 0, 0 , 0, coef * MainActivity.SIZE_CONTROLS);
		this.animTranslate.setDuration(1000);
		this.animTranslate.setFillAfter(false);
		this.animTranslate.setAnimationListener(hidingWatcher);
		this.animAlpha.setDuration(1000);
		this.animAlpha.setFillAfter(false);
	    this.activity.getControlLayout().startAnimation(animAlpha);
	    this.activity.getLayout().startAnimation(animTranslate);
	}

}