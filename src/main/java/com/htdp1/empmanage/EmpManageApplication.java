package com.htdp1.empmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.htdp1.empmanage.department.Department;
import com.htdp1.empmanage.employee.Employee;
import com.htdp1.empmanage.title.Title;

@SpringBootApplication
public class EmpManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpManageApplication.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(config -> {
			config.exposeIdsFor(Employee.class);
			config.exposeIdsFor(Department.class);
			config.exposeIdsFor(Title.class);
		});
	}

}
