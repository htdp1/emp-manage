package com.htdp1.empmanage.employee;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TitleRepository extends JpaRepository<Title, TitlePK> {

	Optional<Title> findByEmpNoAndToDate(Long empNo, Date toDate);
}
