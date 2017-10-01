package com.hy.ly.springmvc.crud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hy.ly.springmvc.crud.entity.Department;
import com.hy.ly.springmvc.crud.entity.Employee;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String arg0) {
		if(arg0!=null){
			String []vals=arg0.split("-");
			if(vals!=null&&vals.length==4){
				String lastName=vals[0];
				String email=vals[1];
				Integer gender=Integer.parseInt(vals[2]);
				Department department=new Department();
				department.setId(Integer.parseInt(vals[3]));
				
				Employee employee =new Employee(null, lastName, email, gender, department);
				System.out.println(arg0 +" converter "+employee);
				return employee;
			}
		}
		return null;
	}

}
