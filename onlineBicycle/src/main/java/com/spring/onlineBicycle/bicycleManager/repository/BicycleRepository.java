package com.spring.onlineBicycle.bicycleManager.repository;

import com.spring.onlineBicycle.bicycleManager.models.Bicycle;
import org.springframework.data.repository.CrudRepository;

public interface BicycleRepository extends CrudRepository<Bicycle, Long> {
}
