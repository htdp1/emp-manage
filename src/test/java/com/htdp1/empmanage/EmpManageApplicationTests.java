package com.htdp1.empmanage;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.htdp1.empmanage.employee.Title;
import com.htdp1.empmanage.employee.TitlePK;
import com.htdp1.empmanage.employee.TitleRepository;

@SpringBootTest
class EmpManageApplicationTests {

	@Autowired
	TitleRepository titleRepository;

	@Test
	public void saveTitles() throws ParseException {
		Long empNo = 10001L;
		Date curDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2021-04-05");
		Date maxDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("9999-01-01");

		Title title = Title.builder().empNo(empNo).title("test1").fromDate(curDate).toDate(maxDate).build();

		titleRepository.save(title);

		TitlePK titlePK = TitlePK.builder().empNo(empNo).title("test").fromDate(curDate).build();

		Optional<Title> findTitle = titleRepository.findById(titlePK);

		assertThat(findTitle.isPresent()).isEqualTo(Boolean.TRUE);
		assertThat(findTitle.get().getTitle()).isEqualTo(title.getTitle());
	}

	@Test
	public void updateLastTitles() throws ParseException {
		Long empNo = 10004L;
		Date curDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2021-04-05");
		Date maxDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse("9999-01-01");

		Optional<Title> findLastTitle = titleRepository.findByEmpNoAndToDate(empNo, maxDate);

		Title findLastTitleItem = findLastTitle.get();
		Title updateLastTitle = Title.builder().empNo(empNo).title(findLastTitleItem.getTitle())
				.fromDate(findLastTitleItem.getFromDate()).toDate(curDate).build();

		titleRepository.save(updateLastTitle);

		TitlePK titlePK = TitlePK.builder().empNo(empNo).title(updateLastTitle.getTitle())
				.fromDate(updateLastTitle.getFromDate()).build();

		Optional<Title> findTitle = titleRepository.findById(titlePK);

		assertThat(findTitle.isPresent()).isEqualTo(Boolean.TRUE);
		assertThat(findTitle.get().getToDate()).isEqualTo(updateLastTitle.getToDate());
	}
}
