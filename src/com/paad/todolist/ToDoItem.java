package com.paad.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoItem {
	
	private String task;
	private Date created;
	
	public ToDoItem(String task, Date created) {
		this.task = task;
		this.created = created;
	}

	public ToDoItem(String task) {
		this(task, new Date(java.lang.System.currentTimeMillis()));
	}
		
	public String getTask() {
		return task;
	}
	
	public Date getCreated() {
		return created;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String dateString = sdf.format(created);
		return "(" + dateString + ") " + task;
	}

}
