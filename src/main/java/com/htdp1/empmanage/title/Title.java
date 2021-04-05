package com.htdp1.empmanage.title;

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
@Entity(name = "titles")
@IdClass(TitlePK.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Title implements Serializable {
	@Id
	private Long empNo;
	@Id
	private String title;
	@Id
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;

	@Builder
	public Title(Long empNo, String title, Date fromDate, Date toDate) {
		this.empNo = empNo;
		this.title = title;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
}