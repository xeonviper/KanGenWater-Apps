package com.XeonViper.kangenwater;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TentangActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tentang);
		
		TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
		
		TabSpec Produk = tab.newTabSpec("Produk");
		TabSpec Penjual = tab.newTabSpec("Penjual");
		
		Produk.setIndicator("Produk");
        Produk.setContent(new Intent(this,ProdukActivity.class));
        
        Penjual.setIndicator("Penjual");
        Penjual.setContent(new Intent(this,PenjualActivity.class));
        
        tab.addTab(Produk);
        tab.addTab(Penjual);
	}
}
