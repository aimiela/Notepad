package com.sdz.notepad;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;

public class EditWatcher implements TextWatcher {

	/* ATTRIBUTES */
	private MainActivity activity;
	
	/* CONSTRUCTORS */
	public EditWatcher(MainActivity activity) {
		this.activity = activity;
	}
	
	public void afterTextChanged(Editable edit) {
		if(activity != null)
			this.activity.getResult().setText(Html.fromHtml(edit.toString()));
	}

	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

}
