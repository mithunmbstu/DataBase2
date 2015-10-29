package com.example.database2;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Logtimeactivity extends Activity {
	Button btn;
	EditText et1, et2;
	String username, userpass;
	Context CTX = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logtimeactivity);
		btn=(Button) findViewById(R.id.logintime);
		et1=(EditText) findViewById(R.id.name);
		et2=(EditText) findViewById(R.id.pass);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Bundle b = getIntent().getExtras();
				int status =b.getInt("status");
				if(status == 1)
				{
					Toast.makeText(getBaseContext(), "Please wait......", Toast.LENGTH_LONG).show();
					username = et1.getText().toString();
					userpass = et2.getText().toString();
					DatabaseOperations DOP = new DatabaseOperations(CTX);
					Cursor CR = DOP.getInformation(DOP);
					CR.moveToFirst();
					boolean loginstatus = false;
					String NAME = "";
					//Toast.makeText(CTX, username+"..."+userpass+"..."+CR.getString(0)+"..."+CR.getString(1), Toast.LENGTH_LONG).show();
					do
					{
						if(username.equals(CR.getString(0))&&(userpass.equals(CR.getString(1))))
						{
							
							loginstatus = true;
							NAME = CR.getString(0);
						}
					}while(CR.moveToNext());
					if(loginstatus)
					{
						//Toast.makeText(getBaseContext(), "log-in success-----\n Welcome" +NAME, Toast.LENGTH_LONG).show();
						Intent intent=new Intent(Logtimeactivity.this,Final_Info.class);
						startActivity(intent);
						
					}
					else {
						Toast.makeText(getBaseContext(), "login failes.........", Toast.LENGTH_LONG).show();
						finish();
					}
					
				}
				else if(status == 2)
				{
					Intent i = new Intent("update_filter");
					startActivity(i);
				}
				else if(status == 3)
				{
					Intent i = new Intent("delete_filter");
					startActivity(i);
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logtimeactivity, menu);
		return true;
	}

}
