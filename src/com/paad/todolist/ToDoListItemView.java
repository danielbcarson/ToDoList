package com.paad.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Custom TextView class
 * @author danielbcarson
 *
 */
public class ToDoListItemView extends TextView {
	
	private Paint marginPaint;
	private Paint linePaint;
	private int paperColor;
	private float margin;
	
	public ToDoListItemView(Context context)
	{
		super( context );
		init();
	}
	
	public ToDoListItemView(Context context, AttributeSet ats)
	{
		super( context, ats );
		init();
	}
	
	public ToDoListItemView(Context context, AttributeSet attrs, int ds )
	{
		super( context, attrs, ds );
		init();
	}

	private void init() 
	{
		// get reference to XML resources
		Resources myResources = getResources();
		
		// create the paint brushes we will use in the onDraw method
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(myResources.getColor(R.color.notepad_lines));
		
		// get the paper background color and the margin width
		paperColor = myResources.getColor(R.color.notepad_paper);
		margin = myResources.getDimension(R.dimen.notepad_margin);  
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// Color as paper
		canvas.drawColor(paperColor);
		
		// draw the ruled lines
		canvas.drawLine(0,  0, 0, getMeasuredHeight(), linePaint);
		canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), 
				getMeasuredHeight(), linePaint);
		
		// draw margin
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), linePaint);
		
		// move the text across the margin
		canvas.save();
		canvas.translate(margin, 0);
		
		// use the TextView to render the text
		super.onDraw(canvas);
		canvas.restore();
	}
	
	
}
