package priorityqueue;

public interface Task {
	
	
	public void setDescription(String desc); //set task description//
	
	public String getDescription(); //get task description//
	
	public void setPriority(int n); //set task priority//

	public int getPriority(); //get task priority//
	
	public boolean equals(Object t);

	public String toString(); //string representation of task//
	
}
