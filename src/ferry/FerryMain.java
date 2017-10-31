package ferry;

public class FerryMain {

	public static void main(String[] args) {
		ImpFerry ferry=new ImpFerry(); // object of impferry//
		Vehicle car=new Car(1);  //vehicle of type car//
		Vehicle bicycle=new Bicycle(2); //vehicle of type bicycle//
		Vehicle bus=new Bus(200); //vehicle of type bus//
		Vehicle lorry=new Lorry(621); //vehicle of type lorry//
		Vehicle c=new Car(4); //vehicle of type car//
		
		bicycle.addPasenger(); //add a passenger to bicycle//
		bicycle.addPasenger(); //add a passenger to the same bicycle//
		ferry.embark(bicycle); //embark the bicycle//
		car.addPasenger(); //add a passenger to car//
		ferry.embark(car);  //embark the car//
		
		System.out.println("number of vehicles after embarking is "+ferry.onVehicleList.size());
		System.out.println("number of passengers after embarking is "+ferry.countPassengers());
		
		ferry.embark(bicycle);// can not be embarked twice//
		ferry.embark(bus); // can not be embarked twice//
		ferry.embark(c);  //embark a car//
		ferry.embark(lorry);  //embark a lorry//
		
		System.out.println("number of vehicles after embarking is "+ferry.onVehicleList.size());
		System.out.println("number of passengers after embarking is "+ferry.countPassengers());
		System.out.println("cash money received: "+ferry.countMoney()+" kr");
		
		Passenger passenger=new Passenger(); //passenger object//
		ferry.embark(passenger); // embark the passenger//
		
		System.out.println("number of passengers after embarking is "+ferry.countPassengers());
		System.out.println("cash money received: "+ferry.countMoney()+" kr");
		if(ferry.hasRoomFor(passenger)){ //check if there is room for another passenger//
			System.out.println("There is room for another passenger in ferry");
		}
		else{
			System.out.println("There is no room for another passenger in ferry");
		}
		if(ferry.hasSpaceFor(car)){ //check if there is room for another car//
			System.out.println("There is space for another car in ferry");
		}
		else{
			System.out.println("There is no space for another car in ferry");
		}
		System.out.println(ferry.toString());
		ferry.disembark(); //disembark vehicles and passengers//
		System.out.println(ferry.toString()); 
		
	}

}
