package garage;

public class Bicycle extends Vehicle {
	
	public Bicycle(int id){
		super(id);
	}
    
	@Override
	public final int getCost() {
		return 10;
	}
	@Override
	public final int getSpace() {
		return 1;
	}

}
