package garage;

public class GarageMain {

	public static void main(String[] args) {
		ImpGarage garage=new ImpGarage();
		Vehicle firstCar=new Car(1);
		Vehicle secondCar=new Car(2);
		Vehicle thirdCar=new Car(3);
		Vehicle firstBus=new Bus(4);
		Vehicle secondBus=new Bus(5);
		Vehicle thirdBus=new Bus(6);
		Vehicle fourthBus=new Bus(7);
		Vehicle firstBicycle=new Bicycle(8);
		Vehicle firstLorry=new Lorry(9);
		Vehicle secondLorry=new Lorry(142);
		Vehicle thirdLorry= new Lorry(22);
		Vehicle fourthLorry= new Lorry(11);
		
		garage.enterGarage(firstCar); 
		garage.enterGarage(secondCar);
		garage.enterGarage(thirdCar);
		garage.enterGarage(firstBus);
		garage.enterGarage(secondBus);
		garage.enterGarage(thirdBus);
		garage.enterGarage(fourthBus);
		garage.enterGarage(firstBicycle);
		garage.enterGarage(firstLorry);
		System.out.println(garage.toString());
		garage.enterGarage(secondLorry);
		garage.enterGarage(thirdLorry);
		garage.exitGarage(firstBicycle);
		garage.exitGarage(firstBicycle); //it has been exit //
		garage.enterGarage(firstCar); //it is exist//
		garage.enterGarage(fourthLorry); //no enough space//
		System.out.println(garage.toString());
		
		

	}

}
