package com.example.database2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Final_Info extends Activity {
	
	ListView lv;
	ArrayAdapter<String> adapter;
	EditText inputSearch;
	 String[] products={ "apurbo" ,"mithun","limit ", "rasel","rajib","baized","waliul","opu","shuruj","chanda","kalam","provash","jony"};
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final__info);
		
		lv=(ListView) findViewById(R.id.list);
		inputSearch=(EditText) findViewById(R.id.searchedit);
		adapter=new ArrayAdapter<String>(this, R.layout.list_item,R.id.textView1,products);
		   lv.setAdapter(adapter);
		   
		   lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent=new Intent(Final_Info.this,Lastactivity.class);
				Toast.makeText(getApplicationContext(), "Selected Item: index: "+position+" item name: "+products[position], Toast.LENGTH_LONG).show();
				intent.putExtra("some", adapter.getItem(position));
					startActivity(intent);
				
			}
		});
		   
		   inputSearch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
				 Final_Info.this.adapter.getFilter().filter(cs);
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final__info, menu);
		return true;
	}

}
