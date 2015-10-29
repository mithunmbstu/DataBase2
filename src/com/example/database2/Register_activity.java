package com.example.database2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_activity extends Activity {

	EditText USER_NAME, USER_PASS, CON_PASS;
	String user_name,user_pass,con_pass;
	Button button;
	Context ctx=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_activity);
		USER_NAME=(EditText) findViewById(R.id.editText1);
		USER_PASS=(EditText) findViewById(R.id.editText2);
		CON_PASS=(EditText) findViewById(R.id.editText3);
		button=(Button) findViewById(R.id.user_reg);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				user_name = USER_NAME.getText().toString();
				user_pass = USER_PASS.getText().toString();
				con_pass = CON_PASS.getText().toString();
				
				if(!(user_pass.equals(con_pass)))
				{
					Toast.makeText(getBaseContext(), "Password are not matching", Toast.LENGTH_LONG).show();
					USER_NAME.setText("");
					USER_PASS.setText("");
					CON_PASS.setText("");
				}
				else
				{
					DatabaseOperations DB = new DatabaseOperations(ctx);
					
					DB.putInformation(DB, user_name, user_pass);
					Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
					finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register_activity, menu);
		return true;
	}

}
