package com.VeryUrban.settlethis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_main);

		    GridView gridview = (GridView) findViewById(R.id.gridview);
		    gridview.setAdapter(new ImageAdapter(this));

		  //for each gridview item, we want one click reaction (that creates a new Activity) and
		  //a long click reaction, that shows an informative text on what this button does
		   
		    //Simple Click Action
		    gridview.setOnItemClickListener(new OnItemClickListener() { 
		        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		            switch (position){
		            case 0: Intent intent = new Intent(MainActivity.this,Reflexes.class);
		            	startActivity(intent);
		            	break;
		            default: 
		            	Toast toast= Toast.makeText(MainActivity.this,"not ready yet,be patient", Toast.LENGTH_SHORT);
		            	toast.show();
		            }
		            	
		            
		        	
		        	
		        }
		    });
		    
		    //Long Click Action
		    gridview.setOnItemLongClickListener(new OnItemLongClickListener(){
		    	public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id){
		    		Toast toast = Toast.makeText(MainActivity.this, testDescriptions[position] ,Toast.LENGTH_LONG);
		    		TextView v1 = (TextView) toast.getView().findViewById(android.R.id.message);
		    		if( v1 != null) v1.setGravity(Gravity.CENTER);
		    		toast.show();
		    		return true;
		    	}
		    });
		    
		    
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//using the returned position, this array returns the proper string for each option
	private Integer[] testDescriptions  = {
    		R.string.reflexes_description,
    		R.string.agility_description,
    		R.string.intellect_description,
    		R.string.strength_description,
    		R.string.proximity_description,
    		R.string.voice_description };
}


