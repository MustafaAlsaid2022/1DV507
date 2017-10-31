package priorityqueue;

public class WorkTask implements Task{
	
	//fields//
	private int priority=0;
	private String description="";
	
	public WorkTask(int n,String d){ //update priority and description//
		setPriority(n);
		setDescription(d);
	}
	
	public String toString(){ //string representation of a task//
		return "("+getPriority()+","+getDescription()+")";
	}

	@Override
	public void setDescription(String d) { //update description of a task//
		description=d;
		
	}

	@Override
	public String getDescription() { //return description of a task//
		
		return description;
	}

	@Override
	public void setPriority(int n) { //update priority of a task//
		
		if (check(n)) {
			
			priority = n;
		}
	}

	@Override
	public int getPriority() { //return priority of a task//
		
		return priority;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WorkTask) {
			Task other = (WorkTask) obj;
			return priority == other.getPriority() && description.equals(other.getDescription());
		}
		return false;
	}
	
	private boolean check(int n) { /*check priority value*/
		if (n<=0) {
			throw new IllegalArgumentException("The priority has an invalid value");
		
		}
		return true;
	}

}
