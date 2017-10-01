package com.hy.ly.springmvc.crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hy.ly.springmvc.crud.dao.EmployeeDao;
import com.hy.ly.springmvc.crud.entity.Employee;

@Controller
public class SpringmvcTest {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/testConversionService")
	public String testConverter(@RequestParam("employee") Employee employee){
		System.out.println("save: "+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
