package com.example.auto_rest.Repository;

import com.example.auto_rest.Entity.CarData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDataRepository extends JpaRepository<CarData,Long> {
}
