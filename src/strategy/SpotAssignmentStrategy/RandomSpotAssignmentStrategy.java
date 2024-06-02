package strategy.SpotAssignmentStrategy;

import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

import java.util.Optional;

public class RandomSpotAssignmentStrategy  implements SpotAssignmentStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        return Optional.empty();
    }
}
