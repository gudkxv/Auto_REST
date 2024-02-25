package com.example.auto_rest.Repository;

import com.example.auto_rest.Entity.RepairData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairDataRepository extends JpaRepository<RepairData,Long> {
}
