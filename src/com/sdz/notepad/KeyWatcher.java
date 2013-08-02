package com.sdz.notepad;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

public class KeyWatcher implements OnKeyListener {
	
	/* ATTRIBUTES */
	private MainActivity activity = null;
	private String actualStr = null;
	private String newStr = null;
	
	/* CONSTRUCTORS */
	public KeyWatcher(MainActivity activity) {
		this.activity = activity;
	}

	public boolean onKey(View v, int keyCode, KeyEvent event) {
		System.out.println(keyCode);
		if (event.getAction()==KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
			this.actualStr = activity.getEdit().getText().toString();
			this.newStr = actualStr.concat("<br/>");
			this.activity.getEdit().setText(newStr);
            return true;
        }
        return false;
	}

}
