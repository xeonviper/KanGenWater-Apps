package com.XeonViper.kangenwater;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final int SPLASH_TIME = 3 * 1000; // Set waktu 3 detik
	ProgressBar prg;
	
	@SuppressLint("NewApi")

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "Lucida Calligraphy.ttf");
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setTypeface(font);
		
		prg = (ProgressBar) findViewById(R.id.progressBar1);
		prg.setAlpha(SPLASH_TIME);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent masuk = new Intent(MainActivity.this, BerandaActivity.class);
				startActivity(masuk);
				finish();
			}
		}, SPLASH_TIME);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, SPLASH_TIME);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
