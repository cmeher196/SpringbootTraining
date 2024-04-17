package com.example.demo.v1.repos;


import com.example.demo.v1.model.TideEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<TideEmployee, Long> {
    @Query("SELECT e.name FROM pnp_employees e WHERE e.name = ?1 AND e.address = ?2")
    List<String> findByNameAndAddress(String name, String address);

}
