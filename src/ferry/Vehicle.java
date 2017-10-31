package ferry;

public abstract class Vehicle {

	private int id; //id for each vehicle//
	private int totalVPassNumber=0; //number of passengers in a vehicle//
	private int maxPassNumber; //max number of passengers for a vehicle//
	private int embarkCost=0; //the cost of embarking a vehicle on the ferry//
	private int vehiclePassCost=0; //cost for each passenger in a vehicle//
	private int space=0; //the space for each vehicle//

	public Vehicle(int id) { //constructor has id parameter//
		this.id = id;
		
	}

	public void setId(int id) { //set id//
		this.id = id;

	}

	public int getId() { //return id//
		return id;
	}

	public int getTotalVPassNumber() { //return number of passengers in a vehicle//
		return totalVPassNumber;
	}
	
	public int getMaxPassNumber(){ //return max number of passengers for a vehicle//
		return maxPassNumber;
	}
	public int getEmbarkCost(){ //return the cost of embarking a vehicle on the ferry//
		return embarkCost;
	}
	public int getPassCost(){ //cost for each passenger in a vehicle//
		return vehiclePassCost;
	}
	public int getSpace(){ //return the space for each vehicle//
		return space;
	}
	
	public void addPasenger(){ //add passenger to a vehicle//
		if(getMaxPassNumber()>getTotalVPassNumber()){ //if a vehicle has a room for a passenger we add him//
			totalVPassNumber++;
		}
		else{ //if no room we can not add the passenger//
			System.err.println("The vehicle ID "+id+ " can not hold more passengers");
			System.out.println();
		}
	}

}
