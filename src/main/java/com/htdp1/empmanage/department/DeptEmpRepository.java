package com.htdp1.empmanage.department;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeptEmpRepository extends PagingAndSortingRepository<DeptEmp, DeptEmpPK> {
}
