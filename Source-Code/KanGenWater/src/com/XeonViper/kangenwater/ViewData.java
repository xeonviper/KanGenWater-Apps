package com.XeonViper.kangenwater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class ViewData extends ListActivity {
	
	private ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	
	ArrayList<HashMap<String, String>> pemesananList;
	
	private static String url_semua_pesanan = "http://192.168.1.23/Kangen/get_all_pesanan.php";
	
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_ID = "id";
	private static final String TAG_PESANAN = "pesanan";
	private static final String TAG_PEMESAN = "nama_pemesan";
	private static final String TAG_ALAMAT = "alamat";
	private static final String TAG_PRODUK = "nama_produk";
	private static final String TAG_UKURAN = "ukuran";
	private static final String TAG_HARGA = "harga";
	private static final String TAG_JUMLAH = "jumlah";
	private static final String TAG_TOTAL = "total_harga";
	private static final String TAG_TANGGAL = "created_at";
	JSONArray pesanan = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_data);
		
		pemesananList = new ArrayList<HashMap<String,String>>();
		
		new LoadSemuaPemesanan().execute();
		
	}
	
	class LoadSemuaPemesanan extends  AsyncTask<String, String, String> {
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(ViewData.this);
			pDialog.setMessage("Mohon Tunggu . . .");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			JSONObject json = jsonParser.makeHTTPRequest(url_semua_pesanan, "GET", param);
			Log.d("Semua Pemesanan :", json.toString());
			
			try {
				int success = json.getInt(TAG_SUCCESS);
				
				if (success == 1) {
					pesanan = json.getJSONArray(TAG_PESANAN);
					
					for (int i = 0; i < pesanan.length(); i++) {
						JSONObject c = pesanan.getJSONObject(i);
						
						String id = c.getString(TAG_ID);
						String nama_pemesan = c.getString(TAG_PEMESAN);
						String alamat = c.getString(TAG_ALAMAT);
						String produk = c.getString(TAG_PRODUK);
						String ukuran = c.getString(TAG_UKURAN);
						String harga = c.getString(TAG_HARGA);
						String jumlah = c.getString(TAG_JUMLAH);
						String total_harga = c.getString(TAG_TOTAL);
						String created_at = c.getString(TAG_TANGGAL);
						
						HashMap<String, String> map = new HashMap<String, String>();
						
						map.put(TAG_ID, id);
						map.put(TAG_PEMESAN, nama_pemesan);
						map.put(TAG_ALAMAT, alamat);
						map.put(TAG_PRODUK, produk);
						map.put(TAG_UKURAN, ukuran);
						map.put(TAG_HARGA, harga);
						map.put(TAG_JUMLAH, jumlah);
						map.put(TAG_TOTAL, total_harga);
						map.put(TAG_TANGGAL, created_at);
						
						pemesananList.add(map);
					}
				} else {
					Intent i = new Intent(getApplicationContext(), Login.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					finish();
				}
			} catch (JSONException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String file_url) {
			// TODO Auto-generated method stub
			pDialog.dismiss();
			
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ListAdapter adapter = new SimpleAdapter(ViewData.this, pemesananList, R.layout.list_pemesanan, new String[] {TAG_ID, TAG_PEMESAN, TAG_ALAMAT, TAG_PRODUK, TAG_UKURAN, TAG_HARGA, TAG_JUMLAH, TAG_TOTAL, TAG_TANGGAL}, new int[] {R.id.textId, R.id.textpemesan, R.id.textalamat, R.id.textproduk, R.id.textukuran, R.id.textharga, R.id.textjumlah, R.id.texttotal, R.id.tanggalpemesanan});
					
					setListAdapter(adapter);
				}
			});
		}
	}

}
