package com.htdp1.empmanage;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.htdp1.empmanage.title.Title;
import com.htdp1.empmanage.title.TitlePK;
import com.htdp1.empmanage.title.TitleRepository;

@SpringBootTest
class EmpManageApplicationTests {

	@Autowired
	TitleRepository titleRepository;

	@Test
	public void saveTitles() throws ParseException {

		Title title = Title.builder().empNo(10001L).title("test1")
				.fromDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2021-04-02"))
				.toDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("9999-12-31")).build();

		titleRepository.save(title);

		TitlePK titlePK = TitlePK.builder().empNo(10001L).title("test")
				.fromDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2021-04-02")).build();

		Optional<Title> findTitle = titleRepository.findById(titlePK);

		assertThat(findTitle.isPresent()).isEqualTo(Boolean.TRUE);
		assertThat(findTitle.get().getTitle()).isEqualTo(title.getTitle());
	}
	
	@Test
	public void updateLastTitles() throws ParseException {

		Optional<Title> findLastTitle = titleRepository.findByEmpNoLast(10004L,
				new java.text.SimpleDateFormat("yyyy-MM-dd").parse("9999-01-01"));
		
		Title findLastTitleItem = findLastTitle.get(); 
		Title updateLastTitle = Title.builder().empNo(10004L).title(findLastTitleItem.getTitle())
				.fromDate(findLastTitleItem.getFromDate())
				.toDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2021-04-02")).build();

		titleRepository.save(updateLastTitle);

		TitlePK titlePK = TitlePK.builder().empNo(10004L).title(updateLastTitle.getTitle())
				.fromDate(updateLastTitle.getFromDate()).build();

		Optional<Title> findTitle = titleRepository.findById(titlePK);

		assertThat(findTitle.isPresent()).isEqualTo(Boolean.TRUE);
		assertThat(findTitle.get().getToDate()).isEqualTo(updateLastTitle.getToDate());
	}
}
