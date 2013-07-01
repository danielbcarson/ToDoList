package com.paad.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToDoItemAdapter extends ArrayAdapter<ToDoItem> {
	
	private int resourceId;

	public ToDoItemAdapter(Context context, int viewResourceId,
			List<ToDoItem> items) {
		super(context, viewResourceId, items);
		this.resourceId = viewResourceId;
	}

	@Override
	/*
	 * The getView method is used to construct, inflate, and populate the 
	 * View that will be added to the parent Adapter View class (List View 
	 * in this case) which is being bound to the underlying array using
	 * this Adapter.  The getView method receives parameters that describe
	 * the position of the item to be displayed, the View being updated 
	 * (or null), and the View Group into which the new View will be placed.
	 * A call to getItem (which can be overridden) will return the value
	 * stored at the specified index in the underlying array.
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// get the ToDoItem for this position and associated fields
		ToDoItem item = getItem(position);
		String taskString = item.getTask();
		Date createdDate = item.getCreated();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String dateString = sdf.format(createdDate);
		
		// create and inflate the View to display
		LinearLayout todoView;
		
		if (convertView == null) {
			// inflate a new view if this is not an update
			todoView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater li = 
					(LayoutInflater)getContext().getSystemService(inflater);
			li.inflate(resourceId, todoView, true);
			
		} else {
			todoView = (LinearLayout)convertView;
		}
		
		// populate the view fields
		TextView dateView = (TextView)todoView.findViewById(R.id.rowDate);
		TextView taskView = (TextView)todoView.findViewById(R.id.row);
		
		dateView.setText(dateString);
		taskView.setText(taskString);
		
		return todoView;
	}
	
	

}
