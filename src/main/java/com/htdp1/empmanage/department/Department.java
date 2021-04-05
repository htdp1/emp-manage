package com.htdp1.empmanage.department;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "departments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {
	@Id
	private String deptNo;
	private String deptName;
}