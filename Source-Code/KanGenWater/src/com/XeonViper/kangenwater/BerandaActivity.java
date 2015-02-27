package com.XeonViper.kangenwater;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BerandaActivity extends Activity {
	
	ImageView imagePesan, imageTentang;
	TextView Login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beranda);
		
		Typeface fonthome = Typeface.createFromAsset(getAssets(), "Lucida Calligraphy.ttf");
		TextView tvhome = (TextView) findViewById(R.id.textView1);
		tvhome.setTypeface(fonthome);
		
		imagePesan = (ImageView) findViewById(R.id.imageView2);
		imageTentang = (ImageView) findViewById(R.id.imageView3);
		Login = (TextView) findViewById(R.id.Login);
		
		imagePesan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent masukPesan = new Intent(BerandaActivity.this, PesanActivity.class);
				startActivity(masukPesan);
			}
		});
		
		imageTentang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent masukTentang = new Intent(BerandaActivity.this, TentangActivity.class);
				startActivity(masukTentang);
			}
		});
		
		Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent masukLogin = new Intent(BerandaActivity.this, Login.class);
				startActivity(masukLogin);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.beranda, menu);
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
