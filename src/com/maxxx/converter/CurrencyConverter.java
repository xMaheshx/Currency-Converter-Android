package com.maxxx.converter;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;


@SuppressLint("ParserError")
public class CurrencyConverter extends Activity implements OnClickListener {
	
	Button buttonSubmit;
	Spinner spinner1, spinner2;
	double GBP,AUD,USD,EUR,LV,FV;
	String F1,F2;
		
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        GBP=84.8493;
        EUR=68.0537;
        AUD=57.6325;
        USD=10.2350;
        
        spinner1 = (Spinner) findViewById(R.id.spinner1);
    	spinner2 = (Spinner) findViewById(R.id.spinner2);
    	buttonSubmit = (Button) findViewById(R.id.button1);
    	buttonSubmit.setOnClickListener(this);
    }
    
  public void assignValueL(){
	  F1=String.valueOf(spinner1.getSelectedItem());
	  F2=String.valueOf(spinner2.getSelectedItem());
	  for(int i=0;i<4;i++){
		  if(F2.equals("USD")){
			  FV=1/USD;}
		if(F2.equals("EUR")){
				  FV=1/EUR;}
		 if(F2.equals("AUD")){
					  FV=1/AUD;}
			if(F2.equals("GBP")){
						  FV=1/GBP;}
						 
		  }
	  for(int i=0;i<4;i++){
		  if(F2.equals("USD")){
			  LV=USD;}
		if(F2.equals("EUR")){
				  LV=EUR;}
		 if(F2.equals("AUD")){
					  LV=AUD;}
			if(F2.equals("GBP")){
						  LV=GBP;}
						 
		  }	  
	  
  }

    public void onClick(View v) {
    	Intent i = new Intent(this, Converter.class);
		assignValueL();
			i.putExtra("Foreign", String.valueOf(spinner1.getSelectedItem()));
			i.putExtra("Local", String.valueOf(spinner2.getSelectedItem()));
			i.putExtra("FVal",LV);
			i.putExtra("LVal",FV);
			startActivity(i);
		
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
