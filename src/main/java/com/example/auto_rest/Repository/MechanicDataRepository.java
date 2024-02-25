package com.example.auto_rest.Repository;

import com.example.auto_rest.Entity.MechanicData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicDataRepository extends JpaRepository<MechanicData,Long> {
}
