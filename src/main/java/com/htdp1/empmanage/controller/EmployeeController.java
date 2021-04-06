package com.htdp1.empmanage.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.empmanage.employee.Employee;
import com.htdp1.empmanage.employee.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("/v1")
@RestController
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	@GetMapping(value = "/employees")
	public ResponseEntity<ResponseMessage> getEmployees(Pageable pageable) {
		log.debug("getEmployees");

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(employeeRepository.findAll(pageable));

		return ResponseEntity.ok(message);

	}

	@GetMapping(value = "/employees/{empNo}")
	public ResponseEntity<ResponseMessage> getEmployee(@PathVariable Long empNo) {
		log.debug("getEmployee");

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(employeeRepository.findById(empNo));

		return ResponseEntity.ok(message);
	}

	@PutMapping(value = "/employees")
	public ResponseEntity<ResponseMessage> setEmployees(@RequestBody Employee employeeTable) {
		log.debug("setEmployees");

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(employeeRepository.save(employeeTable));

		return ResponseEntity.ok(message);
	}

	@DeleteMapping(value = "/employees/{empNo}")
	public ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable Long empNo) {
		log.debug("deleteEmployee");

		employeeRepository.deleteById(empNo);

		ResponseMessage message = new ResponseMessage();
		message.setStatus(ResponseStatusEnum.OK);
		message.setMessage("success");
		message.setData(empNo);

		return ResponseEntity.ok(message);
	}

}
