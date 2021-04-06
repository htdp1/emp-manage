package com.htdp1.empmanage.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.empmanage.department.Department;
import com.htdp1.empmanage.department.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("/v1")
@RestController
public class DepartmentController {

	private final DepartmentRepository departmentRepository;

	@GetMapping(value = "/departments")
	@Cacheable(cacheNames = "departments", key = "'findAll'", cacheManager = "cacheManager")
	public ResponseEntity<ResponseMessage> getDepartments(Sort sort) {
		log.debug("getDepartments");

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(departmentRepository.findAll(sort));

		return ResponseEntity.ok(message);

	}

	@GetMapping(value = "/departments/{deptNo}")
	@Cacheable(cacheNames = "departments", key = "#deptNo", cacheManager = "cacheManager")
	public ResponseEntity<ResponseMessage> getDepartment(@PathVariable String deptNo) {
		log.debug("getDepartment");

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(departmentRepository.findById(deptNo));

		return ResponseEntity.ok(message);
	}

	@PutMapping(value = "/departments")
	@CacheEvict(cacheNames = "departments", key = "'findAll'", cacheManager = "cacheManager")
	@CachePut(cacheNames = "departments", key = "#departmentTable.deptNo", cacheManager = "cacheManager")
	public ResponseEntity<ResponseMessage> setDepartments(@RequestBody Department departmentTable) {
		log.debug("setDepartments");

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(departmentRepository.save(departmentTable));

		return ResponseEntity.ok(message);
	}

	@DeleteMapping(value = "/departments/{deptNo}")
	@Caching(evict = { @CacheEvict(cacheNames = "departments", key = "'findAll'", cacheManager = "cacheManager"),
			@CacheEvict(cacheNames = "departments", key = "#deptNo", cacheManager = "cacheManager") })
	public ResponseEntity<ResponseMessage> deleteDepartment(@PathVariable String deptNo) {
		log.debug("deleteDepartment");

		departmentRepository.deleteById(deptNo);

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(deptNo);

		return ResponseEntity.ok(message);
	}

}
