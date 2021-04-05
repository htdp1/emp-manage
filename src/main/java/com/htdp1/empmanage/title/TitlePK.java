package com.htdp1.empmanage.title;

import java.io.Serializable;
import java.util.Date;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TitlePK implements Serializable {
	private Long empNo;
	private String title;
	@Temporal(TemporalType.DATE)
	private Date fromDate;

	@Builder
	public TitlePK(Long empNo, String title, Date fromDate) {
		this.empNo = empNo;
		this.title = title;
		this.fromDate = fromDate;
	}
}