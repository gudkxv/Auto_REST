package com.example.auto_rest.Repository;

import com.example.auto_rest.Entity.CarData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDataRepository extends JpaRepository<CarData, Long> {

    @Query(value = "select * from car_data cd where cd.type ~* ?1 and cd.owner ~* ?2 and cd.model ~* ?3 and cd.firm ~* ?4",nativeQuery = true)
    List<CarData> getCarsByCustomQuery(String param1,String param2,String param3, String param4);
}
