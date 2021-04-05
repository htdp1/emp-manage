package com.htdp1.empmanage.employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "employees")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
	@Id
	private Long empNo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
}