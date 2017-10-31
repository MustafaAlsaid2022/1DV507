package garage;

public abstract class Vehicle {
	
	private int id;
	private int cost;
	private int space;
	
	public Vehicle(int id){
		this.id=id;
		
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public int getCost() {
		return cost;
	}

	public int getSpace() {
		return space;
	}

	

}
