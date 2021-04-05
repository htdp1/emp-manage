package com.htdp1.empmanage.salary;

import java.io.Serializable;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SalaryPK implements Serializable {
	private Long empNo;
	private Date fromDate;

	@Builder
	public SalaryPK(Long empNo, Date fromDate) {
		this.empNo = empNo;
		this.fromDate = fromDate;
	}
}