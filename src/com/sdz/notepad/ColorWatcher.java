package com.sdz.notepad;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ColorWatcher implements OnCheckedChangeListener {

	/* ATTRIBUTES */
	private MainActivity activity = null;
	private String actualStr = null;
	private String newStr = null;
	
	/* CONSTRUCTORS */
	public ColorWatcher(MainActivity activity) {
		this.activity = activity;
	}
	
	/* OTHER FUNCTIONS */
	public void onCheckedChanged(RadioGroup radioGroup, int id) {
		this.actualStr = activity.getEdit().getText().toString();
		switch(id) {
			case R.id.black:
				this.newStr = actualStr.concat("<font color=\"").concat(clearColorCode(activity.getResources().getString(R.color.black))).concat("\"></font>");
				this.activity.getEdit().setText(newStr);
				break;
			case R.id.red:
				this.newStr = actualStr.concat("<font color=\"").concat(clearColorCode(activity.getResources().getString(R.color.red))).concat("\"></font>");
				this.activity.getEdit().setText(newStr);
				break;
			case R.id.green:
				this.newStr = actualStr.concat("<font color=\"").concat(clearColorCode(activity.getResources().getString(R.color.green))).concat("\"></font>");
				this.activity.getEdit().setText(newStr);
				break;
			case R.id.blue:
				this.newStr = actualStr.concat("<font color=\"").concat(clearColorCode(activity.getResources().getString(R.color.blue))).concat("\"></font>");
				this.activity.getEdit().setText(newStr);
				break;
		}
	}

	public String clearColorCode(String str) {
		String newStr = str.replaceFirst("ff", "");
		return newStr;
	}
	
}
