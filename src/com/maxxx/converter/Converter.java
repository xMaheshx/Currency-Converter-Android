package com.maxxx.converter;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class Converter extends Activity implements OnClickListener {
	
	Button buttonForeign;
	Button buttonLocal;
	EditText editIn;
	TextView textView1;
	double input,result,ForeignV,LocalV;
	String x,Foreign,Local;
	 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        
        
        buttonForeign=(Button)findViewById(R.id.buttonForeign);
        buttonLocal=(Button)findViewById(R.id.buttonRupee);
        editIn=(EditText)findViewById(R.id.editIn);
        textView1=(TextView)findViewById(R.id.textView1);
        
        Bundle extras = getIntent().getExtras(); 
        if(extras !=null)
        {
         Foreign = extras.getString("Foreign");
         Local = extras.getString("Local");
         ForeignV=extras.getDouble("FVal");
         LocalV=extras.getDouble("LVal");
        }
        
        buttonForeign.setText("Convert to "+Foreign);
        buttonLocal.setText("Convert to "+Local);
        
        buttonForeign.setOnClickListener(this);
        buttonLocal.setOnClickListener(this);
               
	}
	

	public void onClick(View v) {
		x=editIn.getText().toString();
		if(x.equals(""))
			{}
		else{
			input=Double.parseDouble(x);
			DecimalFormat df2 = new DecimalFormat("###.##");
			
					switch(v.getId())
					{
					case R.id.buttonForeign:				
						result=Double.valueOf(df2.format(input*ForeignV));
						textView1.setText(input+" "+Local+" = "+result+" "+Foreign);
						break;
					case R.id.buttonRupee:
						result=Double.valueOf(df2.format(input*LocalV));
						textView1.setText(input+" "+Foreign+" = "+result+" "+Local);
						break;
					
			}
		}	
		
	}

	
	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_main, menu);
	        return true;
	    }
	  
	  @Override
	public boolean onOptionsItemSelected(MenuItem item){ 
		  switch (item.getItemId()){
		  case R.id.menu_settings:
			  break;
		  case R.id.item1:
			  startActivity(new Intent(this, About.class));
			  return true;
		  }
		  
		  
		  return false;
	  }
}
