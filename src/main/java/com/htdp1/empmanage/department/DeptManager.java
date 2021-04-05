package com.htdp1.empmanage.department;

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
@Entity(name = "dept_manager")
@IdClass(DeptManagerPK.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptManager implements Serializable {
	@Id
	private Long empNo;
	@Id
	private String deptNo;
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;

	@Builder
	public DeptManager(Long empNo, String deptNo, Date fromDate, Date toDate) {
		this.empNo = empNo;
		this.deptNo = deptNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
}