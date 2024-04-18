package com.evolutionaryeyes.springpractice.service;

import com.evolutionaryeyes.springpractice.entity.Department;
import com.evolutionaryeyes.springpractice.error.DepartmentNotFoundException;

import java.util.List;


/*
 - interface for the service functions
 */
public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String departmentName);
}
