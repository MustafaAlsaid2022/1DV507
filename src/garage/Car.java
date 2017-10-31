package garage;

public class Car extends Vehicle {
	
	public Car(int id){
		super(id);
	}
	@Override
	public final int getCost() {
		return 50;
	}
	@Override
	public final int getSpace() {
		return 5;
	}

	
	
	

}
