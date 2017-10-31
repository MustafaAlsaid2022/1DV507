package ferry;

public class Bus extends Vehicle {

	public Bus(int id) { //constructor with parameter id//
		super(id); //inherent from the vehicle class//
	}

	
	@Override
	public final int getEmbarkCost() { //embarking cost for a bus//
		return 200;
	}
	@Override
	public final int getPassCost(){ //cost for each passenger in a bus//
		return 10; 
	}
	@Override
	public final int getSpace() { //the space of a bus based on bicycle//
		return 20;
	}
	public final int getMaxPassNumber(){ //number of passengers a bus can contain//
		return 20;
	}

}
