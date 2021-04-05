package com.htdp1.empmanage.department;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptEmpPK implements Serializable {
	private Long empNo;
	private String deptNo;

	@Builder
	public DeptEmpPK(Long empNo, String deptNo) {
		this.empNo = empNo;
		this.deptNo = deptNo;
	}
}