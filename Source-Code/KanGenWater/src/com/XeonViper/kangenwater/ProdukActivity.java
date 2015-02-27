package com.XeonViper.kangenwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProdukActivity extends Activity {
	
	TextView link1, link2, link3, link4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produk);
		
		link1 = (TextView) findViewById(R.id.link1);
		link1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent link1 = new Intent(getApplication(), LauncherAcid.class);
				startActivity(link1);
			}
		});
		
		link2 = (TextView) findViewById(R.id.link2);
		link2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent link2 = new Intent(getApplication(), LauncherBeauty.class);
				startActivity(link2);
			}
		});
		
		link3 = (TextView) findViewById(R.id.link3);
		link3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent link3 = new Intent(getApplication(), LauncherKangen.class);
				startActivity(link3);
			}
		});
		
		link4 = (TextView) findViewById(R.id.link4);
		link4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent link4 = new Intent(getApplication(), LauncherStrongKangen.class);
				startActivity(link4);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.produk, menu);
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
