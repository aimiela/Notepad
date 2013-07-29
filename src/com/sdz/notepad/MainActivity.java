package com.sdz.notepad;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	/* ATTRIBUTES */
	private RelativeLayout layout = null;
	private RelativeLayout styleLayout = null;
	private RelativeLayout smileyLayout = null;
	private RadioGroup colorGroup = null;
	private Button bold = null;
	private Button italic = null;
	private Button underline = null;
	private Button happy = null;
	private Button veryhappy = null;
	private Button wink = null;
	private Button hide = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the components
		this.layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_main, null);
		this.styleLayout = (RelativeLayout) layout.findViewById(R.id.styleLayout);
		this.smileyLayout = (RelativeLayout) layout.findViewById(R.id.smileyLayout);
		this.colorGroup = (RadioGroup) layout.findViewById(R.id.colorGroup);
		this.bold = (Button) layout.findViewById(R.id.bold);
		this.italic = (Button) layout.findViewById(R.id.italic);
		this.underline = (Button) layout.findViewById(R.id.underline);
		this.happy = (Button) layout.findViewById(R.id.happy);
		this.veryhappy = (Button) layout.findViewById(R.id.veryhappy);
		this.wink = (Button) layout.findViewById(R.id.wink);
		this.hide = (Button) layout.findViewById(R.id.hide);
		
		setContentView(layout);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
