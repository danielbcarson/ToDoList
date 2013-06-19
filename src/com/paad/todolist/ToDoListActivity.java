package com.paad.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class ToDoListActivity extends Activity implements OnNewItemAddedListener{
    
	// list of To Do Items
	private ArrayList<String> todoItems;;
	// list adapter
	private ArrayAdapter<String> aa;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        // create the array list of To Do Items
        todoItems = new ArrayList<String>();
        
        // get reference to the fragment manager
        FragmentManager fm = getFragmentManager();
        
        // get reference to the ToDoListFragment
        ToDoListFragment todoListFragment = 
        		(ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);
               
        // bind the list to the adapter
        aa = new ArrayAdapter<String>(this, 
        		                      android.R.layout.simple_list_item_1, 
        		                      todoItems );
        
        // bind the array adapter to the list view
        todoListFragment.setListAdapter(aa);
        
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do_list, menu);
        return true;
    }


	@Override
	public void onNewItemAdded(String newItem) {
		todoItems.add(0, newItem );
		aa.notifyDataSetChanged();
	}
    
}
