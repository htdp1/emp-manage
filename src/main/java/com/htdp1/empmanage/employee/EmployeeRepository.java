package com.htdp1.empmanage.employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
