package ferry;

public class Bicycle extends Vehicle {

	public Bicycle(int id) {  //constructor with parameter id//
		super(id); //inherent from the vehicle class//
		
	}
	@Override
	public final int getEmbarkCost() {  //embarking cost for a bicycle//
		return 20;
	}
	@Override
	public final int getPassCost(){ //cost for each passenger in a bicycle//
		return 20;
	}
	@Override
	public final int getSpace() { //the space of a bicycle based on bicycle//
		return 1;
	}
	public final int getMaxPassNumber(){ //number of passengers a bicycle can contain//
		return 1;
	}


}
