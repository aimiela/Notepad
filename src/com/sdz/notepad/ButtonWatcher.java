package com.sdz.notepad;

import android.view.View;
import android.view.View.OnClickListener;

public class ButtonWatcher implements OnClickListener {

	/* ATTRIBUTES */
	private MainActivity activity = null;
	private String actualStr = null;
	private String newStr = null;
	
	/* CONSTRUCTORS */
	public ButtonWatcher(MainActivity activity) {
		this.activity = activity;
	}
	
	public void onClick(View v) {
		this.actualStr = activity.getEdit().getText().toString();
		switch(v.getId()) {
			case R.id.happy:
				this.newStr = actualStr.concat("<img src=\"happy\" />");
				this.activity.getEdit().setText(newStr);
				break;
			case R.id.veryhappy:
				this.newStr = actualStr.concat("<img src=\"veryhappy\" />");
				this.activity.getEdit().setText(newStr);
				break;
			case R.id.wink:
				this.newStr = actualStr.concat("<img src=\"wink\" />");
				this.activity.getEdit().setText(newStr);
				break;
			default:
				break;
		}
	}

}
