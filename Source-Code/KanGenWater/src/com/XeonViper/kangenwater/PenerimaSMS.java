package com.XeonViper.kangenwater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class PenerimaSMS  extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
		
		SmsMessage[] msgs = null;
		
		String str = "";
		
		if (bundle != null) {
			Object[] penerima = (Object[]) bundle.get("penerima");
			
			msgs = new SmsMessage[penerima.length];
			for (int i = 0; i < msgs.length; i++) {
				msgs[i] = SmsMessage.createFromPdu((byte[])penerima[i]);
				
				str += "SMS dari " + msgs[i].getOriginatingAddress();
				str += " :";
				str += msgs[i].getMessageBody().toString();
				str += "\n";
			}
			
			Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
		}
	}

}
