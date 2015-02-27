package com.XeonViper.kangenwater;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PesanActivity extends Activity {
	
	Spinner sp1, sp2, sp3;
	int pos,pos1,pos2, angka1, angka2, hargahasil;
	ArrayAdapter<String> phAdapter, jumlahAdapter, ukuranAdapter;
	ArrayList<String> pH, ukuran, jumlah;
	TextView ukur, harga, hasil, validasijumlah;
	EditText nama, alamat, validasiproduk, validasiukuran, validasiharga, validasitotharga, validasinomor;
	Button kirimPesanan;
	
	private ProgressDialog pDialog;
	
	JSONParser jsonParser = new JSONParser();
	
	private static String url_tambah_pesanan = "http://192.168.1.23/Kangen/create_pesanan.php";
	
	private static final String TAG_SUCCESS = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pesan);
		
		sp1 = (Spinner) findViewById(R.id.spinner1);
		sp2 = (Spinner) findViewById(R.id.spinner2);
		sp3 = (Spinner) findViewById(R.id.spinner3);
		ukur = (TextView) findViewById(R.id.textView4);
		harga = (TextView) findViewById(R.id.textView6);
		hasil = (TextView) findViewById(R.id.textView10);
		nama = (EditText) findViewById(R.id.editText1);
		alamat = (EditText) findViewById(R.id.editText2);
		validasijumlah = (EditText) findViewById(R.id.validasijumlah);
		validasiproduk = (EditText) findViewById(R.id.editText13);
		validasiukuran = (EditText) findViewById(R.id.editText14);
		validasiharga = (EditText) findViewById(R.id.validasiharga);
		validasitotharga = (EditText) findViewById(R.id.validasitotharga);
		validasinomor = (EditText) findViewById(R.id.validasinomor);
		kirimPesanan = (Button) findViewById(R.id.button1);
		
		
		pH = new ArrayList<String>();
		
		pH.add("-");
		pH.add("<= 2.7");
		pH.add("4.0-6.0");
		pH.add("8.0-9.5");
		pH.add(">= 11.0");
		
		phAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, pH);
		
		phAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		sp1.setAdapter(phAdapter);
		
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
					
				pos = arg2;
				
				add();
			
			}
			
			private void add() {
				// TODO Auto-generated method stub
				
				switch (pos) {
				case 1:
					
					String test = String.valueOf(sp1.getSelectedItem());
					validasiproduk.setText(test);
					
					ukur.setText("Ukuran (@mili liter(ml))");
					
					ukuran = new ArrayList<String>();
					
					ukuran.add("-");
					ukuran.add("60");
					ukuran.add("100");
					
					ukuranAdapter = new ArrayAdapter<String>(PesanActivity.this, android.R.layout.simple_dropdown_item_1line, ukuran);
					
					sp2.setAdapter(ukuranAdapter);
					
					select1();
					
					break;
					
				case 2:
					
					String test2 = String.valueOf(sp1.getSelectedItem());
					validasiproduk.setText(test2);
					
					ukur.setText("Ukuran (@mili liter(ml))");
					
					ukuran = new ArrayList<String>();
					
					ukuran.add("-");
					ukuran.add("60");
					ukuran.add("100");
					
					ukuranAdapter = new ArrayAdapter<String>(PesanActivity.this, android.R.layout.simple_dropdown_item_1line, ukuran);
					
					sp2.setAdapter(ukuranAdapter);
					
					select2();

					break;
					
				case 3:
					
					String test3 = String.valueOf(sp1.getSelectedItem());
					validasiproduk.setText(test3);
					
					ukur.setText("Ukuran (@liter(l))");
					
					ukuran = new ArrayList<String>();
					
					ukuran.add("-");
					ukuran.add("2");
					ukuran.add("5");
					ukuran.add("10");
					ukuran.add("12");
					
					ukuranAdapter = new ArrayAdapter<String>(PesanActivity.this, android.R.layout.simple_dropdown_item_1line, ukuran);
					
					sp2.setAdapter(ukuranAdapter);
					
					select3();
					
					break;
					
				case 4:
					
					String test4 = String.valueOf(sp1.getSelectedItem());
					validasiproduk.setText(test4);
					
					ukur.setText("Ukuran (@liter(l))");
					
					ukuran = new ArrayList<String>();
					
					ukuran.add("-");
					ukuran.add("2");
					ukuran.add("5");
					
					ukuranAdapter = new ArrayAdapter<String>(PesanActivity.this, android.R.layout.simple_dropdown_item_1line, ukuran);
					
					sp2.setAdapter(ukuranAdapter);
					
					select4();

					break;
				}
			}
			
			private void select1() {
				// TODO Auto-generated method stub
				
				sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
					
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					        pos1 = arg2;
					        
					        add1();
					}
					
					private void add1() {
						// TODO Auto-generated method stub
						
						switch (pos1) {
						case 1:
							String test1 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test1);
							validasiharga.setText("25000");
							harga.setText("25000");
							break;

						case 2:
							String test5 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test5);
							validasiharga.setText("35000");
							harga.setText("35000");
							break;
						}
					}
	 
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
							
					}
				});
			}
			
			private void select2() {
				// TODO Auto-generated method stub
				
				sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
					
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					        pos1 = arg2;
					        
					        add1();
					}
					
					private void add1() {
						// TODO Auto-generated method stub
						
						switch (pos1) {
						case 1:
							String test1 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test1);
							validasiharga.setText("20000");
							harga.setText("20000");
							break;

						case 2:
							String test2 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test2);
							validasiharga.setText("30000");
							harga.setText("30000");
							break;
						}
					}
	 
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
							
					}
				});
			}
			
			private void select3() {
				// TODO Auto-generated method stub
				
				sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
					
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					        pos1 = arg2;
					        
					        add1();
					}
					
					private void add1() {
						// TODO Auto-generated method stub
						
						switch (pos1) {
						case 1:
							String test1 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test1);
							validasiharga.setText("15000");
							harga.setText("15000");
							break;

						case 2:
							String test2 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test2);
							validasiharga.setText("35000");
							harga.setText("35000");
							break;
							
						case 3:
							String test3 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test3);
							validasiharga.setText("65000");
							harga.setText("65000");
							break;
							
						case 4:
							String test4 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test4);
							validasiharga.setText("71000");
							harga.setText("71000");
							break;
						}
					}
	 
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
							
					}
				});
			}
			
			private void select4() {
				// TODO Auto-generated method stub
				
				sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
					
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

					        pos1 = arg2;
					        
					        add1();
					}
					
					private void add1() {
						// TODO Auto-generated method stub
						
						switch (pos1) {
						case 1:
							String test1 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test1);
							validasiharga.setText("35000");
							harga.setText("35000");
							break;

						case 2:
							String test2 = String.valueOf(sp2.getSelectedItem());
							validasiukuran.setText(test2);
							validasiharga.setText("75000");
							harga.setText("75000");
							break;
						}
					}
	 
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
							
					}
				});
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		jumlah = new ArrayList<String>();
		
		jumlah.add("-");
		jumlah.add("1");
		jumlah.add("2");
		jumlah.add("3");
		jumlah.add("4");
		jumlah.add("5");
		jumlah.add("6");
		jumlah.add("7");
		jumlah.add("8");
		jumlah.add("9");
		jumlah.add("10");
		
		jumlahAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, jumlah);
		
		jumlahAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		sp3.setAdapter(jumlahAdapter);
		
		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				pos2 = arg2;
				
				add2();
			}
			
			private void add2() {
				// TODO Auto-generated method stub
				
				switch (pos2) {
				case 1:
					validasijumlah.setText("1");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;

				case 2:
					validasijumlah.setText("2");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 3:
					validasijumlah.setText("3");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 4:
					validasijumlah.setText("4");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 5:
					validasijumlah.setText("5");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 6:
					validasijumlah.setText("6");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 7:
					validasijumlah.setText("7");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 8:
					validasijumlah.setText("8");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 9:
					validasijumlah.setText("9");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
					
				case 10:
					validasijumlah.setText("10");
					angka1 = Integer.parseInt(harga.getText().toString());
					angka2 = Integer.parseInt(validasijumlah.getText().toString());
					
					kali();
					break;
				}
			}
			
			public void kali() {
				hargahasil = angka1 * angka2;
				hasil.setText(Integer.toString(hargahasil));
				validasitotharga.setText(Integer.toString(hargahasil));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		kirimPesanan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				String noTelp = validasinomor.getText().toString();
				
				String pesan = "Saya " + nama.getText().toString() + " alamat "
				+ alamat.getText().toString() + " ingin air berpH "
					+ validasiproduk.getText().toString()
					+ " ukuran "
					+ validasiukuran.getText().toString()
					+ " ml/l"
					+ " sebanyak "
					+ validasijumlah.getText().toString();
					
					
				if (nama.length()>0 && alamat.length()>0 && pesan.length()>0 && validasiproduk.length()>0 && validasiukuran.length()>0 && validasiharga.length()>0 && validasitotharga.length()>0 && validasijumlah.length()>0) {
					KirimSMS(noTelp, pesan);
					new CreatePesanan().execute();
				} else {
					Toast.makeText(getBaseContext(), "Silahkan isi data terlebih dahulu", Toast.LENGTH_SHORT).show();
					return;
				}
			}
		});
		
	}
	
	private void KirimSMS(String noTelp, String pesan) {
		String SENT = "SMS_SENT";
		String DELIVERED = "SMS_DELIVERED";
		
		PendingIntent sendPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
		PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);
		
		registerReceiver(new BroadcastReceiver() {
						
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS terkirim", Toast.LENGTH_SHORT).show();
					break;
					
				case android.telephony.SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(getBaseContext(), "error", Toast.LENGTH_SHORT).show();
					break;
				
				case android.telephony.SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getBaseContext(), "Tidak Ada Sinyal", Toast.LENGTH_SHORT).show();
					break;
				
				case android.telephony.SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
					break;
					
				case android.telephony.SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(getBaseContext(), "GSM Mati", Toast.LENGTH_SHORT).show();
					break;
			
				}
			}
		}, new IntentFilter(SENT));
	
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS delivered", Toast.LENGTH_SHORT).show();
					break;
					
				case Activity.RESULT_CANCELED:
					Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_SHORT).show();
					break;
							
				}
			}
		}, new IntentFilter(DELIVERED));
		
		android.telephony.SmsManager sms = android.telephony.SmsManager.getDefault();
		sms.sendTextMessage(noTelp, null, pesan, sendPI, deliveredPI);
	}
	
	class CreatePesanan extends AsyncTask<String, String, String> {
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			pDialog = new ProgressDialog(PesanActivity.this);
			pDialog.setMessage("Sedang memesan...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			String nama_pemesan = nama.getText().toString();
			String address = alamat.getText().toString();
			String product = validasiproduk.getText().toString();
			String size = validasiukuran.getText().toString();
			String price = validasiharga.getText().toString();
			String quantity = validasijumlah.getText().toString();
			String totprice = validasitotharga.getText().toString();
			
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("nama_pemesan", nama_pemesan));
			param.add(new BasicNameValuePair("alamat", address));
			param.add(new BasicNameValuePair("nama_produk", product));
			param.add(new BasicNameValuePair("ukuran", size));
			param.add(new BasicNameValuePair("harga", price));
			param.add(new BasicNameValuePair("jumlah", quantity));
			param.add(new BasicNameValuePair("total_harga", totprice));
			
			JSONObject json = jsonParser.makeHTTPRequest(url_tambah_pesanan, "POST", param);
			
			Log.d("Create Response", json.toString());
			
			try {
				int success = json.getInt(TAG_SUCCESS);
				
				if (success == 1) {
					Intent pindah = new Intent(PesanActivity.this, BerandaActivity.class);
					finish();
					startActivity(pindah);
				}
			} catch (JSONException e) {
				// TODO: handle exception
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String file_url) {
			// TODO Auto-generated method stub
			pDialog.dismiss();
		}
		
	}
	
}
