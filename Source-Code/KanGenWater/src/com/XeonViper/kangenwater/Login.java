package com.XeonViper.kangenwater;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
	
	private EditText textUser, textPass;
	private Button btnlogin;
	
	private ProgressDialog pDialog;
	
	JSONParser jsonParser = new JSONParser();
	
	private static final String LOGIN_URL = "http://192.168.1.23/Kangen/login/login.php";
	
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		textUser = (EditText) findViewById(R.id.editUsername);
		textPass = (EditText) findViewById(R.id.editPassword);
		
		btnlogin = (Button) findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AttemptSignIn().execute();
			}
		});
	}
	
	class AttemptSignIn extends AsyncTask<String, String, String> {
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(Login.this);
			pDialog.setMessage("Attempting login...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String username = textUser.getText().toString();
			String password = textPass.getText().toString();
			
			try {
				List<NameValuePair> param = new ArrayList<NameValuePair>();
				param.add(new BasicNameValuePair("username", username));
				param.add(new BasicNameValuePair("password", password));
				
				JSONObject  json = jsonParser.makeHTTPRequest(LOGIN_URL, "POST", param);
				
				Log.d("Masuk Data Login", json.toString());
				
				int success = json.getInt(TAG_SUCCESS);
				
				if (success == 1) {
					Log.d("Login Sukses !", json.toString());
					Intent i = new Intent(Login.this, ViewData.class);
					finish();
					startActivity(i);
					return json.getString(TAG_SUCCESS);
				} else {
					Log.d("Login Gagal !", json.getString(TAG_SUCCESS));
					return json.getString(TAG_MESSAGE);
				}
				
			} catch (JSONException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			pDialog.dismiss();
		}
	}
	
}
