package com.htdp1.empmanage.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerPK> {
}
