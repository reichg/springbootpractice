package com.evolutionaryeyes.springpractice.controller;

import com.evolutionaryeyes.springpractice.entity.Department;
import com.evolutionaryeyes.springpractice.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() throws Exception {
        department = Department.builder()
                .departmentAddress("Snohomish")
                .departmentName("IT")
                .departmentId(1L)
                .departmentCode("IT-60")
                .build();
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));


    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Snohomish")
                .departmentName("IT")
                .departmentCode("IT-60")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentId\": 4,\n" +
                        "    \"departmentName\": \"CE\",\n" +
                        "    \"departmentAddress\": \"Seattle\",\n" +
                        "    \"departmentCode\": \"CE-05E-02\"\n" +
                        "}"
                )).andExpect(MockMvcResultMatchers.status().isOk());

    }
}