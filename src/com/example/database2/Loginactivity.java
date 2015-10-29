package com.example.database2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Loginactivity extends Activity {
	Button delete, update;
	int status = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loginactivity);
		
		final Button registration=(Button)findViewById(R.id.button2);
		final Button login=(Button)findViewById(R.id.button1);
		delete=(Button) findViewById(R.id.update);
		update=(Button) findViewById(R.id.delete);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				status = 1;
				Bundle b = new Bundle();
				b.putInt("status", status);
				Intent i = new Intent(Loginactivity.this,Logtimeactivity.class);
				i.putExtras(b);
				startActivity(i);
				
			}
		});
		registration.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Loginactivity.this,Register_activity.class);
				startActivity(intent);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loginactivity, menu);
		return true;
	}

}
