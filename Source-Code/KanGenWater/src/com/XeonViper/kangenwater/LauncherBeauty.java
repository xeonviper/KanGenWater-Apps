package com.XeonViper.kangenwater;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class LauncherBeauty extends Activity {
	
	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher_beauty);
		webview = (WebView) findViewById(R.id.web_view);
		openBrowser();
	}

	private void openBrowser() {
		// TODO Auto-generated method stub
		String url = "http://www.kangenwaterindonesia.com/strong-kangen-water-2/";
		
		WebChromeClient wcc = new WebChromeClient();
		
		webview.setWebChromeClient(wcc);
		
		webview.getSettings().setJavaScriptEnabled(true);
		
		webview.getSettings().setBuiltInZoomControls(true);
		
		webview.enablePlatformNotifications();
		
		webview.loadUrl(url);
	}
}
