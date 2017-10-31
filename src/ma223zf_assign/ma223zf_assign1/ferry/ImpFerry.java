package ferry;

import java.util.ArrayList;
import java.util.Iterator;


public class ImpFerry implements Ferry {

	private final int maxPassNumber = 200; //number of passengers can the ferry contain//
	private final int maxVehicleSpace = 200; //number of vehicles can the ferry contain//
	private final int passengerCost = 20; // the cost for each passenger to be on ferry//
    private int money=0; //initial value for the sum of money//
	ArrayList<Vehicle> onVehicleList = new ArrayList<Vehicle>(); //array list for the vehicles on the ferry// 
	ArrayList<Passenger> onPassengerList = new ArrayList<Passenger>(); //array list for the passengers on the ferry//
	 

	@Override
	public String toString() { //string representation//
		return "The ferry has" + " " + countPassengers() + " passenger(s), " + onVehicleList.size() + " vihecle(s) and "
				+ countMoney() + " kr";
	}

	@Override
	public int countPassengers() { //total number of passengers on the board//
		int sum = 0;
		for (int i = 0; i < onVehicleList.size(); i++) {
			sum += onVehicleList.get(i).getTotalVPassNumber();
		}
		for (int i = 0; i < onPassengerList.size(); i++) {
			sum += onPassengerList.get(i).getPassengerNumber();
		}
		return sum;

	}

	@Override
	public int countVehicleSpace() { /*Used vehicle space. I calculated it based bicycle space instead of a car space 
	because if I calculate it based on car I will lose space is enough for a bicycle or more but not for a car*/
		int sum = 0;
		for (int i = 0; i < onVehicleList.size(); i++) {
			sum += onVehicleList.get(i).getSpace();
		}
		return sum;

	}



	
	@Override

	public int countMoney() { //sum of money//
	
		return money;
	}

	@Override
	public Iterator<Vehicle> iterator() { // iterate over arraylist of type vehicle//
		Iterator<Vehicle> it = onVehicleList.iterator();
		while (it.hasNext()) { 
			Vehicle vehicle = it.next();
			System.out.println(vehicle);
		}
		return it;
	}

	@Override
	public void embark(Vehicle v) { //this method for embarking a vehicle//
		if (!exist(v) && hasSpaceFor(v)) { //check if there is enough space and if the vehocle is not exist on the ferry//
			onVehicleList.add(v); // after checking we embark a vehicle//
			money+=v.getTotalVPassNumber()*v.getPassCost(); //sum of money//
			money+=v.getEmbarkCost();
			
		} else { //if a vehicle can not be embarked//
			System.out.println("can not be emabarked a vehicle");
		}
	}

	@Override
	public void embark(Passenger p) { //embark a passenger on the ferry//
		if (hasRoomFor(p)) { //check if there is room//
			onPassengerList.add(p); //embark a passenger after checking//
			money+=p.getPassengerNumber()*passengerCost; //sum of money//
		} else {
			System.out.println("There is no room for a passenger");
		}

	}

	@Override
	public void disembark() { //disembark vehicles and passengers//
		onVehicleList.clear();
		onPassengerList.clear();

	}

	@Override
	public boolean hasSpaceFor(Vehicle v) { //check if there is a space for a specific vehicle//
		if (maxVehicleSpace - countVehicleSpace() >= v.getSpace()) {//check//
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRoomFor(Passenger p) { //check if there is room for a passenger on the ferry//

		int sum = 0;
		for (int i = 0; i < onPassengerList.size(); i++) {//calculate how many passengers on the ferry but not who is in a vehicle//
			sum += onPassengerList.get(i).getPassengerNumber();
		}
		if (sum < maxPassNumber) { //if the sum less than 200//
			return true; //there is room//
		}
		return false; //there is no room//
	}

	private boolean exist(Vehicle v) { //check if a vehicle is exist on the ferry//
		for (int i = 0; i < onVehicleList.size(); i++) {
			if (onVehicleList.get(i).getId() == v.getId()) { //check the id//
				return true; //exist//
			}
		}
		return false; //not exist//
	}
}
