package garage;

import java.util.Iterator;

public interface Garage  {
    int availableVehicleSpace();       // Available vehicle space. One car is 1.
    int countVehicles();                // Number of vehicles in the garage
    int countMoney();                  // Earned money
    Iterator<Vehicle> iterator();      // Vehicle iterator
    void enterGarage(Vehicle v);       // Enter garage, exception if not enough space
    void exitGarage(Vehicle v);        // Exit garage, exception if vehicle not in
                                       // garage
    boolean hasSpaceFor(Vehicle v);    // true if we can vehicle v can enter
    String toString();                 // Nice looking garage status print out

 }
