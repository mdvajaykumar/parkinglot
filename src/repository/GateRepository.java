package repository;

import models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository implements IGateRepository{

    Map<Long, Gate> gate =new TreeMap<>();

    @Override
    public Optional<Gate> findGateById(Long gateId) {
        if(gate.containsKey(gateId)){
            return Optional.of(gate.get(gateId));
        }

       return Optional.empty();
    }


}
