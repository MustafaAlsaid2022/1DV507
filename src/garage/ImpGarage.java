package garage;

import java.util.ArrayList;
import java.util.Iterator;

public class ImpGarage implements Garage {

	private int parkingSpace = 250; // based on bicycle space. if we count space
									// based on car we lose space when it is
									// more than 245 is not enough for car but
									// still a place for bicycle

	ArrayList<Vehicle> vehicleOn = new ArrayList<Vehicle>();
	ArrayList<Vehicle> vehicleOut = new ArrayList<Vehicle>();

	@Override
	public String toString() {
		return "The garage has" + " " + countVehicles() + " vehicle(s)," + " available space: "
				+ availableVehicleSpace() + " total money: " + countMoney();
	}

	@Override
	public int availableVehicleSpace() {
		int sum = 0;
		for (int i = 0; i < vehicleOn.size(); i++) {
			sum = sum + vehicleOn.get(i).getSpace();
		}

		return sum;
	}

	@Override
	public int countVehicles() {

		return vehicleOn.size();
	}

	@Override
	public int countMoney() {
		int money = 0;
		for (int i = 0; i < vehicleOn.size(); i++) {
			money = money + vehicleOn.get(i).getCost();
		}
		for (int i = 0; i < vehicleOut.size(); i++) {
			money = money + vehicleOut.get(i).getCost();
		}
		return money;
	}

	@Override
	public Iterator<Vehicle> iterator() {

		return vehicleOn.iterator();
	}

	@Override
	public void enterGarage(Vehicle v) {

		if (!exist(v) && hasSpaceFor(v)) {
			vehicleOn.add(v);
		} else if (exist(v)) {
			System.err.println("The vehicle id number " + v.getId() + " is already in");
		} else if (!exist(v) && !hasSpaceFor(v)) {
			System.err.println("There is no enough space for vehicle Id number " + v.getId());
		}

	}

	@Override
	public void exitGarage(Vehicle v) {
		if (exist(v)) {
			vehicleOn.remove(v);
			vehicleOut.add(v);
		} else {
			System.err.println("The vehicle id number " + v.getId() + " can not be exit. It is not exist");
			// System.out.println();
		}

	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		if (parkingSpace - availableVehicleSpace() >= v.getSpace()) {
			return true;
		}
		return false;
	}

	private boolean exist(Vehicle v) { // check if a vehicle is exist//
		for (int i = 0; i < vehicleOn.size(); i++) {
			if (vehicleOn.get(i).getId() == v.getId()) {
				return true;
			}
		}
		return false;
	}
}
