package com.evolutionaryeyes.springpractice.service;

import com.evolutionaryeyes.springpractice.entity.Department;
import com.evolutionaryeyes.springpractice.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        // builder comes from @Builder annotation in the entity class
        Department department = Department.builder()
                .departmentName("Department Name1")
                .departmentAddress("Department Address1")
                .departmentCode("Department code")
                .departmentId(1L)
                .build();

        //
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Department Name1"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Department Name")
    public void whenValidDepartmentName_thenDepartmentIsFound() {
        String departmentName = "Department Name1";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}