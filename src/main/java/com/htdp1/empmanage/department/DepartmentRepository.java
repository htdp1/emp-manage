package com.htdp1.empmanage.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
