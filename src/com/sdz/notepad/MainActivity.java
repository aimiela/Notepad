package com.sdz.notepad;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	/* CLASS CONSTANTS */
	public static final int SIZE_CONTROLS = 230;
	
	/* ATTRIBUTES */
	private RelativeLayout layout = null;
	private RelativeLayout controlLayout = null;
	private RelativeLayout styleLayout = null;
	private RelativeLayout smileyLayout = null;
	private RadioGroup colorGroup = null;
	private ToggleButton bold = null;
	private ToggleButton italic = null;
	private ToggleButton underline = null;
	private Button happy = null;
	private Button veryhappy = null;
	private Button wink = null;
	private ToggleButton hide = null;
	private EditText edit = null;
	private TextView result = null;
	private EditWatcher editWatcher = null;
	private ToggleButtonWatcher toggleButtonWatcher = null;
	private ColorWatcher colorWatcher = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the components
		this.layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
		this.controlLayout = (RelativeLayout) layout.findViewById(R.id.controlLayout);
		this.styleLayout = (RelativeLayout) layout.findViewById(R.id.styleLayout);
		this.smileyLayout = (RelativeLayout) layout.findViewById(R.id.smileyLayout);
		this.colorGroup = (RadioGroup) layout.findViewById(R.id.colorGroup);
		this.bold = (ToggleButton) layout.findViewById(R.id.bold);
		this.italic = (ToggleButton) layout.findViewById(R.id.italic);
		this.underline = (ToggleButton) layout.findViewById(R.id.underline);
		this.happy = (Button) layout.findViewById(R.id.happy);
		this.veryhappy = (Button) layout.findViewById(R.id.veryhappy);
		this.wink = (Button) layout.findViewById(R.id.wink);
		this.hide = (ToggleButton) layout.findViewById(R.id.hide);
		this.edit = (EditText) layout.findViewById(R.id.edit);
		this.result = (TextView) layout.findViewById(R.id.result);
		
		// Initialize the watchers
		this.editWatcher = new EditWatcher(this);
		this.toggleButtonWatcher = new ToggleButtonWatcher(this);
		this.colorWatcher = new ColorWatcher(this);
		
		// Set the watchers
		this.edit.addTextChangedListener(editWatcher);
		this.bold.setOnCheckedChangeListener(toggleButtonWatcher);
		this.italic.setOnCheckedChangeListener(toggleButtonWatcher);
		this.underline.setOnCheckedChangeListener(toggleButtonWatcher);
		this.colorGroup.setOnCheckedChangeListener(colorWatcher);
		this.hide.setOnCheckedChangeListener(toggleButtonWatcher);
		
		setContentView(layout);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/* GETTERS */
	public RelativeLayout getLayout() {
		return layout;
	}
	
	public RelativeLayout getControlLayout() {
		return controlLayout;
	}
	
	public RadioGroup getColorGroup() {
		return colorGroup;
	}
	
	public EditText getEdit() {
		return edit;
	}

	public TextView getResult() {
		return result;
	}

}
