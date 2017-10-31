package garage;

public class Bus extends Vehicle {
	
	public Bus(int id){
		super(id);
	}
	
	@Override
	public final int getCost() {
		return 100;
	}
	@Override
	public final int getSpace() {
		return 20;
	}


}
