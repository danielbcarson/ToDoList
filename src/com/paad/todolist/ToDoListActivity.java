package com.paad.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class ToDoListActivity extends Activity implements OnNewItemAddedListener{
    
	// list of To Do Items
	private ArrayList<ToDoItem> todoItems;
	// custom list adapter
	private ToDoItemAdapter aa;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        // create the array list of To Do Items
        todoItems = new ArrayList<ToDoItem>();
        
        // get reference to the fragment manager
        FragmentManager fm = getFragmentManager();
        
        // get reference to the ToDoListFragment
        ToDoListFragment todoListFragment = 
        		(ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);
        
        int resID = R.layout.todolist_item;
        
        // bind the list to the adapter
        aa = new ToDoItemAdapter(this, 
        		                 resID, 
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
	public void onNewItemAdded(ToDoItem newItem) {
		todoItems.add(0, newItem );
		aa.notifyDataSetChanged();
	}
    
}
