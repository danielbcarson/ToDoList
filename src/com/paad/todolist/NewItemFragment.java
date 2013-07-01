package com.paad.todolist;

// support library using fragments on API Level < 11 targets
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class NewItemFragment extends Fragment {
	private OnNewItemAddedListener onNewItemAddedListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.new_item_fragment, container, false);
		
		// get reference to the EditText field, note use of view.xxx to get
		// the reference
        final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);

        // attach a hey listener to the EditText control
        myEditText.setOnKeyListener( new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				
				if ( event.getAction() == KeyEvent.ACTION_DOWN) 
				{
					if ( ( keyCode == KeyEvent.KEYCODE_DPAD_DOWN ) || 
						 ( keyCode == KeyEvent.KEYCODE_ENTER)	)
					{   
						onNewItemAddedListener.onNewItemAdded( 
								new ToDoItem(myEditText.getText().toString()));
						myEditText.setText("");   
						return true;
					}
				}
				return false;
			}
		});
        
        return view;

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		// make sure parent activity implements the OnNewItemAddedListener interface
		try {
			onNewItemAddedListener = (OnNewItemAddedListener)activity; 
			
		}  catch (ClassCastException e ) {
			throw new ClassCastException(activity.toString() + 
					" must implement OnNewItemAddedListener");
		}
	}
	
}
