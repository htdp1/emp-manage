package com.htdp1.empmanage.title;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TitleRepository extends PagingAndSortingRepository<Title, TitlePK> {

	Optional<Title> findByEmpNoLast(Long empNo, Date toDate);
}
