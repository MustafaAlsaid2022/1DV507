package ferry;

public class Car extends Vehicle {

	public Car(int id) { // constructor with parameter id//
		super(id); //inherent from the vehicle class//
		
	}
	
	@Override
	public final int getEmbarkCost() { //embarking cost for a car//
		return 100;
	}
	@Override
	public final int getPassCost(){ //cost for each passenger in the car//
		return 15;
	}
	@Override
	public final int getSpace() { //the space of car based on bicycle//
		return 5;
	}
	public final int getMaxPassNumber(){ //number of passengers a car can contain//
		return 4;
	}


}
