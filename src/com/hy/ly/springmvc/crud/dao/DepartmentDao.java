package com.hy.ly.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hy.ly.springmvc.crud.entity.Department;

@Repository
public class DepartmentDao {
	
	private static Map<Integer,Department> departments=null;
	
	static {
		departments=new HashMap<Integer,Department>();
		departments.put(1001, new Department(1001,"D-AA"));
		departments.put(1002, new Department(1002,"D-BB"));
		departments.put(1003, new Department(1003,"D-CC"));
		departments.put(1004, new Department(1004,"D-DD"));
		departments.put(1005, new Department(1005,"D-EE"));
	}

	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
}
