package com.example.database2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Lastactivity extends Activity {
	
	TextView txt, txt1,txt2,txt3,txt4,txt5;
	String q;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lastactivity);
		txt=(TextView) findViewById(R.id.textView1);
		txt1=(TextView) findViewById(R.id.textView2);
		txt2=(TextView) findViewById(R.id.textView3);
		txt3=(TextView) findViewById(R.id.textView4);
		txt4=(TextView) findViewById(R.id.textView5);
		txt5=(TextView) findViewById(R.id.textView6);
		
		Intent intent=getIntent();
		q=intent.getStringExtra("aaa");
		txt.setText(q);
		
		if (q.equals("apurbo")) {
			txt1.setText("Full Name: Apurbo Saha");
			
			txt2.setText("ID: CE-11003");
			
			txt3.setText("CGPA: 3.50");
			
			txt4.setText("Mobile No: 01950850745");
			
			txt5.setText("email: apurbo.mbstu@gmail.com");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lastactivity, menu);
		return true;
	}

}
