package com.example.springbootf.repo;
import com.example.springbootf.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<employee, Long> {

}
