package com.htdp1.empmanage.department;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends CrudRepository<Department, String> {

}
