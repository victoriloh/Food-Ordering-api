package com.restapi.foodapi.dao;

import com.restapi.foodapi.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
