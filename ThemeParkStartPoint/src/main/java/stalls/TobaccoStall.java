package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    public TobaccoStall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        super(name, ownerName, parkingSpot, rating);
    }

    public Boolean isAllowedTo(Visitor visitor) {
        if(visitor.getAge() > 17) {
            return true;
        }
        return false;
    }
}
