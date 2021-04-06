package com.htdp1.empmanage.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalaryRepository extends JpaRepository<Salary, SalaryPK> {
}
