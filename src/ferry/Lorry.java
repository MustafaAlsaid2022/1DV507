package ferry;

public class Lorry extends Vehicle { //constructor with parameter id//

	public Lorry(int id) {
		super(id); //inherent from the vehicle class//
	}
	@Override
	public final int getEmbarkCost() { //embarking cost for a lorry//
		return 300;
	}
	@Override
	public final int getPassCost(){ //cost for each passenger in a lorry//
		return 15;
	}
	@Override
	public final int getSpace() { //the space of a lorry based on bicycle//
		return 40;
	}
	public final int getMaxPassNumber(){ //number of passengers a lorry can contain//
		return 2;
	}

}
