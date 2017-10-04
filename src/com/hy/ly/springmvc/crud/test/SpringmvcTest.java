package com.hy.ly.springmvc.crud.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.ly.springmvc.crud.dao.EmployeeDao;
import com.hy.ly.springmvc.crud.entity.Employee;

@Controller
public class SpringmvcTest {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/i18n")
	public String testI18n(Locale locale){
		String val=messageSource.getMessage("i18n.user", null, locale);
		System.out.println(val);
		
		return "i18n";
	}
	
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte []body=null;
		ServletContext servletContext=session.getServletContext();
		InputStream in=servletContext.getResourceAsStream("/files/test.txt");
		body=new byte[in.available()];
		in.read();
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=test.txt");
		HttpStatus statuscode=HttpStatus.OK;
		
		ResponseEntity<byte[]> response= new ResponseEntity<byte[]>(body, headers, statuscode);
		return response;
	}
	
	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "myFileUpload"+new Date();
	}
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getEmployees();
	}
	
	@RequestMapping("/testConversionService")
	public String testConverter(@RequestParam("employee") Employee employee){
		System.out.println("save: "+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
