package com.htdp1.empmanage.salary;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity(name = "salaries")
@IdClass(SalaryPK.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salary implements Serializable {
	@Id
	private Long empNo;
	private Long salary;
	@Id
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;

	@Builder
	public Salary(Long empNo, Long salary, Date fromDate, Date toDate) {
		this.empNo = empNo;
		this.salary = salary;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
}