package com.paad.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // get references to UI Widgets
        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);
        
        // array list for To Do Item strings
        final ArrayList<String> todoItems = new ArrayList<String>();
        
        // list adapter
        final ArrayAdapter<String> aa;
        
        // bind the list to the adapter
        aa = new ArrayAdapter<String>(this, 
        		                      android.R.layout.simple_list_item_1, 
        		                      todoItems );
        
        // bind the array adapter to the list view
        myListView.setAdapter(aa);
        
        // attach a hey listener to the EditText control
        myEditText.setOnKeyListener( new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				
				if ( event.getAction() == KeyEvent.ACTION_DOWN) 
				{
					if ( ( keyCode == KeyEvent.KEYCODE_DPAD_DOWN ) || 
						 ( keyCode == KeyEvent.KEYCODE_ENTER)	)
					{
						todoItems.add(0, myEditText.getText().toString() );
						aa.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do_list, menu);
        return true;
    }
    
}
