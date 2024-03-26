package com.example.auto_rest.Repository;


import com.example.auto_rest.Entity.RepairData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepairDataRepository extends JpaRepository<RepairData, Long> {

    @Query(value = "select rd.* from repair_data rd " +
            "join car_data cd on rd.car_id = cd.id " +
            "join mechanic_data md on rd.mechanic_id = md.id " +
            "where cd.type ~* ?1 and cd.owner ~* ?2 and cd.model ~* ?3 and cd.firm ~* ?4 " +
            "and md.name ~* ?5 and md.surname ~* ?6 and md.specialisation ~* ?7",nativeQuery = true)
    List<RepairData> getRepairDataByKidsCustomQuery(String type, String owner, String model, String firm, String name, String surname, String specialisation);

    @Query(value = "select * from repair_data rd where rd.date > ?1",nativeQuery = true)
    List<RepairData> getRepairDataByDateAfter(LocalDate date);

    @Query(value = "select * from repair_data rd where rd.date < ?1",nativeQuery = true)
    List<RepairData> getRepairDataByDateBefore(LocalDate date);

    @Query(value = "select * from repair_data rd where rd.date between ?1 and ?2",nativeQuery = true)
    List<RepairData> getRepairDataByDateBetween(LocalDate dateStart,LocalDate dateFinish);
}
