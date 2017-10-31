package garage;

public class Lorry extends Vehicle{
	
	public Lorry(int id){
		super(id);
	}
	
	@Override
	public final int getCost() {
		return 300;
	}
	@Override
	public final int getSpace() {
		return 40;
	}


}
