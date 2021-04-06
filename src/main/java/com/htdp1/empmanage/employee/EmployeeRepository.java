package com.htdp1.empmanage.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
