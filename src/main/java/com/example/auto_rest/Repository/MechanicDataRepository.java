package com.example.auto_rest.Repository;

import com.example.auto_rest.Entity.CarData;
import com.example.auto_rest.Entity.MechanicData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicDataRepository extends JpaRepository<MechanicData, Long> {

    @Query(value = "select * from mechanic_data md where md.name ~* ?1 and md.surname ~* ?2 and md.specialisation ~* ?3",nativeQuery = true)
    List<MechanicData> getMechanicDataByCustomQuery(String name, String surname, String specialisation);
}
