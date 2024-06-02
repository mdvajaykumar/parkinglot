package repository;

import models.Gate;

import java.util.Optional;

public interface IGateRepository {
    Optional<Gate> findGateById(Long gateId);
}
